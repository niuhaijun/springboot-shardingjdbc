//package com.niu.sharding.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
//import io.shardingsphere.api.config.rule.TableRuleConfiguration;
//import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
//import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.ConcurrentHashMap;
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
///**
// * @author 牛海军
// * @Date 2019年1月14日 15:12
// * @Description 数据源配置类，使用JavaConfig的方式配置sharding数据源
// **/
//@Configuration
//public class DatasourceShardingConfig {
//
//  /**
//   * Sharding-JDBC的分库分表通过规则配置描述，
//   * 以下例子是根据user_id取模分库, 且根据order_id取模分表的两库两表的配置。
//   */
//  @Bean
//  @Primary
//  public DataSource dataSource() throws Exception {
//
//    // 配置真实数据源
//    Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//    // 配置第一个数据源
//    DruidDataSource ds0 = new DruidDataSource();
//    ds0.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    ds0.setUrl("jdbc:mysql://localhost:3306/spring_boot_sharding0?useSSL=false");
//    ds0.setUsername("root");
//    ds0.setPassword("!@#$1234Abcd");
//    dataSourceMap.put("ds0", ds0);
//
//    // 配置第二个数据源
//    DruidDataSource ds1 = new DruidDataSource();
//    ds1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    ds1.setUrl("jdbc:mysql://localhost:3306/spring_boot_sharding1?useSSL=false");
//    ds1.setUsername("root");
//    ds1.setPassword("!@#$1234Abcd");
//    dataSourceMap.put("ds1", ds1);
//
//    // 配置t_order表规则
//    TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
//    orderTableRuleConfig.setLogicTable("t_order");
//    orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_order${0..1}");
//
//    // 配置分库 + 分表策略
//    orderTableRuleConfig.setDatabaseShardingStrategyConfig(
//        new InlineShardingStrategyConfiguration("user_id", "ds${user_id % 2}"));
//    orderTableRuleConfig.setTableShardingStrategyConfig(
//        new InlineShardingStrategyConfiguration("order_id", "t_order${order_id % 2}"));
//
//    // 配置分片规则
//    ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//    shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
//
//    // 获取数据源对象
//    Properties props = new Properties() {
//      {
//        // 打印SQL
//        put("sql.show", "true");
//      }
//    };
//    return ShardingDataSourceFactory
//        .createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap<>(), props);
//  }
//
//}
