package com.stone.base.page;

import java.util.HashMap;
import java.util.Map;

/**
 * oracle分页实现
 * 
 * @author stone
 *
 */
public class OracleDialect implements Dialect {

	/**
	 * 取得该类数据库的分页sql
	 */
	public String getLimitString(String sql, int offset, int limit) {
		int lastIndex = offset + limit;
		Map reMap = getTransactAnnotateSql(sql);
		String originSql = (String) reMap.get("originSql");
		originSql = trim(originSql);
		String annotationSql = (String) reMap.get("annotationSql");

		StringBuffer sb = null;
		sb = new StringBuffer(" SELECT * FROM ( ");
		sb.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		sb.append(originSql);
		sb.append(" ) temp where num <= " + lastIndex);
		sb.append(" ) WHERE　num > " + offset + " ");
		sb.append(SQL_END_DELIMITER);
		sb.append(annotationSql);

		return sb.toString();
	}

	public boolean supportsLimit() {
		return true;
	}

	private String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			sql = sql.substring(0,
					sql.length() - 1 - SQL_END_DELIMITER.length());
		}
		return sql;
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
