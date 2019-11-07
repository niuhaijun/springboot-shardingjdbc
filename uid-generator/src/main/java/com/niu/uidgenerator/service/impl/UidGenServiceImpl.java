package com.niu.uidgenerator.service.impl;

import com.niu.uidgenerator.UidGenerator;
import com.niu.uidgenerator.service.UidGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: niuhaijun
 * @date: 2019-11-07 12:54
 * @version: 1.0
 * @description: xxx
 */
@Service
public class UidGenServiceImpl implements UidGenService {

  //  @Resource(name = "cachedUidGenerator")
  @Autowired
  private UidGenerator uidGenerator;

  @Override
  public long getUID() {

    return uidGenerator.getUID();
  }

  @Override
  public String parseUID(long uid) {

    return uidGenerator.parseUID(uid);
  }

}
