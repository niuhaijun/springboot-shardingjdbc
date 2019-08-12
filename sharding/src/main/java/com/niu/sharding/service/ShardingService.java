package com.niu.sharding.service;

/**
 * 测试数据分片策略接口类
 *
 * @Author: niuhaijun
 * @Date: 2019-05-07 16:03
 * @Version 1.0
 */
public interface ShardingService {

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
