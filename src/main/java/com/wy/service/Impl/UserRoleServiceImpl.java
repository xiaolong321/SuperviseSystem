package com.wy.service.Impl;

import com.wy.dao.UserRoleDAO;
import com.wy.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/7.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleDAO userRoleDAO;

    public void add(String id,int roleId) {
        userRoleDAO.add(id,roleId);
    }
}
