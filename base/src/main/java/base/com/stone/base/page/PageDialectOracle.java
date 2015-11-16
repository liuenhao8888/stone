package com.stone.base.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造Oracle数据库的分页语句操作类
 * 
 * @author 崔辉
 *
 */
public class PageDialectOracle implements PageDialect {

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
		Map reMap = getTransactAnnotateSql(sql);
		String originSql = (String) reMap.get("originSql");
		String annotationSql = (String) reMap.get("annotationSql");

		StringBuffer paginationSQL = null;
		paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		paginationSQL.append(originSql);
		paginationSQL.append(" ) temp where num <= " + lastIndex);
		paginationSQL.append(" ) WHERE　num > " + startIndex + " ");
		paginationSQL.append(annotationSql);

		return paginationSQL;
	}

	/**
	 * 支持sql语句加注释
	 * 
	 * @param sql
	 * @return
	 */
	private Map getTransactAnnotateSql(String sql) {
		// TODO Auto-generated method stub
		Map reMap = new HashMap();
		String originSql = sql;
		String annotationSql = "";

		// 支持SQL语句后加注释
		String separator2 = "--";
		if (originSql != null && originSql.indexOf(separator2) != -1) {
			int position = originSql.indexOf(separator2);
			annotationSql = originSql.substring(position, originSql.length());
			originSql = originSql.substring(0, position);
		}

		reMap.put("originSql", originSql);
		reMap.put("annotationSql", annotationSql);
		return reMap;
	}

}
