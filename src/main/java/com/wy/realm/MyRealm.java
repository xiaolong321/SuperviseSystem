package com.wy.realm;

import com.wy.bean.User;
import com.wy.common.bean.ControllerResult;
import com.wy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 要想Shiro可以授权的功能需要继承AuthorizingRealm类，如果只是继承了Realm类，只有用户认证的功能。
 * Created by Administrator on 2017/2/21.
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Resource
    private UserService userService;

    /**
     * 用于权限的验证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo....");
        String username=principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName=userService.queryRoles(username);
        Set<String> permissions=userService.queryPermissions(username);
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 首先执行这个登陆方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        User user=userService.queryByUsername(username);
        if(user!=null){
            /**
             * username
             * password
             * 凭证盐
             */
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"a");
            return simpleAuthenticationInfo;
        }else{
            throw new UnknownAccountException();
        }
    }
}
