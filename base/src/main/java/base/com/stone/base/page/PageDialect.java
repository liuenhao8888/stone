package com.stone.base.page;

/**
 * 分页sql接口,不同数据库需要实现该接口
 * 
 * @author Administrator
 *
 */
public interface PageDialect {

	public StringBuffer getPaginationString(String sql, int start, int pageSize);
}
