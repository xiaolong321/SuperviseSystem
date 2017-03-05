package com.wy.service.Impl;

import com.wy.bean.User;
import com.wy.dao.UserDAO;
import com.wy.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2/15/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    public List<User> queryAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }

    public User queryById(Serializable id) {
        return userDAO.queryById(id);
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void deleteById(Serializable id) {
        userDAO.deleteById(id);
    }

    public User queryByUsername(@Param("username") String username) {
        return userDAO.queryByUsername(username);
    }

    public Set<String> queryRoles(String username) {
        return userDAO.queryRoles(username);
    }

    public Set<String> queryPermissions(String username) {
        return userDAO.queryPermissions(username);
    }

    public void updatePwd(User user) {
        userDAO.updatePwd(user);
    }
}
