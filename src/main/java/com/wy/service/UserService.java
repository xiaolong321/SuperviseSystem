package com.wy.service;

import com.wy.bean.Resource;
import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends BaseService<User,String> {
    /**
     * 查询该id的用户有什么对应的权限
     * @param userId
     * @return
     */
    public List<Resource> queryAllResource(String userId);

    /**
     * 查询该id的用户的角色是什么
     * @param userId
     * @return
     */
    public List<String> queryRoleSnByUser(String userId);

    /**
     * 验证账号密码
     * @param username
     * @param password
     * @return
     */
    public User queryByNamePwd(@Param("username") String username, @Param("password") String password);
}

