package com.niu.shardingtable.service;

import com.niu.ShardingTableApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 事务性方法
 *
 *
 * 先读后写： 读走从库， 写走主库
 * 先写后读： 写走主库， 读走从库
 *
 * @Author: niuhaijun
 * @Date: 2019-11-04 15:23
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingTableApplication.class)
@Slf4j
public class TransactionTest {

  int id = 1;

  @Autowired
  private TransactionService service;


  /**
   * Actual SQL: master-ds ::: insert into t_user_1
   */
  @Test
  public void c() {

    service.c(id, String.valueOf(id));
  }

  /**
   * Actual SQL: slave-ds ::: select
   */
  @Test
  public void r() {

    service.r(id);
  }

  /**
   * Actual SQL: master-ds ::: update t_user_1
   */
  @Test
  public void u() {

    service.u(id, String.valueOf(id));
  }

  /**
   * Actual SQL: master-ds ::: delete from t_user_1
   */
  @Test
  public void d() {

    service.d(id);
  }


  /**
   * Actual SQL: master-ds ::: insert into t_user_1
   * Actual SQL: master-ds ::: select
   */
  @Test
  public void c_r() {

    service.c_r(id, String.valueOf(id));
  }

  /**
   * Actual SQL: master-ds ::: insert into t_user_1
   * Actual SQL: master-ds ::: update t_user_1
   */
  @Test
  public void c_u() {

    service.c_u(id, String.valueOf(id + id));
  }

  /**
   * Actual SQL: master-ds ::: insert into t_user_1
   * Actual SQL: master-ds ::: delete from t_user_1
   */
  @Test
  public void c_d() {

    service.c_d(id, String.valueOf(id));
  }

  /**
   * Actual SQL: slave-ds ::: select
   * Actual SQL: master-ds ::: insert into t_user_1
   */
  @Test
  public void r_c() {

    service.r_c(id, String.valueOf(id));
  }

  /**
   * Actual SQL: slave-ds ::: select
   * Actual SQL: master-ds ::: update t_user_1
   */
  @Test
  public void r_u() {

    service.r_u(id, String.valueOf(id));
  }

  /**
   * Actual SQL: slave-ds ::: select
   * Actual SQL: master-ds ::: delete from t_user_1
   */
  @Test
  public void r_d() {

    service.r_d(id);
  }

  /**
   * Actual SQL: master-ds ::: update t_user_1
   * Actual SQL: master-ds ::: insert into t_user_2
   */
  @Test
  public void u_c() {

    service.u_c(id, String.valueOf(id));
  }

  /**
   * Actual SQL: master-ds ::: update t_user_1
   * Actual SQL: master-ds ::: select
   */
  @Test
  public void u_r() {

    service.u_r(id, String.valueOf(id));
  }

  /**
   * Actual SQL: master-ds ::: update t_user_1
   * Actual SQL: master-ds ::: delete from t_user_1
   */
  @Test
  public void u_d() {

    service.u_d(id, String.valueOf(id));
  }

  /**
   * Actual SQL: master-ds ::: delete from t_user_1
   * Actual SQL: master-ds ::: insert into t_user_1
   */
  @Test
  public void d_c() {

    service.d_c(id, String.valueOf(id));
  }


  /**
   * Actual SQL: master-ds ::: delete from t_user_1
   * Actual SQL: master-ds ::: select
   */
  @Test
  public void d_r() {

    service.d_r(id);
  }

  /**
   * Actual SQL: master-ds ::: delete from t_user_1
   * Actual SQL: master-ds ::: update t_user_1
   */
  @Test
  public void d_u() {

    service.d_u(id, String.valueOf(id));
  }

}
