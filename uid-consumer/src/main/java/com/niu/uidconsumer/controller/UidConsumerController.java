package com.niu.uidconsumer.controller;

import com.niu.uidgenerator.service.UidGenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: niuhaijun
 * @date: 2019-11-07 12:51
 * @version: 1.0
 * @description: xxx
 */
@RestController
@RequestMapping("uid")
@Slf4j
public class UidConsumerController {

  @Autowired(required = false)
  private UidGenService service;

  @RequestMapping("get")
  public String get() {

    String uid = "" + service.getUID();
    log.info("uid = {}", uid);

    return uid;
  }

  @RequestMapping("parse")
  public String parse(Long uid) {

    String uidStr = service.parseUID(uid);
    log.info("uidStr = {}", uidStr);

    return uidStr;
  }

}
