package com.niu.shardingtable.service.impl;

import com.niu.shardingtable.mapper.UserMapper;
import com.niu.shardingtable.model.User;
import com.niu.shardingtable.model.UserExample;
import com.niu.shardingtable.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-03 21:19
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public int insert(User user) {

    int num = userMapper.insertSelective(user);

    return num;
  }

  @Override
  public int batchInsert(List<User> userList) {

    int num = userMapper.batchInsert(userList);
    return num;
  }

  @Override
  public User select(int id) {

    User user = userMapper.selectByPrimaryKey(id);

    return user;
  }

  @Override
  public List<User> selectAll() {

    List<User> userList = userMapper.selectByExample(new UserExample());
    return userList;
  }

  @Override
  public int update(int id, String content) {

    int num = userMapper.updateByPrimaryKeySelective(new User(id, content));
    return num;
  }

  @Override
  public int delete(int id) {

    int num = userMapper.deleteByPrimaryKey(id);

    return num;
  }

  @Override
  public int deleteAll() {

    int num = userMapper.deleteByExample(new UserExample());
    return num;
  }
}
