package com.niu.masterslave.service.impl;

import com.niu.masterslave.mapper.OrderMapper;
import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import com.niu.masterslave.service.MaserSlaveService;
import com.niu.masterslave.utils.UUIDUtils;
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


  // ----------   CRUD --------- //
  private int c() {

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

  private int r() {

    return orderMapper.countByExample(new OrderExample());
  }

  private int u() {

    Order record = new Order();
    record.setOrderId(100L);

    OrderExample example = new OrderExample();
    example.createCriteria().andOrderIdGreaterThan(0L);

    return orderMapper.updateByExampleSelective(record, example);
  }

  private int d() {

    return orderMapper.deleteByExample(new OrderExample());
  }


  // ----------   创建以及组合方法 --------- //
  @Override
  public int create() {

    return c();
  }

  @Override
  public int createAndRead() {

    int result = 0;
    result += c();
    result += r();
    return result;
  }

  @Override
  public int createAndUpdate() {

    int result = 0;
    result += c();
    result += u();
    return result;

  }

  @Override
  public int createAndDelete() {

    int result = 0;
    result += c();
    result += d();
    return result;
  }


  // ----------   查询以及组合方法 --------- //
  @Override
  public int read() {

    return r();

  }

  @Override
  public int readAndCreate() {

    int result = 0;
    result += r();
    result += c();
    return result;
  }

  @Override
  public int readAndUpdate() {

    int result = 0;
    result += r();
    result += u();
    return result;
  }

  @Override
  public int readAndDelete() {

    int result = 0;
    result += r();
    result += d();
    return result;
  }


  // ----------   更新以及组合方法 --------- //
  @Override
  public int update() {

    return u();
  }

  @Override
  public int updateAndCreate() {

    int result = 0;
    result += u();
    result += c();
    return result;
  }

  @Override
  public int updateAndRead() {

    int result = 0;
    result += u();
    result += r();
    return result;
  }

  @Override
  public int updateAndDelete() {

    int result = 0;
    result += u();
    result += d();
    return result;
  }


  // ----------   删除以及组合方法 --------- //
  @Override
  public int delete() {

    return d();
  }

  @Override
  public int deleteAndRead() {

    int result = 0;
    result += d();
    result += r();
    return result;
  }

  @Override
  public int deleteAndCreate() {

    int result = 0;
    result += d();
    result += c();
    return result;
  }

  @Override
  public int deleteAndUpdate() {

    int result = 0;
    result += d();
    result += u();
    return result;
  }


}
