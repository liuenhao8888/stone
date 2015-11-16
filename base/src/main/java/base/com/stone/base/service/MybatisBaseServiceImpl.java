package com.stone.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.stone.base.dao.IMybatisBaseDao;
import com.stone.base.exception.BusinessException;
import com.stone.base.mapper.SqlMapper;

/**
 * 框架service实现类
 * 
 * @author stone
 *
 */
@Service("mybatisBaseService")
public class MybatisBaseServiceImpl implements IMybatisBaseService {
	
	@Resource(name="ibatisBaseDao")
	private IMybatisBaseDao ibatisBaseDao;
	
	

	public Object addObject(String sqlId) throws BusinessException {
		Object temp = null;
		try {
			temp = this.ibatisBaseDao.insertObject(sqlId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层addObject方法出错！");
		}
		return temp;
	}

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return 新增生成的id
	 * @throws BusinessException
	 */
	public Object addObject(String sqlId, Object o) throws BusinessException {
		Object temp = null;
		try {
			temp = this.ibatisBaseDao.insertObject(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层addObject方法出错！");
		}
		return temp;
	}

	public void addObjects(String sqlId, final List list)
			throws BusinessException {
		try {
			this.ibatisBaseDao.insertObjects(sqlId, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层addObject方法出错！");
		}
	}

	/**
	 * 计数
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public int countObject(String sqlId, Object o) throws BusinessException {
		// TODO Auto-generated method stub
		int temp = 0;
		try {
			temp = this.ibatisBaseDao.countObject(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层countObject方法出错！");
		}
		return temp;
	}

	/**
	 * 查询对象
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public Object findObject(String sqlId, Object o) throws BusinessException {
		// TODO Auto-generated method stub
		Object temp = null;
		try {
			temp = this.ibatisBaseDao.selectObject(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层findObject方法出错！");
		}
		return temp;
	}

	/**
	 * 查询对象集合
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public List findObjects(String sqlId, Object o) throws BusinessException {
		// TODO Auto-generated method stub
		List temp = null;
		try {
			temp = this.ibatisBaseDao.selectObjects(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层findObjects方法出错！");
		}
		return temp;
	}

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public void modifyObject(String sqlId, Object o) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			this.ibatisBaseDao.updateObject(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层modifyObject方法出错！");
		}
	}

	public void modifyObjects(String sqlId, final List list)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			this.ibatisBaseDao.updateObjects(sqlId, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层modifyObject方法出错！");
		}
	}

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @throws BusinessException
	 */
	public void removeObject(String sqlId, Object o) throws BusinessException {
		// TODO Auto-generated method stub

		try {
			this.ibatisBaseDao.deleteObject(sqlId, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层removeObject方法出错！");
		}

	}

	public void removeObjects(String sqlId, final List list)
			throws BusinessException {
		// TODO Auto-generated method stub

		try {
			this.ibatisBaseDao.deleteObjects(sqlId, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层removeObject方法出错！");
		}

	}

	/**
	 * 查询对象集合
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws BusinessException
	 */
	public List findObjects(String sqlId, Object parameter, int skipResults,
			int maxResults) throws BusinessException {
		// TODO Auto-generated method stub
		List list = null;
		try {
			list = this.ibatisBaseDao.selectObjects(sqlId, parameter,
					skipResults, maxResults);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("执行业务层findObjects方法出错！");
		}
		return list;
	}

	public IMybatisBaseDao getIbatisBaseDao() {
		return ibatisBaseDao;
	}

	public void setIbatisBaseDao(IMybatisBaseDao ibatisBaseDao) {
		this.ibatisBaseDao = ibatisBaseDao;
	}

	public void delete(Class<? extends SqlMapper> c, Object o)
			throws BusinessException {
		try {
			this.ibatisBaseDao.delete(c, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("执行业务层delete方法出错！");
		}
	}

	public void insert(Class<? extends SqlMapper> c, Object o)
			throws BusinessException {
		try {
			this.ibatisBaseDao.insert(c, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("执行业务层insert方法出错！");
		}

	}

	public Object select(Class<? extends SqlMapper> c, Object o)
			throws BusinessException {
		Object temp = null;
		try {
			temp = this.ibatisBaseDao.select(c, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("执行业务层select方法出错！");
		}
		return temp;
	}

	public void update(Class<? extends SqlMapper> c, Object o)
			throws BusinessException {
		try {
			this.ibatisBaseDao.update(c, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("执行业务层update方法出错！");
		}

	}

	public <T> T getMapper(Class<T> t) throws BusinessException {
		// TODO Auto-generated method stub
		return this.ibatisBaseDao.getMapper(t);
	}

}
