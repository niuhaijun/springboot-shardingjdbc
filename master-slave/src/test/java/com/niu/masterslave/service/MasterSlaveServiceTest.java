package com.niu.masterslave.service;

import com.niu.masterslave.MasterSlaveApplication;
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

  // ------   create   ------  //

  /**
   * 非事务方法，走【master】
   *
   */
  @Test
  public void create() {

    int result = maserSlaveService.create();
    log.info("-------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，插入走【master】，查询走【slave0】
   */
  @Test
  public void createAndRead() {

    int result = maserSlaveService.createAndRead();
    log.info("--------方法的执行结果 {}", result == 0);
  }

  @Test
  public void createAndUpdate() {

    int result = maserSlaveService.createAndUpdate();
    log.info("-------方法的执行结果 {}", result == 10);
  }

  @Test
  public void createAndDelete() {

    int result = maserSlaveService.createAndDelete();
    log.info("-------方法的执行结果 {}", result == 10);
  }

  // ------   read   ------  //

  /**
   * 非事务方法，走【slave0】
   */
  @Test
  public void read() {

    int result = maserSlaveService.read();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【slave0】
   */
  @Test
  public void readAndCreate() {

    int result = maserSlaveService.readAndCreate();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【slave0】
   */
  @Test
  public void readAndUpdate() {

    int result = maserSlaveService.readAndUpdate();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【slave0】
   */
  @Test
  public void readAndDelete() {

    int result = maserSlaveService.readAndDelete();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  // ------   update   ------  //

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void update() {

    int result = maserSlaveService.update();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void updateAndCreate() {

    int result = maserSlaveService.updateAndCreate();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void updateAndRead() {

    int result = maserSlaveService.updateAndRead();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void updateAndDelete() {

    int result = maserSlaveService.updateAndDelete();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  // ------   delete   ------  //

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void delete() {

    int result = maserSlaveService.delete();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void deleteAndCreate() {

    int result = maserSlaveService.deleteAndCreate();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void deleteAndRead() {

    int result = maserSlaveService.deleteAndRead();
    log.info("--------方法的执行结果 {}", result == 10);
  }

  /**
   * 非事务方法，走【master】
   */
  @Test
  public void deleteAndUpdate() {

    int result = maserSlaveService.deleteAndUpdate();
    log.info("--------方法的执行结果 {}", result == 10);
  }

}