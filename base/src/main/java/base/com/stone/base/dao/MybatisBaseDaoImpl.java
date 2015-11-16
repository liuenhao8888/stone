package com.stone.base.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.stone.base.exception.DaoException;
import com.stone.base.mapper.SqlMapper;

/**
 * 框架父类IbatisDao实现类
 * 
 * @author stone
 *
 */
@Repository("ibatisBaseDao")
public class MybatisBaseDaoImpl extends SqlSessionDaoSupport implements
		IMybatisBaseDao {

	protected final Log log = LogFactory.getLog(getClass());
	
	public SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

//	@Autowired
//	@Qualifier ("sqlSessionFactory")
	@Resource(name="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	 

	/**
	 * 查询对象
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public Object selectObject(String sqlId, Object o) throws DaoException {
		Object object;
		try {
			object = this.getSqlSession().selectOne(sqlId, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： selectObject( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
		return object;
	}

	/**
	 * 查询对象集合
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public List selectObjects(String sqlId, Object o) throws DaoException {
		List queryResult = null;
		try {
			queryResult = this.getSqlSession().selectList(sqlId, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： selectObjects( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
		return queryResult;
	}

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
			int maxResults) throws DaoException {
		List list = null;
		try {
			RowBounds rb = new RowBounds(skipResults, maxResults);
			list = this.getSqlSession().selectList(sqlId, parameter, rb);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： selectObjects( " + sqlId + ","
					+ parameter + "," + skipResults + "," + maxResults
					+ ")  时出错！！！");
		}
		return list;

	}

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return 生成的id
	 * @throws DaoException
	 */
	public Object insertObject(String sqlId) throws DaoException {
		Object primaryKey;
		try {
			primaryKey = this.getSqlSession().insert(sqlId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： insertObject( " + sqlId
					+ ",)  时出错！！！");
		}
		return primaryKey;
	}

	/**
	 * 插入对象
	 * 
	 * @param sqlId
	 * @param object
	 *            sql参数
	 * @return 生成的id
	 * @throws DaoException
	 */
	public Object insertObject(String sqlId, final Object o)
			throws DaoException {
		Object primaryKey;
		try {
			primaryKey = this.getSqlSession().insert(sqlId, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： insertObject( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
		return primaryKey;
	}

	public void insertObjects(String sqlId, List<Object> list)
			throws DaoException {
		try {
			SqlSession s = this.sqlSessionFactory.openSession(
					ExecutorType.BATCH, false);
			for (Object o : list) {
				s.insert(sqlId, o);
			}
			s.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： insertObjects( " + sqlId + ","
					+ list + ")  时出错！！！");
		}
	}

	/**
	 * 更新
	 * 
	 * @param sqlId
	 * @throws DaoException
	 */
	public void updateObject(String sqlId) throws DaoException {
		try {
			this.getSqlSession().update(sqlId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： updateObject( " + sqlId
					+ ")  时出错！！！");
		}
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
	public void updateObject(String sqlId, Object o) throws DaoException {
		try {
			this.getSqlSession().update(sqlId, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： updateObject( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
	}

	public void updateObjects(String sqlId, List<Object> list)
			throws DaoException {
		try {
			// SqlSession s =
			// this.sqlSessionFactory.openSession(ExecutorType.BATCH,false);
			// for(Object o : list){
			// s.update(sqlId, o);
			// }
			// s.commit(true);
			for (Object o : list) {
				this.getSqlSession().update(sqlId, o);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： updateObject( " + sqlId + ","
					+ list + ")  时出错！！！");
		}
	}

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @throws DaoException
	 */
	public void deleteObject(String sqlId) throws DaoException {
		try {
			this.getSqlSession().delete(sqlId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： deleteObject( " + sqlId
					+ ",)  时出错！！！");
		}
	}

	/**
	 * 删除
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @throws DaoException
	 */
	public void deleteObject(String sqlId, Object o) throws DaoException {
		try {
			this.getSqlSession().delete(sqlId, o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： deleteObject( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
	}

	public void deleteObjects(String sqlId, List<Object> list)
			throws DaoException {
		try {
			SqlSession s = this.sqlSessionFactory.openSession(
					ExecutorType.BATCH, false);
			for (Object o : list) {
				s.delete(sqlId, o);
			}
			s.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： deleteObjects( " + sqlId + ","
					+ list + ")  时出错！！！");
		}
	}

	/**
	 * 计数
	 * 
	 * @param sqlId
	 * @param o
	 *            sql参数
	 * @return
	 * @throws DaoException
	 */
	public int countObject(String sqlId, Object o) throws DaoException {
		try {
			return ((Integer) this.getSqlSession().selectOne(sqlId, o))
					.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： countObject( " + sqlId + "," + o
					+ ")  时出错！！！");
		}
	}

	public void delete(Class<? extends SqlMapper> c, Object o)
			throws DaoException {
		try {
			this.getSqlSession().getMapper(c).delete(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： delete( " + c.getName() + "," + o
					+ ")  时出错！！！");
		}

	}

	public void insert(Class<? extends SqlMapper> c, Object o)
			throws DaoException {
		try {
			this.getSqlSession().getMapper(c).insert(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： insert( " + c.getName() + "," + o
					+ ")  时出错！！！");
		}
	}

	public Object select(Class<? extends SqlMapper> c, Object o)
			throws DaoException {
		Object object;
		try {
			object = this.getSqlSession().getMapper(c).select(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： select( " + c.getName() + "," + o
					+ ")  时出错！！！");
		}
		return object;
	}

	public void update(Class<? extends SqlMapper> c, Object o)
			throws DaoException {
		try {
			this.getSqlSession().getMapper(c).update(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("程序执行方法： update( " + c.getName() + "," + o
					+ ")  时出错！！！");
		}
	}

	public <T> T getMapper(Class<T> t) throws DaoException {
		// TODO Auto-generated method stub
		T t1 = this.getSqlSession().getMapper(t);
		return t1;
	}

}
