package com.wy.dao;

import com.wy.bean.Resource;
import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2/15/2017.
 */
@Repository
public interface UserDAO extends BaseDAO<User,String>{
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
     * 查询是否存在账号密码验证注一致的账号
     * @param username
     * @param password
     * @return
     */
    public User queryByNamePwd(@Param("username") String username, @Param("password") String password);
}
