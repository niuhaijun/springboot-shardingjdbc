package com.niu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 分库分表
 */
@SpringBootApplication
public class ShardingApplication {

  public static void main(String[] args) {

    SpringApplication.run(ShardingApplication.class, args);
  }

}
