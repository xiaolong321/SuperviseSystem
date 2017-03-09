package com.wy.dao;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2/15/2017.
 */

public interface BaseDAO<T,PK extends Serializable> {

    public List<T> queryAll();

    public T queryById(Serializable id);

    public void add(T t);

    public void update(T t);

    public void deleteById(Serializable id);
}
