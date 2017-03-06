package com.wy.service.Impl;

import com.wy.bean.User;
import com.wy.dao.UserDAO;
import com.wy.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 缓存方式为菜单缓存，菜单缓存和默认缓存都是在chcache.xml中进行的相关配
 * Created by Administrator on 2/15/2017.
 */

/**
 * 在增加需要的方法的时候，所使用的注解也不同：
 * 2、@CacheEvict 一般应用到删除方法上，调用方法时会从缓存中移除相应的数据。
 */
//使用@CacheConfig注册直接为该类中所有使用了缓存注解的方法添加value属性的职位menucache
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

    public User queryByUsername(@Param("username") String username) {
        return userDAO.queryByUsername(username);
    }

    public Set<String> queryRoles(String username) {
        return userDAO.queryRoles(username);
    }


    public Set<String> queryPermissions(String username) {
        return userDAO.queryPermissions(username);
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void updatePwd(User user) {
        userDAO.updatePwd(user);
    }

    public void deleteById(Serializable id) {
        userDAO.deleteById(id);
    }


}
