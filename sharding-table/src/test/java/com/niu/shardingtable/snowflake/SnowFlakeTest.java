package com.niu.shardingtable.snowflake;

import com.niu.shardingtable.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-04 17:31
 * @Version 1.0
 */
@Slf4j
public class SnowFlakeTest {

  @Test
  public void test() throws InterruptedException {

    SnowFlake sf = new SnowFlake(0, 0);

    while (true) {
      long id = sf.nextId();
      String ym = SnowFlake.getYearAndMonthFromId(id);
    }
  }

}
