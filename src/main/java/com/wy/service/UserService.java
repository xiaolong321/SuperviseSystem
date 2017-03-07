package com.wy.service;

import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.Set;
@CacheConfig(cacheNames = "menuCache")
public interface UserService extends BaseService<User, String> {
    /**
     * 验证账号密码
     *
     * @param username
     * @return
     */
    @Cacheable(key = "#username")
    public User queryByUsername(@Param("username") String username);


    /**
     * 根据邮箱查询用户对应的id
     * @param email
     * @return
     */
    @Cacheable(key = "#email")
    public User queryByEmail(String email);


    /**
     * 根据id查询该用户的所有的角色，用户角色验证。
     *
     * @param username
     * @return
     */
    @Cacheable(key = "#username")
    public Set<String> queryRoles(String username);


    /**
     * 根据id查询该用户所拥有的权限，用于权限判断。
     *
     * @param username
     * @return
     */
    @Cacheable(key = "#username")
    public Set<String> queryPermissions(String username);


    /**
     * 用于更新密码
     *
     * @param user
     */
    public void updatePwd(User user);

}

