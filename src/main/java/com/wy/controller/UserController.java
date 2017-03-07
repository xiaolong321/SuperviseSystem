package com.wy.controller;

import com.wy.bean.User;
import com.wy.common.bean.Constants;
import com.wy.common.bean.ControllerResult;
import com.wy.common.util.MD5Util;
import com.wy.dao.UserRoleDAO;
import com.wy.service.UserRoleService;
import com.wy.service.UserService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
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
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    private Subject subject;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "userHome", method = RequestMethod.GET)
    public String toUserHome() {
        return "user/userHome";
    }


    /**
     * 跳转到用户登陆页面
     *
     * @return
     */
    @RequestMapping(value = "loginPager", method = RequestMethod.GET)
    public String toLoginPage() {
        return "user/userLogin";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "registerPager", method = RequestMethod.GET)
    public String toRegisterPager() {
        return "user/userRegister";
    }

    /**
     * 跳转到用户信息的页面
     *
     * @return
     */
    @RequestMapping(value = "userInfoPage", method = RequestMethod.GET)
    public String toUserinfo(String id, HttpServletRequest request) {
        User user = userService.queryById(id);
        request.setAttribute("user", user);
        return "user/userInfoPage";
    }

    @RequestMapping(value = "updatePwdPage", method = RequestMethod.GET)
    public String toUpdatePwdPage() {
        return "user/userUpdatePwd";
    }

    /**
     * 跳转到查看全部用户页面
     */
    @RequestMapping(value = "userAllPage", method = RequestMethod.GET)
    public String toUserAllPage() {
        return "user/userAllPage";
    }


    /**
     * 用户登陆
     *
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    public ControllerResult login(User user, HttpSession session, @Param("checkCode") String checkCode) {
        logger.info("验证码为" + checkCode);
        String codeSession = (String) session.getAttribute("check_code");
        if (checkCode != null && checkCode.equals(codeSession)) {
            subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(user.getEmail(), MD5Util.md5(user.getPassword(), Constants.USERSALT)));
                if (subject.hasRole("admin")) {
                    logger.info("验证是否为admin");
                    session.setAttribute("admin", userService.queryByUsername(subject.getPrincipal().toString()));
                    return ControllerResult.getLoginRsult("登陆成功", "admin");
                } else if (subject.hasRole("user")) {
                    logger.info("验证是否为user");
                    session.setAttribute("user", userService.queryByUsername(subject.getPrincipal().toString()));
                    return ControllerResult.getLoginRsult("登陆成功", "user");
                } else {
                    return ControllerResult.getFailResult("登陆失败");
                }
            } catch (UnknownAccountException e) {//未知的账号异常
                e.printStackTrace();
                return ControllerResult.getFailResult("登陆失败，请检查你的账号是否存在");
            } catch (IncorrectCredentialsException e) {//未知的凭证异常
                e.printStackTrace();
                return ControllerResult.getFailResult("登陆失败，请检查你的账号密码是否正确");
            } catch (LockedAccountException e) {//锁定的账号异常
                e.printStackTrace();
                return ControllerResult.getFailResult("登陆失败，你的账号已被冻结，暂时无法使用");
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return ControllerResult.getFailResult("登陆失败，身份验证时出现错误，请重试");
            }
        } else {
            return ControllerResult.getFailResult("验证码错误，请重新输入验证码！");
        }
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegister", method = RequestMethod.POST)
    public ControllerResult userRegister(User user, @Param("conPassword") String conPassword, @Param("checkCode") String checkCode, HttpSession session) {
        String codeSession = (String) session.getAttribute("check_code");
        if (codeSession != null && codeSession.equals(checkCode)) {
            //该user为前台传入数据。
            if (user != null) {
                //判断传入的两次密码知否一致，只有一致才才可以注册
                if (user.getPassword().equals(conPassword)) {
                    logger.info("用户注册");
                    //对密码进行加密
                    String md5Pwd = MD5Util.md5(conPassword, Constants.USERSALT);
                    user.setPassword(md5Pwd);
                    if(userService.queryByEmail(user.getEmail())==null){
                        userService.add(user);
                        logger.info("注册成功");
                        User u = userService.queryByEmail(user.getEmail());
                        return ControllerResult.getRegisterResult("注册成功", u.getId());
                    }else{
                        return ControllerResult.getFailResult("注册失败，该邮箱已被注册，请重新选择账号！");
                    }
                } else {
                    return ControllerResult.getSuccessResult("两次密码不一致");
                }
            } else {
                return ControllerResult.getSuccessResult("你的账号还未激活，请激活后登陆！");
            }
        } else {
            return ControllerResult.getFailResult("验证码错误，请重新输入验证码！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "giveUserRole", method = RequestMethod.POST)
    public ControllerResult giveUserRole(@Param("userId") String userId) {
        logger.info("传过来的id为"+userId);
        if (userId != null) {
            userRoleService.add(userId, Constants.userRole);
            logger.info("为用户赋予角色成功");
            return ControllerResult.getSuccessResult("为用户赋予角色成功");
        } else {
            logger.info("为用户赋予角色成功");
            return ControllerResult.getFailResult("为用户赋予角色失败");
        }
    }

    /**
     * 查询所有的用户
     *
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "serach_page", method = RequestMethod.POST)
    public List<User> serachPage(@Param("page") String page, @Param("rows") String rows) {
        List<User> userList = userService.queryAll();
        return userList;
    }

    /**
     * 修改密码
     * 参数：
     * 1、新的密码
     * 2、确认的密码
     * 3、原先的密码从session中获取
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public ControllerResult changePwd(@Param("password") String password, @Param("newPwd") String
            newPwd, @Param("conPwd") String conPwd, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getPassword().equals(MD5Util.md5(password, Constants.USERSALT)) && newPwd != null && newPwd.equals(conPwd)) {
                user.setPassword(MD5Util.md5(conPwd, Constants.USERSALT));
                userService.updatePwd(user);
                session.setAttribute("user", user);
                logger.info("用户更新密码成功");
                return ControllerResult.getSuccessResult("修改密码成功");
            } else {
                return ControllerResult.getFailResult("修改密码失败");
            }
        } else {
            return ControllerResult.getFailResult("抱歉，更新失败");
        }
    }


    @ResponseBody
    @RequestMapping(value = "editInfo", method = RequestMethod.POST)
    public ControllerResult editInfo(User user, HttpSession session) {
        if (user != null) {
            userService.update(user);
            session.setAttribute("user", userService.queryById(user.getId()));
            return ControllerResult.getSuccessResult("更新成功");
        } else {
            return ControllerResult.getFailResult("更新失败");
        }
    }

    /**
     * 注销登陆
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogout", method = RequestMethod.POST)

    public ControllerResult userLogout(HttpSession session) {
        logger.info("注销成功");
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return ControllerResult.getSuccessResult("注销成功");
        } else if (session.getAttribute("admin") != null) {
            session.removeAttribute("admin");
            return ControllerResult.getSuccessResult("注销成功");
        }
        return null;
    }

    /**
     * activiti开始部署
     */
    @ResponseBody
    @RequestMapping(value = "deploy", method = RequestMethod.GET)
    public ControllerResult deploy() {
        repositoryService.createDeployment().addClasspathResource("activiti_diagrams/leave_process.bpmn").deploy();
        return ControllerResult.getSuccessResult("部署成功");
    }


    /**
     * 给角色赋予任务
     *
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "leave", method = RequestMethod.GET)
    public ControllerResult leave(HttpSession session) {
        runtimeService.startProcessInstanceByKey("leave_process");
        List<Task> tasks = taskService.createTaskQuery().list();
        Task currentTask = tasks.get(0);
        User currentUser = (User) session.getAttribute("user");
        taskService.setAssignee(currentTask.getId(), currentUser.getEmail());
        taskService.complete(currentTask.getId());
        return ControllerResult.getSuccessResult("交付任务成功");
    }

    /**
     * 检查该任务
     *
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "check", method = RequestMethod.GET)
    public ControllerResult check(HttpSession session) {
        List<Task> tasks = taskService.createTaskQuery().list();
        Task currentTask = tasks.get(0);
        User currentUser = (User) session.getAttribute("user");
        taskService.setAssignee(currentTask.getId(), currentUser.getEmail());
        taskService.complete(currentTask.getId());
        return ControllerResult.getSuccessResult("检查完毕");
    }

}