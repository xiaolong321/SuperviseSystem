package com.wy.cache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


/**
 * Created by Administrator on 2017/2/21.
 */
public class BaseCacheService{

    /**
     * Spring 的 Cache
     */
//    @Autowired
//    private CacheManager cacheManager;
//    private Cache cache;
//    private String cacheName;
//
//    public void setCacheManager(CacheManager cacheManager) {
//        this.cacheManager = cacheManager;
//    }
//
//    public void setCache(Cache cache) {
//        this.cache = cache;
//    }
//
//    public void setCacheName(String cacheName) {
//        this.cacheName = cacheName;
//    }
//
//    /**
//     * 在所有的属性设置完成以后,
//     * 属性 cacheName 就非空
//     * cacheName 这个 String 对象在我们的项目中就是 ehcache.xml 中配置的字符串
//     * cache 就可以获得一个缓存对象
//     *
//     * @throws Exception
//     */
//    public void afterPropertiesSet() throws Exception {
//        cache = cacheManager.getCache(cacheName);
//    }
//
//    // 以下是自定义的方法
//    /**
//     * 清空缓存中所有的对象
//     */
//    public void clear(){
//        cache.clear();
//    }
//
//    /**
//     * 将一个对象放入缓存
//     * @param key
//     * @param value
//     */
//    public void put(String key,Object value){
//        cache.put(key,value);
//    }
//
//    /**
//     * 将一个对象移出缓存
//     * @param key
//     */
//    public void evict(String key){
//        cache.evict(key);
//    }
//
//    /**
//     * 从缓存中获得一个对象
//     * @param key
//     * @return
//     */
//    public Object get(String key){
//        Cache.ValueWrapper vw = cache.get(key);
//        if(vw!=null){
//            return vw.get();
//        }
//        return null;
//    }

}