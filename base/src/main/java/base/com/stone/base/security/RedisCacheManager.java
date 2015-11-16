package com.stone.base.security;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache; 
import org.apache.shiro.cache.CacheException; 
import org.apache.shiro.cache.CacheManager; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
  
  
public class RedisCacheManager extends  AbstractCacheManager { 
  
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class); 
      
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>(); 
    
    private Cache redisCache; 
      
      
    public <K, V> Cache<K, V> getCache(String name) throws CacheException { 
        logger.debug("获取名称为: " + name + " 的RedisCache实例"); 
        Cache<K, V> c = caches.get(name); 
        if(c==null){ 
        	c = redisCache;
            caches.put(name, c); 
        } 
        return c; 
    }


	public Cache getRedisCache() {
		return redisCache;
	}


	public void setRedisCache(Cache redisCache) {
		this.redisCache = redisCache;
	}


	public ConcurrentMap<String, Cache> getCaches() {
		return caches;
	}


	protected Cache createCache(String name) throws CacheException {
		return getCache(name);
	} 
    
    
    
    
    
      
} 