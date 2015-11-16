package com.stone.base.page;

/**
 * 构造SqlServer数据库的分页语句操作类
 * 
 * @author stone
 */
public class SqlServerDialect implements Dialect {

	public String getLimitString(String sql, int offset, int limit) {
		StringBuffer paginationSQL = null;
		paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(" SELECT Top " + limit + " *");
		paginationSQL.append(" FROM  (SELECT Top ( " + (offset + limit - 1)
				+ ") * FROM ");
		paginationSQL.append(" (" + sql + ") t ");
		paginationSQL.append(" ) t1 ) t2");
		paginationSQL.append(SQL_END_DELIMITER);
		return paginationSQL.toString();
	}

	public boolean supportsLimit() {
		return true;
	}

}
