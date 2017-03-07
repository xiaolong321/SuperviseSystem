package com.wy.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/7.
 */
@Repository
public interface UserRoleDAO {

    public void add(String id,int roleId);

}
