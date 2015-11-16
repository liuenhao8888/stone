package com.stone.base.security;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.data.redis.core.RedisTemplate;

import com.stone.base.dao.IMybatisBaseDao;
import com.stone.security.mapper.TResourceMapper;
import com.stone.security.model.TResource;
import com.stone.user.model.TUser;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	protected static final Logger log = Logger.getLogger(ChainDefinitionSectionMetaSource.class);

	private RedisTemplate<String, TUser> redisTemplate;

	private IMybatisBaseDao ibatisBaseDao;

	private String filterChainDefinitions;
	public static final String ROLES_STRING = "authc,roleOrFilter[{0}]";
//	public static final String ROLES_STRING = "authc,roles[{0}]";
	public static final String PERMS_STRING = "authc,perms[{0}]";

	public Section getObject() throws BeansException {

		List<TResource> list = ibatisBaseDao.getMapper(TResourceMapper.class).getAll();
		Ini ini = new Ini();
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		for (Iterator<TResource> it = list.iterator(); it.hasNext();) {
			TResource resource = it.next();
			if (StringUtils.isNotEmpty(resource.getUrl())) {
				section.put(resource.getUrl(), MessageFormat.format(ROLES_STRING, resource.getRoleName()));
			}
		}
		printSection(section);
		return section;
	}

	private void printSection(Ini.Section sec) {
		log.info("---------------------- 系统配置的资源访问权限  -------------------------------");
		for (Map.Entry<String, String> entry : sec.entrySet()) {
			log.info(entry.getKey() + " = " + entry.getValue());
		}
		log.info("---------------------------------------------------------------------");
	}

	/**
	 * @param filterChainDefinitions
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		// String dbFiter = "";
		// List<TResource> list =
		// ibatisBaseDao.getMapper(TResourceMapper.class).getAll();
		// for (Iterator<TResource> it = list.iterator(); it.hasNext();) {
		// TResource resource = it.next();
		// if (StringUtils.isNotEmpty(resource.getUrl())) {
		// dbFiter += resource.getUrl() + " = "+
		// MessageFormat.format(ROLES_STRING, resource.getRoleId()) + "\n";
		// }
		// }
		// log.info(filterChainDefinitions + dbFiter);
		// this.filterChainDefinitions = filterChainDefinitions + dbFiter;
		this.filterChainDefinitions = filterChainDefinitions;

	}

	public String getFilterChainDefinitions() {
		return filterChainDefinitions;
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}

	public RedisTemplate<String, TUser> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, TUser> redisTemplate) {
		this.redisTemplate = redisTemplate.getUserRedisTemplate();
	}

	public IMybatisBaseDao getIbatisBaseDao() {
		return ibatisBaseDao;
	}

	public void setIbatisBaseDao(IMybatisBaseDao ibatisBaseDao) {
		this.ibatisBaseDao = ibatisBaseDao;
	}

}