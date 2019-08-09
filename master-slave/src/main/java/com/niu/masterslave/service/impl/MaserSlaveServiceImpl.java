package com.niu.masterslave.service.impl;

import com.niu.masterslave.mapper.OrderMapper;
import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import com.niu.masterslave.service.MaserSlaveService;
import com.niu.masterslave.utils.UUIDUtils;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 主从服务实现类
 **/
@Service
@Slf4j
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

    log.info("create: {}", result);
    return result;
  }

  private int r() {

    int result = 0;
    result += orderMapper.countByExample(new OrderExample());

    log.info("read: {}", result);
    return orderMapper.countByExample(new OrderExample());
  }

  private int u() {

    int result = 0;

    Order record = new Order();
    record.setOrderId(100L);

    OrderExample example = new OrderExample();
    example.createCriteria().andOrderIdGreaterThan(0L);
    result += orderMapper.updateByExampleSelective(record, example);

    log.info("update: {}", result);
    return result;
  }

  private int d() {

    int result = 0;
    result += orderMapper.deleteByExample(new OrderExample());

    log.info("delete: {}", result);
    return result;
  }


  // ----------   创建以及组合方法 --------- //
  @Override
  public int create() {

    int result = 0;
    result += c();

    return result;

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

    int result = 0;
    result += r();
    return result;

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

    int result = 0;
    result += u();

    return result;
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

    int u = u();

    int r = r();
    return u + r;
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
