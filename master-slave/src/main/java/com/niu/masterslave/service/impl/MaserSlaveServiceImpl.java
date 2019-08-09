package com.niu.masterslave.service.impl;

import com.niu.masterslave.mapper.OrderMapper;
import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import com.niu.masterslave.service.MaserSlaveService;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 测试主从服务实现类
 **/
@Service
public class MaserSlaveServiceImpl implements MaserSlaveService {

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
    for (int m = 0; m < 100; m++) {
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

  @Transactional
  @Override
  public Integer saveAndSelect() {

    Random random = new Random();

    long[] orderIds = random.longs(1, 100).limit(1000).toArray();
    long[] numbers = random.longs(1, 100).limit(1000).toArray();
    for (int m = 0; m < 100; m++) {
      Long orderId = orderIds[m];
      Long number = numbers[m];
      Order record = new Order();
      record.setUuid(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
      record.setOrderId(orderId);
      record.setUserId(number);
      record.setContent("test" + number);
      orderMapper.insert(record);
    }

    List<Order> list = orderMapper.selectByExample(new OrderExample());
    return list.size();
  }


}
