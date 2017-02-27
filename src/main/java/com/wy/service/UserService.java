package com.wy.service;

import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.Set;

public interface UserService extends BaseService<User,String> {
    /**
     * 验证账号密码
     * @param username
     * @return
     */
    public User queryByUsername(@Param("username") String username);


    /**
     * 根据id查询该用户的所有的角色，用户角色验证。
     * @param username
     * @return
     */
    public Set<String> queryRoles(String username);


    /**
     *根据id查询该用户所拥有的权限，用于权限判断。
     * @param username
     * @return
     */
    public Set<String> queryPermissions(String username);

}

