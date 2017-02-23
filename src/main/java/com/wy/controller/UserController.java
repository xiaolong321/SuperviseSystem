package com.wy.controller;
import com.wy.bean.User;
import com.wy.common.bean.ControllerResult;
import com.wy.common.bean.Pager4EasyUI;
import com.wy.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by useristrator on 2/14/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "userHome",method = RequestMethod.GET)
    public String toHome(){
        return "user/user";
    }

    /**
     * 跳转到用户登陆页面
     *
     * @return
     */
    @RequestMapping(value = "loginPager", method = RequestMethod.GET)
    public String toLoginPage() {
        return "user/login";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "registerPager", method = RequestMethod.GET)
    public String toRegisterPager() {
        return "user/register";
    }

    /**
     * 跳转到用户信息的页面
     * @return
     */
    @RequestMapping(value = "userInfoPage",method = RequestMethod.GET)
    public String toUserinfo(){
        return "user/info";
    }

    /**
     * 跳转到查看全部用户页面
     */
    @RequestMapping(value = "list_page",method = RequestMethod.GET)
    public String toListPage(){
        return "user/users";
    }

    /**
     * 用户登陆
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogin",method = RequestMethod.POST)
    public ControllerResult login(User user, HttpSession session){
        System.out.println(user.toString());
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(token);
            logger.info("登陆成功");
            session.setAttribute("user",subject.getPrincipal());
            return ControllerResult.getSuccessResult("登陆成功");
        }catch (UnknownAccountException e){//未知的账号异常
            e.printStackTrace();
            return ControllerResult.getFailResult("登陆失败，请检查你的账号是否存在");
        }catch (IncorrectCredentialsException e){//未知的凭证异常
            e.printStackTrace();
            return ControllerResult.getFailResult("登陆失败，请检查你的账号密码是否正确");
        }catch (LockedAccountException e){//锁定的账号异常
            e.printStackTrace();
            return ControllerResult.getFailResult("登陆失败，你的账号已被冻结，暂时无法使用");
        }catch (AuthenticationException e){
            e.printStackTrace();
            return ControllerResult.getFailResult("登陆失败，身份验证时出现错误，请重试");
        }
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegister",method = RequestMethod.POST)
    public ControllerResult userRegister(User user){
        if(user!=null){
            logger.info("用户注册");
            userService.add(user);
            return ControllerResult.getSuccessResult("用户注册成功");
        }else{
            return ControllerResult.getFailResult("用户注册失败，请重新注册");
        }
    }


    /**
     * 查询所有的用户
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "serach_page",method = RequestMethod.POST)
    public List<User> serachPage(@Param("page")String page,@Param("rows")String rows){
        List<User> userList=userService.queryAll();
        return userList;
    }

    /**
     * 修改密码
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "changePwd",method = RequestMethod.POST)
    public ControllerResult changePwd(HttpSession session){
        return null;
    }


    /**
     * 注销登陆
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogout",method = RequestMethod.POST)
    public ControllerResult userLogout(HttpSession session){
        session.removeAttribute("user");
        logger.info("注销成功");
        return ControllerResult.getSuccessResult("注销成功");
    }
}
