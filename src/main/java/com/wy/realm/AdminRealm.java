package com.wy.realm;

import com.wy.bean.system.Admin;
import com.wy.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/9.
 */
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登陆的账号，账号通常为email。
        String email=principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = adminService.queryRoles(email) ;
        Set<String> permissions = adminService.queryPermissions(email) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email=authenticationToken.getPrincipal().toString();
        Admin admin=adminService.queryByEmail(email);
        if(admin!=null){
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(admin.getEmail(),admin.getPassword(),"admin");
            return authenticationInfo;
        }else{
            return null;
        }
    }
}
