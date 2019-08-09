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
   * 插入10条数据
   *
   * order_id 和 user_id的范围都是[1, 10]
   */
  @Override
  public int create() {

    int result = 0;

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
      result += orderMapper.insert(record);
    }

    return result;
  }

  @Override
  public int read() {

    return orderMapper.countByExample(new OrderExample());
  }

  @Override
  public int update() {

    Order record = new Order();
    record.setOrderId(100L);

    OrderExample example = new OrderExample();
    example.createCriteria().andOrderIdGreaterThan(0L);

    return orderMapper.updateByExampleSelective(record, example);
  }

  @Override
  public int delete() {

    return orderMapper.deleteByExample(new OrderExample());

  }

  @Override
  public int createAndRead() {

    int result = 0;

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
      result += orderMapper.insert(record);
    }

    List<Order> list = orderMapper.selectByExample(new OrderExample());
    result += list.size();
    return result;
  }


}
