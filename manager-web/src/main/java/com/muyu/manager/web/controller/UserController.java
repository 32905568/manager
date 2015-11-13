package com.muyu.manager.web.controller;

import com.muyu.manager.user.UserService;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maowei on 2015/11/5.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/test")
    public Map<String,String> test() {
        userService.test();
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }

    @RequestMapping("/index")
    public Map<String,Object> index(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
        userService.test();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user","muyu");
        map.put("id","1234");
        AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
        map.put("authInfo",principal);
        return map;
    }

    @RequestMapping("/logout")
    public Map<String,String> logout() {
        userService.test();
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }
}
