package com.wy.service.Impl;

import com.wy.bean.system.Admin;
import com.wy.dao.AdminDAO;
import com.wy.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/8.
 */
@Service
public class AdminServiceImpl implements AdminService {

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

    public Admin queryByEmail(String email) {
        return adminDAO.queryByEmail(email);
    }

    public void updatePwd(Admin admin) {
        adminDAO.updatePwd(admin);
    }

    public Set<String> queryRoles(String id) {
        return adminDAO.queryRoles(id);
    }

    public Set<String> queryPermissions(String id) {
        return adminDAO.queryPermissions(id);
    }
}
