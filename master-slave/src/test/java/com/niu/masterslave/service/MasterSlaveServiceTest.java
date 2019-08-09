package com.niu.masterslave.service;

import com.niu.masterslave.MasterSlaveApplication;
import com.niu.masterslave.model.Order;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MasterSlaveApplication.class)
public class MasterSlaveServiceTest {

  @Autowired
  private MaserSlaveService maserSlaveService;


  @Test
  public void testSave() {

    maserSlaveService.save();
    System.out.println("-------插入成功");
  }


  @Test
  public void testList() {

    List<Order> records = maserSlaveService.list();
    System.out.println("--------count:" + records.size());
  }


  @Test
  public void saveAndSelect() {

    Integer count = maserSlaveService.saveAndSelect();
    System.out.println("--------save select success:" + count);
  }
}