package com.niu.sharding.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lou
 * @Date 2019年1月14日 15:12
 * @Description MyBatis扫描包配置类
 **/
@AutoConfigureAfter(MyBatisConfig.class)
@Configuration
public class MyBatisMapperScannerConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {

    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("com.niu.springbootshardingjdbc.mapper");
    return mapperScannerConfigurer;
  }
}
