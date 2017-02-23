package com.wy.dao;

import com.wy.bean.Admin;
import com.wy.bean.Resource;
import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2/15/2017.
 */
@Repository
public interface AdminDAO extends BaseDAO<Admin,String>{
    /**
     * 查询该id的用户有什么对应的权限
     * @param adminId
     * @return
     */
    public List<Resource> queryAllResource(String adminId);

    /**
     * 查询该id的用户的角色是什么
     * @param adminId
     * @return
     */
    public List<String> queryRoleSnByUser(String adminId);


    public Admin queryByNamePwd(@Param("username") String username, @Param("password") String password);

}
