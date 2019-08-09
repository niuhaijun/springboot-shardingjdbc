package com.niu.masterslave.service;

import com.niu.masterslave.model.Order;
import java.util.List;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 测试主从服务接口
 */
public interface MaserSlaveService {

  int create();

  List<Order> read();

  int update();

  int delete();

  int createAndRead();
}
