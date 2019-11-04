package com.niu.shardingtable.service.impl;

import com.niu.shardingtable.mapper.UserMapper;
import com.niu.shardingtable.model.User;
import com.niu.shardingtable.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单表CRUD 有事务
 *
 * @Author: niuhaijun
 * @Date: 2019-11-04 15:24
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
@Slf4j
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public void c(int id, String content) {

    int num = userMapper.insertSelective(new User(id, content));
    log.info("insert result is {}", num);
  }

  @Override
  public void r(int id) {

    User user = userMapper.selectByPrimaryKey(id);
    log.info("select result is {}", user);
  }

  @Override
  public void u(int id, String content) {

    int num = userMapper.updateByPrimaryKeySelective(new User(id, content + content));
    log.info("update num is {}", num);
  }

  @Override
  public void d(int id) {

    int num = userMapper.deleteByPrimaryKey(id);
    log.info("deleted num is {}", num);
  }

  @Override
  public void c_r(int id, String content) {

    c(id, content);
    r(id);
  }

  @Override
  public void c_u(int id, String content) {

    c(id, content);
    u(id, content + content);
  }

  @Override
  public void c_d(int id, String content) {

    c(id, content);
    d(id);
  }

  @Override
  public void r_c(int id, String content) {

    r(id);
    c(id, content);
  }

  @Override
  public void r_u(int id, String content) {

    r(id);
    u(id, content + content);
  }

  @Override
  public void r_d(int id) {

    r(id);
    d(id);
  }

  @Override
  public void u_c(int id, String content) {

    u(id, content + content);
    c(id, content);
  }

  @Override
  public void u_r(int id, String content) {

    u(id, content + content);
    r(id);
  }


  @Override
  public void u_d(int id, String content) {

    u(id, content + content);
    d(id);
  }

  @Override
  public void d_c(int id, String content) {

    d(id);
    c(id, content);
  }

  @Override
  public void d_r(int id) {

    d(id);
    r(id);
  }

  @Override
  public void d_u(int id, String content) {

    d(id);
    u(id, content + content);
  }

}

