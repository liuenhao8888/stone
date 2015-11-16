package com.stone.base.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisSessionDAO extends AbstractSessionDAO {

	private RedisTemplate<Object, Object> redisTemplate;
	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
	private final String SHIRO_REDIS_SESSION_PRE = "shiro_redis_session:";

	public void update(Session session) throws UnknownSessionException {
		this.saveSession(session);
	}

	/**
	 * save session
	 * 
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		}
		
//		session.setTimeout(1800*1000);  
		redisTemplate.opsForValue().set(getKey(session.getId()), session);
	}

	public void delete(Session session) {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		}
		redisTemplate.delete(getKey(session.getId()));

	}

	public Collection<Session> getActiveSessions() {
		Set<Session> sessions = new HashSet<Session>();

		Set<Object> keys = redisTemplate.keys(getKey("*"));
		if (keys != null && keys.size() > 0) {
			for (Object key : keys) {
				Session s = (Session) redisTemplate.opsForValue().get(key);
				sessions.add(s);
			}
		}

		return sessions;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		this.saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if (sessionId == null) {
			logger.error("session id is null");
			return null;
		}

		Session s = (Session) redisTemplate.opsForValue().get(getKey(sessionId));
		return s;
	}

	
	private String getKey(Serializable sessionId) {
		return this.SHIRO_REDIS_SESSION_PRE + sessionId;
	}

	public RedisTemplate<Object, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		this.redisTemplate = redisTemplate.getUserRedisTemplate();
	}

}