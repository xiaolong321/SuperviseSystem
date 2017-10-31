package com.wy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 跳转到页面的控制类。
 * Created by Administrator on 2/15/2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * 项目启动时跳转到首页
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "foreign/index";
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String singIn(){
        return "foreign/signup";
    }

    /**
     * 跳转到忘记密码界面
     * @return
     */
    @RequestMapping(value = "forgot",method = RequestMethod.GET)
    public String forGet(){
        return "foreign/forgot";
    }
}
