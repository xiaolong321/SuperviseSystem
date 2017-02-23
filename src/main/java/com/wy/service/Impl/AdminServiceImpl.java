package com.wy.service.Impl;

import com.wy.bean.Admin;
import com.wy.dao.AdminDAO;
import com.wy.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2/15/2017.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminDAO adminDAO;

    public List<Admin> queryAll() {
        return adminDAO.queryAll();
    }

    public Admin queryById(Serializable id) {
        return adminDAO.queryById(id);
    }

    public void add(Admin admin) {
        adminDAO.add(admin);
    }

    public void update(Admin admin) {
        adminDAO.update(admin);
    }

    public void deleteById(Serializable id) {
        adminDAO.deleteById(id);
    }

    public List<com.wy.bean.Resource> queryAllResource(String adminId) {
        return adminDAO.queryAllResource(adminId);
    }

    public List<String> queryRoleSnByUser(String adminId) {
        return adminDAO.queryRoleSnByUser(adminId);
    }

    public Admin queryByNamePwd(@Param("username") String username, @Param("password") String password) {
        return adminDAO.queryByNamePwd(username,password);
    }
}
