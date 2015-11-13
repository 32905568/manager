package com.muyu.manager.user.impl;

import com.muyu.manager.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by maowei on 2015/11/5.
 */
@Service
public class UserServiceImpl implements UserService{
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public void test() {
        LOGGER.warn(111+":test");
    }
}
