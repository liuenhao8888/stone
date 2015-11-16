package com.stone.base.page;

/**
 * 构造MySql数据库的分页语句操作类
 * 
 * @author 崔辉
 *
 */
public class PageDialectMySql implements PageDialect {

	/**
	 * 构造分页sql语句
	 * 
	 * @param sql
	 * @param startIndex
	 * @param lastIndex
	 * @return
	 */
	public StringBuffer getPaginationString(String sql, int startIndex,
			int lastIndex) {
		StringBuffer paginationSQL = null;
		paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(sql);
		paginationSQL.append(" ) AS v limit " + startIndex + "," + lastIndex);

		return paginationSQL;
	}

}
