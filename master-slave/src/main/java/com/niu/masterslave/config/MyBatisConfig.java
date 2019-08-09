package com.niu.masterslave.config;

import com.github.pagehelper.PageInterceptor;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author lou
 * @Date 2019年1月14日 15:12
 * @Description MyBatis配置类
 **/
@Configuration
public class MyBatisConfig implements TransactionManagementConfigurer {

  @Autowired
  private DataSource dataSource;

  @Primary
  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setTypeAliasesPackage("com.niu.masterslave.model");

    //添加插件
    Interceptor interceptor = new PageInterceptor();
    Properties properties = new Properties();
    properties.setProperty("reasonable", "false");
    properties.setProperty("supportMethodsArguments", "true");
    properties.setProperty("returnPageInfo", "check");
    properties.setProperty("params", "count=countSql");
    interceptor.setProperties(properties);
    bean.setPlugins(new Interceptor[]{interceptor});

    //添加XML目录
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    bean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
    return bean.getObject();
  }

  @Primary
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {

    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  @Primary
  @Override
  public PlatformTransactionManager annotationDrivenTransactionManager() {

    return new DataSourceTransactionManager(dataSource);
  }
}
