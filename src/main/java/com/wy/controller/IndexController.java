package com.wy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
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
    public String home() {
        return "index";
    }
}
