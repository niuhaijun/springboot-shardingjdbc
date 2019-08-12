package com.niu.sharding.service;

import com.niu.sharding.model.Order;
import java.util.List;

/**
 * 测试数据分片策略接口类
 *
 * @Author: niuhaijun
 * @Date: 2019-05-07 16:03
 * @Version 1.0
 */
public interface ShardingService {

  void save();

  List<Order> list();


  Integer insert(Order order);

  Integer update(Order order);

  List<Order> select(Long small, Long big);

  Integer delete(Order order);
}
