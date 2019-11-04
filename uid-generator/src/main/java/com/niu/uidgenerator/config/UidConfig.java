package com.niu.uidgenerator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-05 00:03
 * @Version 1.0
 */
@Configuration
@ImportResource(locations = {"classpath:uid/cached-uid-spring.xml"})
public class UidConfig {

}
