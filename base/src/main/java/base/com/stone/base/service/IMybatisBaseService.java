package com.stone.base.service;

import java.util.List;


import com.stone.base.exception.BusinessException;
import com.stone.base.exception.DaoException;
import com.stone.base.mapper.SqlMapper;

/**
 * 框架Ibatis service接口
 * 
 * @author stone
 *
 */
public interface IMybatisBaseService {

	public <T> T getMapper(Class<T> t) throws BusinessException;
	
	/**
	 * 查询对象
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public Object findObject(String sqlId, Object o) throws BusinessException;

	/**
	 * 查询对象集合
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public List findObjects(String sqlId, Object o) throws BusinessException;

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return 新增生成的id
	 * @throws BusinessException
	 */
	public Object addObject(String sqlId) throws BusinessException;

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return 新增生成的id
	 * @throws BusinessException
	 */
	public Object addObject(String sqlId, final Object o)
			throws BusinessException;

	public void addObjects(String sqlId, final List list)
			throws BusinessException;

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public void modifyObject(String sqlId, Object o) throws BusinessException;

	public void modifyObjects(String sqlId, final List list)
			throws BusinessException;

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @throws BusinessException
	 */
	public void removeObject(String sqlId, Object o) throws BusinessException;

	public void removeObjects(String sqlId, final List list)
			throws BusinessException;

	/**
	 * 计数
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public int countObject(String sqlId, Object o) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param parameter
	 *            参数
	 * @param skipResults
	 *            起始位置
	 * @param maxResults
	 *            记录数
	 * @return
	 * @throws BusinessException
	 */
	public List findObjects(String sqlId, Object parameter, int skipResults,
			int maxResults) throws BusinessException;

	public Object select(Class<? extends SqlMapper> c, Object o)
			throws BusinessException;

	public void insert(Class<? extends SqlMapper> c, Object o)
			throws BusinessException;

	public void update(Class<? extends SqlMapper> c, Object o)
			throws BusinessException;

	public void delete(Class<? extends SqlMapper> c, Object o)
			throws BusinessException;

}
