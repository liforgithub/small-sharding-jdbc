package com.lxy.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author lixueyang
 * @since 2021/12/23 14:16
 */
public class MyRangeTableShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        String logicTableName = rangeShardingValue.getLogicTableName();
        Long lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
        Long upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();

        System.out.println(logicTableName);
        System.out.println(lowerEndpoint);
        System.out.println(upperEndpoint);

        return Arrays.asList(logicTableName + "_1", logicTableName + "_2");
    }
}
