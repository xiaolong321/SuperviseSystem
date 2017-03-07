package com.wy.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;

/**
 * Created by Administrator on 2017/3/7.
 */
@CacheConfig(cacheNames = "menuCache")
public interface UserRoleService {

    @CachePut
    public void add(String id,int roleId);
}
