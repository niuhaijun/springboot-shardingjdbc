package com.niu.sharding.service.impl;

import com.niu.sharding.mapper.OrderMapper;
import com.niu.sharding.model.Order;
import com.niu.sharding.model.OrderExample;
import com.niu.sharding.model.OrderExample.Criteria;
import com.niu.sharding.service.ShardingService;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author lou
 * @Date 2019年02月28日 17:32
 * @Description 测试数据分片策略实现类
 */
@Service
public class ShardingServiceImpl implements ShardingService {

  @Autowired
  private OrderMapper orderMapper;

  /**
   * 以下方法是测试方法
   */
  @Override
  public void save() {

    Random random = new Random();

    long[] orderIds = random.longs(1, 100).limit(1000).toArray();
    long[] numbers = random.longs(1, 100).limit(1000).toArray();
    for (int m = 0; m < 1000; m++) {
      Long orderId = orderIds[m];
      Long number = numbers[m];
      Order record = new Order();
      record.setUuid(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
      record.setOrderId(orderId);
      record.setUserId(number);
      record.setContent("test" + number);
      orderMapper.insert(record);
    }
  }

  @Override
  public List<Order> list() {

    return orderMapper.selectByExample(new OrderExample());
  }

  /**
   * 以下方法是请求方法
   */
  @Override
  public Integer insert(Order order) {

    if (StringUtils.isEmpty(order.getUuid())) {
      order.setUuid(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
    }
    return orderMapper.insertSelective(order);
  }

  @Override
  public Integer update(Order order) {

    OrderExample example = new OrderExample();
    example.createCriteria().andUuidEqualTo(order.getUuid());

    Order record = new Order();
    BeanUtils.copyProperties(order, record);
    return orderMapper.updateByExampleSelective(record, example);
  }

  @Override
  public List<Order> select(Long small, Long big) {

    OrderExample example = new OrderExample();
    example.createCriteria().andUserIdGreaterThan(small).andOrderIdLessThanOrEqualTo(big);

//    example.createCriteria().andUserIdBetween(small, big).andOrderIdBetween(small, big);
    return orderMapper.selectByExample(example);
  }

  @Override
  public Integer delete(Order order) {

    OrderExample example = new OrderExample();
    Criteria criteria = example.createCriteria();
    if (order.getUuid() != null) {
      criteria.andUuidEqualTo(order.getUuid());
    }
    if (order.getUserId() != null) {
      criteria.andUserIdEqualTo(order.getUserId());
    }
    if (order.getOrderId() != null) {
      criteria.andOrderIdEqualTo(order.getOrderId());
    }
    return orderMapper.deleteByExample(example);
  }
}
