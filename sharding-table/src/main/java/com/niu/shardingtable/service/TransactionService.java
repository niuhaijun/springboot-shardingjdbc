package com.niu.shardingtable.service;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-04 15:33
 * @Version 1.0
 */
public interface TransactionService {

  /**
   * 插入
   */
  void c(int id, String content);

  /**
   * 查询
   */
  void r(int id);

  /**
   * 更新
   */
  void u(int id, String content);

  /**
   * 删除
   */
  void d(int id);


  /**
   * c 与各种组合
   */
  void c_r(int id, String content);

  void c_u(int id, String content);

  void c_d(int id, String content);

  /**
   * r 与各种组合
   */
  void r_c(int id, String content);

  void r_u(int id, String content);

  void r_d(int id);

  /**
   * u 与各种组合
   */
  void u_c(int id, String content);

  void u_r(int id, String content);

  void u_d(int id, String content);

  /**
   * d 与各种组合
   */
  void d_c(int id, String content);

  void d_r(int id);

  void d_u(int id, String content);
}
