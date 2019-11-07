package com.niu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 分布式ID生成器 百度开源
 */
@SpringBootApplication
@MapperScan("com.niu.uidgenerator.worker.dao")
public class UidGeneratorApplication {

  public static void main(String[] args) {

    SpringApplication.run(UidGeneratorApplication.class, args);
  }

}
