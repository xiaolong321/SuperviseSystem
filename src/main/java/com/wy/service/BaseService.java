package com.wy.service;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.List;

/**
 * 缓存注解：
 * @Cacheable 一般应用到查询方法上，先从缓存中读取数据，若缓存中没有，再调用该方法获取数据，然后将数据结果放入缓存中。
 * @CacheEvict 一般应用到删除方法上，调用方法时会从缓存中移除相应的数据。
 * @CachePut 一般应用到新增/修改方法上，每次都会执行方法，并且把执行结果放入缓存。
 * 如果方式是根据唯一的值进行查询的，那么指定key值为#{参数}
 * 如果不是查询值进行查询的，则不需要指定key。
 * <p>
 * Created by Administrator on 2/15/2017.
 */
public interface BaseService<T, PK extends Serializable> {

    public List<T> queryAll();

    public T queryById(Serializable id);

    public void add(T t);

    public void update(T t);

    public void deleteById(Serializable id);

}
