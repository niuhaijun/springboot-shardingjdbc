package com.niu.uidgenerator.generator;

import com.niu.UidGeneratorApplication;
import com.niu.uidgenerator.service.UidGenService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: niuhaijun
 * @date: 2019-11-07 14:17
 * @version: 1.0
 * @description: xxx
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UidGeneratorApplication.class)
@Slf4j
public class GeneratorTest {

  @Autowired
  private UidGenService uidService;

  @Test
  public void test() {

    long uid = uidService.getUID();
    log.info("uid = {}", uid);

    String strUid = uidService.parseUID(uid);
    log.info("uidStr = {}", strUid);
  }


  @Test
  public void performance() {

    int n = 100;

    List<Long> uidList = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      uidList.add(uidService.getUID());
    }

    uidList.stream().map(uidService::parseUID).forEach(log::info);
  }
}
