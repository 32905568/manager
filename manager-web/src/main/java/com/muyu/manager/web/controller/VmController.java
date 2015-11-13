package com.muyu.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maowei on 2015/11/6.
 */
@Controller("/p")
public class VmController {
    @RequestMapping("/{name}")
    public String vm(@PathVariable String name) {
        return "/" + name;
    }
    @RequestMapping("/{path}/{name}")
    public String vm(@PathVariable String path,@PathVariable String name) {
        return "/" + path + "/" + name;
    }
    @RequestMapping("/{module}/{path}/{name}")
    public String vm(@PathVariable String module,@PathVariable String path,@PathVariable String name) {
        return "/" + module +"/" + path + "/" + name;
    }
}
