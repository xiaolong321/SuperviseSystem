package com.wy.controller;

import com.wy.bean.User;
import com.wy.common.bean.ControllerResult;
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
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    private Subject subject;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "userHome", method = RequestMethod.GET)
    public String toUserHome() {
        return "user/user";
    }

    @RequestMapping(value = "adminHome",method = RequestMethod.GET)
    public String toAdminHome(){
        return "user/admin";
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
     *
     * @return
     */
    @RequestMapping(value = "userInfoPage", method = RequestMethod.POST)
    public String toUserinfo() {
        return "user/info";
    }

    /**
     * 跳转到查看全部用户页面
     */
    @RequestMapping(value = "list_page", method = RequestMethod.GET)
    public String toListPage() {
        return "user/users";
    }

    /**
     * 跳转到查看全部权限页面
     */
    @RequestMapping(value = "role_list", method = RequestMethod.GET)
    public String toRolePage() {
        return "user/roles";
    }

    @RequestMapping(value = "AuthenticationFailedPage", method = RequestMethod.GET)
    public String toAuthenticationFailedPage() {
        return "user/failed";
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
    public ControllerResult login(User user, HttpSession session) {
        subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getEmail(), user.getPassword()));
            session.setAttribute("user", userService.queryByUsername(subject.getPrincipal().toString()));
            if (subject.hasRole("admin")) {
                return ControllerResult.getLoginRsult("登陆成功", "admin");
            } else if (subject.hasRole("user")) {
                return ControllerResult.getLoginRsult("登陆成功", "user");
            }else{
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
    }


    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegister", method = RequestMethod.POST)
    public ControllerResult userRegister(User user) {
        if (user != null) {
            logger.info("用户注册");
            userService.add(user);
            return ControllerResult.getSuccessResult("用户注册成功");
        } else {
            return ControllerResult.getFailResult("用户注册失败，请重新注册");
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
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public ControllerResult changePwd(User user, @Param("newPwd") String newPwd, @Param("conPwd") String conPwd, HttpSession session) {
        return null;
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
        session.removeAttribute("user");
        return ControllerResult.getSuccessResult("注销成功");
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