package com.niu.masterslave.service.impl;

import com.niu.masterslave.mapper.OrderMapper;
import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import com.niu.masterslave.service.MaserSlaveService;
import com.niu.masterslave.utils.UUIDUtils;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 主从服务实现类
 **/
@Service
public class MaserSlaveServiceImpl implements MaserSlaveService {

  @Autowired
  private OrderMapper orderMapper;

  /**
   * 非事务方法，插入数据走主库
   */
  @Override
  public void save() {

    Random random = new Random();

    long[] orderIds = random.longs(1, 10).limit(10).toArray();
    long[] numbers = random.longs(1, 10).limit(10).toArray();
    for (int m = 0; m < 10; m++) {
      Long orderId = orderIds[m];
      Long number = numbers[m];
      Order record = new Order();
      record.setUuid(UUIDUtils.getUUID());
      record.setOrderId(orderId);
      record.setUserId(number);
      record.setContent("test: " + number);
      orderMapper.insert(record);
    }
  }

  /**
   * 非事务方法，查询走从库
   */
  @Override
  public List<Order> list() {

    return orderMapper.selectByExample(new OrderExample());
  }

  /**
   * 非事务方法，插入走主库，查询走从库
   */
  @Override
  public Integer saveAndSelect() {

    Random random = new Random();

    long[] orderIds = random.longs(1, 10).limit(10).toArray();
    long[] numbers = random.longs(1, 10).limit(10).toArray();
    for (int m = 0; m < 10; m++) {
      Long orderId = orderIds[m];
      Long number = numbers[m];
      Order record = new Order();
      record.setUuid(UUIDUtils.getUUID());
      record.setOrderId(orderId);
      record.setUserId(number);
      record.setContent("test " + number);
      orderMapper.insert(record);
    }

    List<Order> list = orderMapper.selectByExample(new OrderExample());
    return list.size();
  }


}
