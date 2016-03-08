package com.muyu.manager.web.controller;

import com.muyu.manager.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/test1")
    public Map<String,String> test() {
        System.out.println("--------------");
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }

    @RequestMapping("/index")
    public Map<String,Object> index(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }

    @RequestMapping("/logout")
    public Map<String,String> logout() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }
}
