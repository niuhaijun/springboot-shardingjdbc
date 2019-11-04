package com.niu.shardingtable.service;

import com.niu.shardingtable.ShardingTableApplication;
import com.niu.shardingtable.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 非事务性CRUD操作
 *
 * 查询走 从库
 * 插入、删除、更新 走 主库
 *
 *
 * @Author: niuhaijun
 * @Date: 2019-11-03 21:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingTableApplication.class)
@Slf4j
public class UserServiceImplTest {

  private int id = 1;
  private int num = 20;

  @Autowired
  private UserService userService;

  @Test
  public void insert() {

    User user = new User(id, String.valueOf(id));
    int num = userService.insert(user);
    log.info("insert num is {}", num);
  }

  @Test
  public void batchInsert() {

    List<User> list = new ArrayList<>(num);
    for (int i = 0; i < num; i++) {
      list.add(new User(i, String.valueOf(i)));
    }
    int insertNum = userService.batchInsert(list);
    log.info("batchInsert num is {}", insertNum);
  }

  @Test
  public void select() {

    User user = userService.select(id);
    log.info("id is 1, user is {}", user);
  }

  @Test
  public void selectAll() {

    List<User> list = userService.selectAll();
    log.info("selectAll {}", list);
  }

  @Test
  public void update() {

    int num = userService.update(id, "1 -> 2");
    log.info("update num is {}", num);
  }

  @Test
  public void delete() {

    int num = userService.delete(id);
    log.info("deleted num is {}", num);
  }

  @PostConstruct
  public void afterPropertiesSet() {

    int num = userService.deleteAll();
    log.info("deleted num is {}", num);
  }
}
