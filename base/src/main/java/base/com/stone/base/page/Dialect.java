package com.stone.base.page;

/**
 * 
 * 类似hibenate中的数据库方言接口Dialect
 * 
 * @author stone
 * 
 *
 */
public interface Dialect {
	/**
	 * 结束符
	 */
	public static final String SQL_END_DELIMITER = ";";

	/**
	 * 是否支持分页
	 * 
	 * @return
	 */
	public boolean supportsLimit();

	/**
	 * 取得该类数据库的分页sql
	 */
	public String getLimitString(String sql, int offset, int limit);
}
