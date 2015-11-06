package com.muyu.manager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by maowei on 2015/11/5.
 */
@Order(1)
@Configuration
@ComponentScan(basePackages = { "com.muyu.manager"})
public class ServiceConfig {

}
