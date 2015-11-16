package com.stone.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.dao.DataAccessException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisCache<K, V> implements Cache<K, V> {

	private RedisTemplate<K, V> redisTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String SHIRO_REDIS_CACHE = "shiro_redis_cache:";


	@SuppressWarnings("unchecked")
	private K getKey(K key) {
		return (K) (this.SHIRO_REDIS_CACHE + key);
	}

	public V get(K key) throws CacheException {
		logger.debug("根据key从Redis中获取对象 key [" + key + "]");
		try {
			if (key == null) {
				return null;
			} else {
				return redisTemplate.opsForValue().get(getKey(key));
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	public V put(K key, V value) throws CacheException {
		logger.debug("根据key从存储 key [" + key + "]");
		try {
			redisTemplate.opsForValue().set(getKey(key), value);
			return value;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public V remove(K key) throws CacheException {
		logger.debug("从redis中删除 key [" + key + "]");
		try {
			V previous = get(key);
			redisTemplate.delete(getKey(key));
			return previous;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public void clear() throws CacheException {
		logger.debug("从redis中删除所有元素");
		try {
			redisTemplate.execute(new RedisCallback<Object>() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					connection.flushDb();
					return null;
				}
			});

		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public int size() {
		try {
			int size = (Integer) redisTemplate.execute(new RedisCallback<Object>() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					return connection.dbSize();
				}
			});

			return size;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@SuppressWarnings("unchecked")
	public Set<K> keys() {
		try {
			K k = (K) "*";
			Set<K> keys = redisTemplate.keys(getKey(k));
			return keys;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public Collection<V> values() {
		try {
			Set<K> keys = keys();
			if (!CollectionUtils.isEmpty(keys)) {
				List<V> values = new ArrayList<V>(keys.size());
				for (K key : keys) {
					V value = get(key);
					if (value != null) {
						values.add(value);
					}
				}
				return Collections.unmodifiableList(values);
			} else {
				return Collections.emptyList();
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate.getUserRedisTemplate();
	}
	
	
	

}