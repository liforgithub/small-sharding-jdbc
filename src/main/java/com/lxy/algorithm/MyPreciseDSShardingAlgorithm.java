package com.lxy.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author lixueyang
 * @since 2021/12/23 14:17
 */
public class MyPreciseDSShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        Long value = preciseShardingValue.getValue();

        BigInteger a = BigInteger.valueOf(value).mod(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
        String key = "m" + a;
        if (collection.contains(key)) {
            return key;
        }
        throw new UnsupportedOperationException("route " + key + " is not support");
    }
}
