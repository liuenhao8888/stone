package com.stone.base.page;

/**
 * 构造SqlServer数据库的分页语句操作类
 * 
 * @author Administrator
 *
 */
public class PageDialectSqlServer implements PageDialect {

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
		paginationSQL.append(" SELECT Top " + lastIndex + " *");
		paginationSQL.append(" FROM  (SELECT Top ( "
				+ (startIndex + lastIndex - 1) + ") * FROM ");
		paginationSQL.append(" (" + sql + ") t ");
		paginationSQL.append(" ) t1 ) t2");
		return paginationSQL;
	}

}
