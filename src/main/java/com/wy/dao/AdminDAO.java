package com.wy.dao;

import com.wy.bean.Admin;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Administrator on 2017/3/8.
 */
@Repository
public interface AdminDAO extends BaseDAO<Admin, String> {

    /**
     * 根据email查找该账号有关的信息
     * @param email
     * @return
     */
    public Admin queryByEmail(String email);

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
     * @param admin
     */
    public void updatePwd(Admin admin);
}
