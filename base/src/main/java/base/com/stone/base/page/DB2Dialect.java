package com.stone.base.page;

/**
 * db2 数据库分页
 * 
 * @author stone
 *
 */
public class DB2Dialect implements Dialect {

	/**
	 * 取得该类数据库的分页sql
	 */
	public String getLimitString(String sql, int offset, int limit) {
		int to = offset + limit;
		sql = trim(sql);
		int startOfSelect = sql.toLowerCase().lastIndexOf("select");

		StringBuffer sb = new StringBuffer(sql.length() + 100)
				.append(sql.substring(0, startOfSelect)) // add the comment
				.append("select * from ( select ") // nest the main query in an
				// outer select
				.append(getRowNumber(sql)); // add the rownnumber bit into the
		// outer query select list

		if (hasDistinct(sql)) {
			sb.append(" row_.* from ( ") // add another (inner)
					// nested select
					.append(sql.substring(startOfSelect)) // add the main
					// query
					.append(" ) as row_"); // close off the inner nested select
		} else {
			sb.append(sql.substring(startOfSelect + 6)); // add the
		}

		sb.append(" ) as temp_ where rownumber_ ");

		// add the restriction to the outer select

		sb.append("between ").append(offset).append(" and ").append(to);

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
	 * 获得行数的sql
	 * 
	 * @param sql
	 * @return
	 */
	private String getRowNumber(String sql) {
		StringBuffer rownumber = new StringBuffer(50)
				.append("rownumber() over(");

		int orderByIndex = sql.toLowerCase().indexOf("order by");

		if (orderByIndex > 0 && !hasDistinct(sql)) {
			rownumber.append(sql.substring(orderByIndex));
		}

		rownumber.append(") as rownumber_,");

		return rownumber.toString();
	}

	/**
	 * 判断是否有distinct
	 * 
	 * @param sql
	 * @return
	 */
	private boolean hasDistinct(String sql) {
		return sql.toLowerCase().indexOf("select distinct") >= 0;
	}

}
