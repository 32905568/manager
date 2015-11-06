package com.muyu.test.manager.user;

import com.muyu.manager.config.ServiceConfig;
import com.muyu.manager.user.UserService;
import com.muyu.test.common.BaseTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * Created by maowei on 2015/11/5.
 */
//
//@ComponentScan(basePackages = "com.muyu")
@ContextConfiguration(classes = ServiceConfig.class)
public class UserServiceTest extends BaseTest{

    @Resource
    UserService userService;

    @Test
    public void test_配置注解测试(){
        userService.test();
    }
}
