package com.niu.sharding.utils;

import java.util.UUID;

/**
 * @Author: niuhaijun
 * @Date: 2019-08-09 23:22
 * @Version 1.0
 */
public class UUIDUtils {

  private UUIDUtils() {

    throw new RuntimeException("不允许实例化!!!");
  }

  /**
   * 获取32位UUID
   *
   * UUID的版本4
   */
  public static String getUUID() {

    return UUID.randomUUID().toString().replaceAll("-", "");
  }


}
