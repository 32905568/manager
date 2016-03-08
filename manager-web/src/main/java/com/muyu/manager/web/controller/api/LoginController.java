package com.muyu.manager.web.controller.api;

import com.muyu.manager.web.common.ResultDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/12/23 0023.
 */
@RestController
public class LoginController {

    @RequestMapping("/api/login/login")
    public ResultDO login() {
        return new ResultDO();
    }

    @RequestMapping("/api/login/logout")
    public ResultDO logout() {
        return new ResultDO();
    }

    @RequestMapping("/api/login/register")
    public ResultDO register() {
        return new ResultDO();
    }
}
