package com.niu.masterslave.config;

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

  /**
   * 2019-08-09 22:26:41,552 [restartedMain] INFO  o.s.c.a.ConfigurationClassPostProcessor [/] - [Cannot enhance @Configuration bean definition 'myBatisMapperScannerConfig' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.]
   *
   * 解决方案：使用static修饰bean方法
   */
  @Bean
  public static MapperScannerConfigurer mapperScannerConfigurer() {

    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("com.niu.masterslave.mapper");
    return mapperScannerConfigurer;
  }
}
