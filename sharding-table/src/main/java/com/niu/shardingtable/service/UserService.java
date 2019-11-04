package com.niu.shardingtable.service;

import com.niu.shardingtable.model.User;
import java.util.List;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-03 21:19
 * @Version 1.0
 */
public interface UserService {

  int insert(User user);

  int batchInsert(List<User> userList);

  User select(int id);

  List<User> selectAll();

  int update(int id, String content);

  int delete(int id);

  int deleteAll();

}
