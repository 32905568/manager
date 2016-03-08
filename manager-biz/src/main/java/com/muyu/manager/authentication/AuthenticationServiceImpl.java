package com.muyu.manager.authentication;

import com.muyu.manager.user.UserService;
import org.springframework.cache.Cache;

import javax.annotation.Resource;

/**
 * Created by muyu 32905568@qq.com on 2015/12/24 0024.
 */
public class AuthenticationServiceImpl implements AuthenticationService{
    Cache cache;
    @Resource
    UserService userService;
    @Override
    public boolean login(AuthenticationInfo authInfo) {
        // 先看用户是否已经登录过
        // 验证用户名密码
        boolean success = userService.checkUserPassword( authInfo.getUserName(),authInfo.getPassword());
        if(!success){
            String k = cache.get("",String.class);
            return false;
        }
        // 保存用户登录状态,下次验证时先看是否已经登录过

        return true;
    }

    @Override
    public boolean logout(AuthenticationInfo authInfo) {

        return true;
    }
}
