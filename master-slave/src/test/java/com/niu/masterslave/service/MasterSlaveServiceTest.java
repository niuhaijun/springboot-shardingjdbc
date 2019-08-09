package com.niu.masterslave.service;

import com.niu.masterslave.MasterSlaveApplication;
import com.niu.masterslave.model.Order;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MasterSlaveApplication.class)
@Slf4j
public class MasterSlaveServiceTest {

  @Autowired
  private MaserSlaveService maserSlaveService;

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void create() {

    int result = maserSlaveService.create();
    log.info("-------create 方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【slave0】
   */
  @Test
  public void read() {

    int result = maserSlaveService.read();
    log.info("--------read 方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void update() {

    int result = maserSlaveService.update();
    log.info("--------update 方法的执行结果 {}", result == 10);
  }


  /**
   * 非事务方法，走【master】
   */
  @Test
  public void delete() {

    int result = maserSlaveService.delete();
    log.info("--------delete 方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，插入走【master】，查询走【slave0】
   */
  @Test
  public void createAndRead() {

    int result = maserSlaveService.createAndRead();
    log.info("--------createAndRead 方法的执行结果 {}", result == 0);
  }
}