package com.muyu.manager.user.impl;

import com.muyu.manager.user.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by maowei on 2015/11/5.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void test() {
        System.out.println(111+":test");
    }
}
