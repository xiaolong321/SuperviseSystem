package com.wy.realm;

import com.wy.bean.User;
import com.wy.common.bean.ControllerResult;
import com.wy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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


/**
 * 要想Shiro可以授权的功能需要继承AuthorizingRealm类，如果只是继承了Realm类，只有用户认证的功能。
 * Created by Administrator on 2017/2/21.
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Resource
    private UserService userService;

    /**
     * 用于权限的认证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("MyRealm doGetAuthorizationInfo");
        User user= (User) principalCollection.getPrimaryPrincipal();
        String userId=user.getId();
        List<com.wy.bean.Resource> resourceList=userService.queryAllResource(userId);
        List<String> roleList=userService.queryRoleSnByUser(userId);
        List<String> resStrList=new ArrayList<String>();
        for(com.wy.bean.Resource resource:resourceList){
            resStrList.add(resource.getUrl());
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(new HashSet<String>(roleList));
        info.setStringPermissions(new HashSet<String>(resStrList));
        logger.debug("role =>"+roleList);
        logger.debug("permission =>"+resStrList);
        return info;
    }

    /**
     * 首先执行这个登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("MyRealm doGetAuthenticationInfo");
        String username=authenticationToken.getPrincipal().toString();
        String password=new String((char[])authenticationToken.getCredentials());
        User user=userService.queryByNamePwd(username,password);
        System.out.println(user.toString());
        if(user!=null){
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            info.setCredentialsSalt(ByteSource.Util.bytes(username.getBytes()));
            return info;
        }
        return null;
    }
}
