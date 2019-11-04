package com.niu.uidgenerator.controller;

import com.niu.uidgenerator.UidGenerator;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-05 00:26
 * @Version 1.0
 */
@RestController
@RequestMapping("uid")
public class UidController {

  @Resource(name = "cachedUidGenerator")
  private UidGenerator uidGenerator;

  @RequestMapping("get")
  public Long get() {

    return uidGenerator.getUID();
  }

}
