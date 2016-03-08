package com.muyu.manager.authentication;

/**
 * 用户认证接口
 * 提供用户登入，登出，和新用户注册接口
 * Created by muyu 32905568@qq.com on 2015/12/23 0023.
 */
public interface AuthenticationService {
    public boolean login(AuthenticationInfo authInfo);
    public boolean logout(AuthenticationInfo authInfo);
}
