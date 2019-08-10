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
   * 非事务方法，【插入】如【master】
   *
   * 事务方法，【插入】如【master】
   */
  @Test
  public void create() {

    maserSlaveService.create();
  }


  /**
   * 非事务方法，【插入】走【master】，【查询】走【slave0】
   *
   * 事务方法，【插入】走【master】，【查询】走【master】
   */
  @Test
  public void createAndRead() {

    maserSlaveService.createAndRead();
  }


  /**
   * 非事务方法，【插入】走【master】，【更新】走【master】
   *
   * 事务方法，【插入】走【master】，【更新】走【master】
   */
  @Test
  public void createAndUpdate() {

    maserSlaveService.createAndUpdate();
  }


  /**
   * 非事务方法，【插入】走【master】，【删除】走【master】
   *
   * 事务方法，【插入】走【master】，【删除】走【master】
   */
  @Test
  public void createAndDelete() {

    maserSlaveService.createAndDelete();
  }

  // ------   read   ------  //

  /**
   * 非事务方法，【查询】走【slave0】
   *
   * 事务方法，【查询】走【slave0】
   */
  @Test
  public void read() {

    maserSlaveService.read();
  }

  /**
   * 非事务方法，查询走【slave0】，插入走【master】
   *
   * 事务方法，查询走【slave0】，插入走【master】
   */
  @Test
  public void readAndCreate() {

    maserSlaveService.readAndCreate();
  }

  /**
   * 非事务方法，查询走【slave0】, 更新走【master】
   *
   * 事务方法，查询走【slave0】, 更新走【master】
   */
  @Test
  public void readAndUpdate() {

    maserSlaveService.readAndUpdate();
  }

  /**
   * 非事务方法，【查询】走【slave0】, 【删除】走【master】
   *
   * 事务方法，【查询】走【slave0】, 【删除】走【master】
   */
  @Test
  public void readAndDelete() {

    maserSlaveService.readAndDelete();
  }

  // ------   update   ------  //

  /**
   * 非事务方法，【更新】走【master】
   *
   * 事务方法，【更新】走【master】
   */
  @Test
  public void update() {

    maserSlaveService.update();
  }

  /**
   * 非事务方法，【更新】走【master】, 【创建】走【master】
   *
   * 事务方法，【更新】走【master】, 【创建】走【master】
   */
  @Test
  public void updateAndCreate() {

    maserSlaveService.updateAndCreate();
  }

  /**
   * 非事务方法，【更新】走【master】, 【查询】走【slave0】
   *
   * 事务方法，【更新】走【master】, 【查询】走【master】
   */
  @Test
  public void updateAndRead() {

    maserSlaveService.updateAndRead();
  }

  /**
   * 非事务方法，【更新】走【master】, 【删除】走【master】
   *
   * 事务方法，【更新】走【master】, 【删除】走【master】
   */
  @Test
  public void updateAndDelete() {

    maserSlaveService.updateAndDelete();
  }

  // ------   delete   ------  //

  /**
   * 非事务方法，【删除】走【master】
   *
   * 事务方法，【删除】走【master】
   */
  @Test
  public void delete() {

    maserSlaveService.delete();
  }

  /**
   * 非事务方法，【删除】走【master】, 【创建】走【master】
   *
   * 事务方法，【删除】走【master】, 【创建】走【master】
   */
  @Test
  public void deleteAndCreate() {

    maserSlaveService.deleteAndCreate();
  }

  /**
   * 非事务方法，【删除】走【master】, 【查询】走【slave0】
   *
   * 事务方法，【删除】走【master】, 【查询】走【master】
   */
  @Test
  public void deleteAndRead() {

    maserSlaveService.deleteAndRead();
  }

  /**
   * 非事务方法，【删除】走【master】, 【更新】走【master】
   *
   * 事务方法，【删除】走【master】, 【更新】走【master】
   */
  @Test
  public void deleteAndUpdate() {

    maserSlaveService.deleteAndUpdate();
  }

}