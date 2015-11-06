package com.muyu.manager.web.controller;

import com.muyu.manager.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public Map<String,String> index() {
        userService.test();
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
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
