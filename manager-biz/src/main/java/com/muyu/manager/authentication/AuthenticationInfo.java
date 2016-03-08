package com.muyu.manager.authentication;

import java.io.Serializable;

/**
 * 登录信息
 * Created by muyu 32905568@qq.com on 2015/12/24 0024.
 */
public class AuthenticationInfo implements Serializable{
        
    String userName;
    String password;
    String appName;
    String appKey;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
