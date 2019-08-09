package com.niu.masterslave.service;

/**
 * @author lou
 * @Date 2019年02月28日 15:46
 * @Description 测试主从服务接口
 */
public interface MaserSlaveService {

  /**
   * 创建以及其他组合
   */
  int create();
  int createAndRead();
  int createAndUpdate();
  int createAndDelete();


  /**
   * 查询以及其他组合
   */
  int read();
  int readAndCreate();
  int readAndUpdate();
  int readAndDelete();


  /**
   * 更新以及其他组合
   */
  int update();
  int updateAndCreate();
  int updateAndRead();
  int updateAndDelete();


  /**
   * 删除以及其他组合
   */
  int delete();
  int deleteAndRead();
  int deleteAndCreate();
  int deleteAndUpdate();
}
