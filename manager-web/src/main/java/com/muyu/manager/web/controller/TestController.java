package com.muyu.manager.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/22 0022.
 */
@RestController("/api/a")
public class TestController {
    @RequestMapping("/a1")
    public Map<String,String> test1(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("user","muyu");
        map.put("id","1234");
        return map;
    }
}
