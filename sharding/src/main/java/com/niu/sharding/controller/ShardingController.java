package com.niu.sharding.controller;

import com.niu.sharding.model.Order;
import com.niu.sharding.service.ShardingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: niuhaijun
 * @Date: 2019-05-07 19:47
 * @Version 1.0
 */
@RestController
@RequestMapping("sharding")
public class ShardingController {

  @Autowired
  private ShardingService shardingService;

  @RequestMapping("insert")
  public Integer insert(Order order) {

    return shardingService.insert(order);
  }

  @RequestMapping("update")
  public Integer update(Order order) {

    return shardingService.update(order);
  }

  @RequestMapping("select")
  public List<Order> select(Long small, Long big) {

    return shardingService.select(small, big);
  }

  @RequestMapping("delete")
  public Integer delete(Order order) {

    return shardingService.delete(order);
  }
}
