package com.niu.sharding.service;

import com.niu.ShardingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@Slf4j
public class MasterSlaveServiceTest {

  @Autowired
  private ShardingService shardingService;

  // ------   create   ------  //
  @Test
  public void create() {

    shardingService.create();
  }

  @Test
  public void createAndRead() {

    shardingService.createAndRead();
  }

  @Test
  public void createAndUpdate() {

    shardingService.createAndUpdate();
  }

  @Test
  public void createAndDelete() {

    shardingService.createAndDelete();
  }


  // ------   read   ------  //
  @Test
  public void read() {

    shardingService.read();
  }

  @Test
  public void readAndCreate() {

    shardingService.readAndCreate();
  }

  @Test
  public void readAndUpdate() {

    shardingService.readAndUpdate();
  }

  @Test
  public void readAndDelete() {

    shardingService.readAndDelete();
  }


  // ------   update   ------  //
  @Test
  public void update() {

    shardingService.update();
  }

  @Test
  public void updateAndCreate() {

    shardingService.updateAndCreate();
  }

  @Test
  public void updateAndRead() {

    shardingService.updateAndRead();
  }

  @Test
  public void updateAndDelete() {

    shardingService.updateAndDelete();
  }


  // ------   delete   ------  //
  @Test
  public void delete() {

    shardingService.delete();
  }

  @Test
  public void deleteAndCreate() {

    shardingService.deleteAndCreate();
  }

  @Test
  public void deleteAndRead() {

    shardingService.deleteAndRead();
  }

  @Test
  public void deleteAndUpdate() {

    shardingService.deleteAndUpdate();
  }

}