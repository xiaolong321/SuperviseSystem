package com.wy.dao;

import com.wy.bean.system.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Administrator on 2/15/2017.
 */
@Repository
public interface UserDAO extends BaseDAO<User,String>{
    /**
     * 验证账号密码
     * @param username
     * @return
     */
    public User queryByUsername(@Param("username") String username);


    /**
     *根据邮箱查询用户对应的id
     * @param email
     * @return
     */
    public User queryByEmail(String email);

    /**
     * 根据id查询该用户的所有的角色，用户角色验证。
     * @param email
     * @return
     */
    public Set<String> queryRoles(String email);


    /**
     *根据id查询该用户所拥有的权限，用于权限判断。
     * @param email
     * @return
     */
    public Set<String> queryPermissions(String email);

    /**
     * 用于更新密码
     * @param user
     */
    public void updatePwd(User user);

}
