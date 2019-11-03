package com.niu.shardingtable.user;

import com.niu.shardingtable.ShardingTableApplication;
import com.niu.shardingtable.mapper.UserMapper;
import com.niu.shardingtable.model.User;
import com.niu.shardingtable.model.UserExample;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingTableApplication.class)
@Slf4j
public class UserApplicationTests {

  @Autowired
  private UserMapper userMapper;

  private void deleteUsers() {

    int num = userMapper.deleteByExample(new UserExample());
    log.info("deleted num {}", num);
  }

  @Test
  public void save() {

    deleteUsers();

    int id = 1;
    User user = new User(id, String.valueOf(1));
    int num = userMapper.insert(user);
    log.info("save num {}", num);

  }

  @Test
  public void batchSave() {

    deleteUsers();

    List<User> userList = new ArrayList<>();
    int nums = 20;

    for (int i = 1; i <= nums; i++) {
      User user = new User(i, String.valueOf(i));
      userList.add(user);
    }

    int count = userMapper.batchInsert(userList);
    log.info("batchSave num {}", count);
  }

  @Test
  public void select() {

    int id = 1;
    User user = userMapper.selectByPrimaryKey(id);
    log.info("user = {}", user);
  }

  @Test
  public void update() {

    UserExample condition = new UserExample();
    condition.createCriteria()
        .andIdEqualTo(1);
    User content = new User(null, "1->2");
    int num = userMapper.updateByExampleSelective(content, condition);
    log.info("update num {}", num);
  }

  @Test
  public void delete() {

    int num = userMapper.deleteByPrimaryKey(1);
    log.info("delete num {}", num);
  }

  @Test
  public void deleteAll() {

    deleteUsers();
  }

  @Test
  public void forceRouteMaster() {

    HintManager.getInstance().setMasterRouteOnly();

    int id = 1;
    User user = userMapper.selectByPrimaryKey(id);
    log.info("{}", user);
  }

}
