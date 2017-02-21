package com.wy.cache;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/21.
 */
public class UserServiceAspect extends BaseCacheService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceAspect.class);
}
