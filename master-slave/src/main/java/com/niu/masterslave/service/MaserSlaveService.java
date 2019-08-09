package com.niu.masterslave.service;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 测试主从服务接口
 */
public interface MaserSlaveService {

  int create();

  int read();

  int update();

  int delete();

  int createAndRead();
}
