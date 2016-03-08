package com.muyu.sso.web.util;

import com.alibaba.druid.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by muyu 32905568@qq.com on 2015/12/25 0025.
 */
public class CookieUtils {
    public static String getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(StringUtils.equals(cookie.getName(),name)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
