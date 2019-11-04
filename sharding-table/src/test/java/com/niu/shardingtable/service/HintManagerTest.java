package com.niu.shardingtable.service;

import com.niu.shardingtable.ShardingTableApplication;
import com.niu.shardingtable.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 编码强制路由
 *
 * @Author: niuhaijun
 * @Date: 2019-11-04 15:14
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingTableApplication.class)
@Slf4j
public class HintManagerTest {

  private int id = 1;
  private int num = 20;

  @Autowired
  private UserService userService;

  @Test
  public void selectMasterDatasource() {

    HintManager hintManager = HintManager.getInstance();

    /*
     * 强制路由到主库
     */
    hintManager.setMasterRouteOnly();

    User user = userService.select(id);
    log.info("select result is {}", user);
  }

}
