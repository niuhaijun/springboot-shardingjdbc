package com.niu.uidgenerator.service;

import com.niu.uidgenerator.UidGenerator;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-05 00:30
 * @Version 1.0
 */
@Service
public class UidGenService {

  @Resource(name = "cachedUidGenerator")
  private UidGenerator uidGenerator;

  public long getUid() {

    return uidGenerator.getUID();
  }
}
