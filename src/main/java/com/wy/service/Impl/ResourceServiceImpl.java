package com.wy.service.Impl;


import com.wy.bean.Resource;
import com.wy.dao.ResourceDAO;
import com.wy.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class ResourceServiceImpl implements ResourceService{

    @javax.annotation.Resource
    private ResourceDAO resourceDAO;

    public List<Resource> queryAll() {
        return resourceDAO.queryAll();
    }

    public Resource queryById(Serializable id) {
        return resourceDAO.queryById(id);
    }

    public void add(Resource resource) {
        resourceDAO.add(resource);
    }

    public void update(Resource resource) {
        resourceDAO.update(resource);
    }

    public void deleteById(Serializable id) {
        resourceDAO.deleteById(id);
    }
}
