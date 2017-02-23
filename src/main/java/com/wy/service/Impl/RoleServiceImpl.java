package com.wy.service.Impl;

import com.wy.bean.Role;
import com.wy.dao.RoleDAO;
import com.wy.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDAO roleDAO;

    public List<Role> queryAll() {
        return roleDAO.queryAll();
    }

    public Role queryById(Serializable id) {
        return roleDAO.queryById(id);
    }

    public void add(Role role) {
        roleDAO.add(role);
    }

    public void update(Role role) {
        roleDAO.update(role);
    }

    public void deleteById(Serializable id) {
        roleDAO.deleteById(id);
    }
}
