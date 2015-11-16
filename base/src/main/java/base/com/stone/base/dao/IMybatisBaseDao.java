package com.stone.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.stone.base.exception.DaoException;
import com.stone.base.mapper.SqlMapper;

/**
 * 框架父类IbatisDao接口
 * 
 * @author stone
 *
 */

public interface IMybatisBaseDao {

	public <T> T getMapper(Class<T> t) throws DaoException;

	/**
	 * 查询对象
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public Object selectObject(String sqlId, Object o) throws DaoException;

	/**
	 * 查询对象集合
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public List selectObjects(String sqlId, Object o) throws DaoException;

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param sql参数
	 * @return
	 * @throws DaoException
	 */
	public Object insertObject(String sqlId) throws DaoException;

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public Object insertObject(String sqlId, final Object o)
			throws DaoException;

	public void insertObjects(String sqlId, final List<Object> list)
			throws DaoException;

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @param sql参数
	 * @return
	 * @throws DaoException
	 */
	public void updateObject(String sqlId) throws DaoException;

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public void updateObject(String sqlId, Object o) throws DaoException;

	public void updateObjects(String sqlId, final List<Object> list)
			throws DaoException;

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param sql参数
	 * @throws DaoException
	 */
	public void deleteObject(String sqlId) throws DaoException;

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @throws DaoException
	 */
	public void deleteObject(String sqlId, Object o) throws DaoException;

	public void deleteObjects(String sqlId, final List<Object> list)
			throws DaoException;

	/**
	 * 计数
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public int countObject(String sqlId, Object o) throws DaoException;

	/**
	 * 分页查询
	 * 
	 * @param sqlId
	 * @param parameter
	 *            参数
	 * @param skipResults
	 *            起始行
	 * @param maxResults
	 *            数据量
	 * @return
	 * @throws DaoException
	 */
	public List selectObjects(String sqlId, Object parameter, int skipResults,
			int maxResults) throws DaoException;

	public Object select(Class<? extends SqlMapper> c, Object o)
			throws DaoException;

	public void insert(Class<? extends SqlMapper> c, Object o)
			throws DaoException;

	public void update(Class<? extends SqlMapper> c, Object o)
			throws DaoException;

	public void delete(Class<? extends SqlMapper> c, Object o)
			throws DaoException;

}
