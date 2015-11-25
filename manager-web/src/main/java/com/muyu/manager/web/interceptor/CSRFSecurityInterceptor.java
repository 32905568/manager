package com.muyu.manager.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hantong
 *
 * 2014-12-26 上午10:07:56
 */
public class CSRFSecurityInterceptor extends HandlerInterceptorAdapter {


    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void init() throws Exception {
    }
}
