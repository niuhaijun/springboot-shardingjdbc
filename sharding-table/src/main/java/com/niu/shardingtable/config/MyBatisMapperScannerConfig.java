package com.niu.shardingtable.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@AutoConfigureAfter(MyBatisConfig.class)
@Configuration
public class MyBatisMapperScannerConfig {

  @Bean
  public static MapperScannerConfigurer mapperScannerConfigurer() {

    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("com.niu.shardingtable.mapper");
    return mapperScannerConfigurer;
  }
}
