package com.niu.shardingtable.algorithm;

import com.niu.shardingtable.utils.SnowFlake;
import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-01 16:36
 * @Version 1.0
 */
public class UserTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> availableTargetNames,
      PreciseShardingValue<Long> shardingValue) {

    if (shardingValue == null || shardingValue.getValue() == null) {
      throw new RuntimeException("error");
    }

    String yearAndMonth = SnowFlake.getYearAndMonth(shardingValue.getValue());
    String tableName = availableTargetNames.stream().filter(t -> t.endsWith(yearAndMonth))
        .findFirst().orElse(null);

    if (tableName == null) {
      throw new RuntimeException("error");
    }

    return tableName;
  }
}
