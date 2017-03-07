package com.wy.controller;

import com.wy.common.bean.ControllerResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {



    /**
     * 注销登陆
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogout", method = RequestMethod.POST)
    public ControllerResult userLogout(HttpSession session) {
        session.removeAttribute("user");
        return ControllerResult.getSuccessResult("注销成功");
    }




    @RequestMapping(value = "adminHome", method = RequestMethod.GET)
    public String toAdminHome() {
        return "admin/adminHome";
    }
}
