package com.lxy.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author lixueyang
 * @since 2021/12/23 14:17
 */
public class MyPreciseTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        String logicTableName = preciseShardingValue.getLogicTableName();
        Long value = preciseShardingValue.getValue();

        BigInteger a = BigInteger.valueOf(value).mod(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
        String table = logicTableName + "_" + a;
        if (collection.contains(table)) {
            return table;
        }
        throw new UnsupportedOperationException("route " + table + " is not support");
    }
}
