package com.muyu.test.manager.user;

import com.muyu.manager.user.UserService;
import com.muyu.test.common.BaseTest;
import org.junit.Test;
import org.slf4j.MDC;

import javax.annotation.Resource;

/**
 * Created by maowei on 2015/11/5.
 */
//
//@ComponentScan(basePackages = "com.muyu")

public class UserServiceTest extends BaseTest{
    @Resource
    UserService userService;

    @Test
    public void test_配置注解测试(){
        userService.test();
    }

    @Test
    public void test_log4jMDC测试(){
        logger.warn("测试日志输出：no mdc.");
        MDC.put("traceId", "abc");
        logger.warn("测试日志输出：mdc = abc.");
        MDC.remove("traceId");
        logger.warn("测试日志输出：no mdc.");
        MDC.put("traceId","ddd");
        logger.warn("测试日志输出：mdc = ddd.");
    }
}
