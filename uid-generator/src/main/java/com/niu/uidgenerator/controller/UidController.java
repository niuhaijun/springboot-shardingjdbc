package com.niu.uidgenerator.controller;

import com.niu.uidgenerator.UidGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-05 00:26
 * @Version 1.0
 */
@RestController
@RequestMapping("uid")
@Slf4j
public class UidController {

  @Resource(name = "cachedUidGenerator")
  private UidGenerator uidGenerator;

  @GetMapping("get")
  public Long get() {

    return uidGenerator.getUID();
  }

  @GetMapping("parse")
  public String parse(Long uid) {

    return uidGenerator.parseUID(uid);
  }

  @GetMapping("test")
  public String test(int n) {

    List<Long> uidList = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      uidList.add(uidGenerator.getUID());
    }

    uidList.parallelStream().map(uidGenerator::parseUID).forEach(log::info);

    return "success";
  }


}
