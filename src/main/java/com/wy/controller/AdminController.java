package com.wy.controller;

import com.wy.bean.Admin;
import com.wy.common.bean.Constants;
import com.wy.common.bean.ControllerResult;
import com.wy.common.util.MD5Util;
import com.wy.service.AdminService;
import com.wy.service.UserRoleService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
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
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private UserRoleService userRoleService;

    //获取默认的流程引擎
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    private Subject subject;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    /**
     * 用户登陆
     *
     * @param admin
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public ControllerResult login(Admin admin, HttpSession session, @Param("checkCode") String checkCode) {
        logger.info("验证码为" + checkCode);
        logger.info("传过来的账户密码是：" + admin.toString());
        String codeSession = (String) session.getAttribute("check_code");
        if (checkCode != null && checkCode.equals(codeSession)) {
            subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(admin.getEmail(), MD5Util.md5(admin.getPassword(), Constants.ADMINSALT)));
                if (subject.hasRole("admin")) {
                    session.setAttribute("admin", adminService.queryByEmail(subject.getPrincipal().toString()));
                    return ControllerResult.getLoginRsult("登陆成功", "admin");
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

    @ResponseBody
    @RequestMapping(value = "addNewAdmin", method = RequestMethod.POST)
    public ControllerResult addNewAdmin(Admin admin, @Param("conPassword") String conPassword, @Param("checkCode") String checkCode, HttpSession session) {
        String codeSession = (String) session.getAttribute("check_code");
        logger.info("密码为：" + admin.getPassword() + ",确认密码为" + conPassword);
        if (codeSession != null && codeSession.equals(checkCode)) {
            //该admin为前台传入数据。
            if (admin != null) {
                //判断传入的两次密码知否一致，只有一致才才可以注册
                if (admin.getPassword().equals(conPassword)) {
                    logger.info("用户注册");
                    //对密码进行加密
                    String md5Pwd = MD5Util.md5(conPassword, Constants.ADMINSALT);
                    admin.setPassword(md5Pwd);
                    if (adminService.queryByEmail(admin.getEmail()) == null) {
                        adminService.add(admin);
                        logger.info("注册成功");
                        Admin a = adminService.queryByEmail(admin.getEmail());
                        return ControllerResult.getRegisterResult("注册成功", a.getId());
                    } else {
                        return ControllerResult.getFailResult("注册失败，该邮箱已被注册，请重新选择账号！");
                    }
                } else {
                    return ControllerResult.getFailResult("两次密码不一致");
                }
            } else {
                return ControllerResult.getFailResult("你的账号还未激活，请激活后登陆！");
            }
        } else {
            return ControllerResult.getFailResult("验证码错误，请重新输入验证码！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "editInfo", method = RequestMethod.POST)
    public ControllerResult editInfo(Admin admin, HttpSession session) {
        if (admin != null) {
            adminService.update(admin);
            session.setAttribute("user", adminService.queryById(admin.getId()));
            return ControllerResult.getSuccessResult("更新成功");
        } else {
            return ControllerResult.getFailResult("更新失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "giveAdminRole", method = RequestMethod.POST)
    public ControllerResult giveUserRole(@Param("adminId") String adminId) {
        logger.info("传过来的id为" + adminId);
        if (adminId != null) {
            userRoleService.add(adminId, Constants.adminRole);
            logger.info("为管理员赋予角色成功");
            return ControllerResult.getSuccessResult("为管理员赋予角色成功");
        } else {
            logger.info("为管理员赋予角色失败");
            return ControllerResult.getFailResult("为管理员赋予角色失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public ControllerResult changePwd(@Param("password") String password, @Param("newPwd") String
            newPwd, @Param("conPwd") String conPwd, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("user");
        if (admin != null) {
            if (admin.getPassword().equals(MD5Util.md5(password, Constants.ADMINSALT)) && newPwd != null && newPwd.equals(conPwd)) {
                admin.setPassword(MD5Util.md5(conPwd, Constants.USERSALT));
                adminService.updatePwd(admin);
                session.setAttribute("admin", admin);
                logger.info("用户更新密码成功");
                return ControllerResult.getSuccessResult("修改密码成功");
            } else {
                return ControllerResult.getFailResult("修改密码失败");
            }
        } else {
            return ControllerResult.getFailResult("抱歉，更新失败");
        }
    }

    @RequestMapping(value = "adminInfoPage", method = RequestMethod.GET)
    public String toAdminInfoPage(String id, HttpServletRequest request) {
        Admin admin = adminService.queryById(id);
        request.setAttribute("admin", admin);
        return "admin/adminInfoPage";
    }


    @RequestMapping(value = "adminHome", method = RequestMethod.GET)
    public String toAdminHome() {
        return "admin/adminHome";
    }

    @RequestMapping(value = "addAdminPage", method = RequestMethod.GET)
    public String toAddAdminPage() {
        return "admin/addAdminPage";
    }


    @RequestMapping(value = "updatePwdPage", method = RequestMethod.GET)
    public String toUpdatePwdPage() {
        return "admin/adminUpdatePwd";
    }

    @RequestMapping(value = "loginPager", method = RequestMethod.GET)
    public String toLoginPage() {
        return "admin/adminLogin";
    }

    //-----------------------------------------------activit
    @RequestMapping(value = "toViewAllProcessPage", method = RequestMethod.GET)
    public String toViewAllProcessPage() {
        return "admin/allProcess";
    }


    /**
     * 查询全部的流程定义信息，在act_re_procdef表。
     * 流程定义为activiti加载流程时留下的定义信息。可看到全部部署、启动过的流程。
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "toViewAllProcess", method = RequestMethod.POST)
    public List<ProcessDefinition> toViewAllProcess() {
        return null;
    }
}
