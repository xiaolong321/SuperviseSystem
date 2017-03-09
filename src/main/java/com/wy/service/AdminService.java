package com.wy.service;

import com.wy.bean.Admin;
import com.wy.dao.BaseDAO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.Set;

/**
 * Created by Administrator on 2017/3/8.
 */
@CacheConfig(cacheNames = "menuCache")
public interface AdminService extends BaseDAO<Admin,String>{
    /**
     * 根据邮箱查询用户对应的id
     * @param email
     * @return
     */
    @Cacheable(key = "#email")
    public Admin queryByEmail(String email);


    /**
     * 修改密码
     * @param admin
     */
    public void updatePwd(Admin admin);


    /**
     * 根据id查询该用户的所有的角色，用户角色验证。
     * @param email
     * @return
     */
    @Cacheable(key = "#email")
    public Set<String> queryRoles(String email);


    /**
     *根据id查询该用户所拥有的权限，用于权限判断。
     * @param email
     * @return
     */
    @Cacheable(key = "#email")
    public Set<String> queryPermissions(String email);
}
