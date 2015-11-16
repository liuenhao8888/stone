package com.stone.base.page;

/**
 * 构造db2数据库的分页语句操作类
 * 
 * @author 崔辉
 *
 */
public class PageDialectDB2 implements PageDialect {

	/**
	 * 接口中的方法,返回构造完成的分页sql语句
	 */
	public StringBuffer getPaginationString(String sql, int start, int pageSize) {
		return getLimitString(sql, start + 1, start + pageSize);
	}

	/**
	 * 返回构造完成的分页sql语句
	 * 
	 * @param sql
	 * @param from
	 * @param to
	 * @return
	 */
	private StringBuffer getLimitString(String sql, int from, int to) {
		int startOfSelect = sql.toLowerCase().lastIndexOf("select");

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100)
				.append(sql.substring(0, startOfSelect)) // add the comment
				.append("select * from ( select ") // nest the main query in an
				// outer select
				.append(getRowNumber(sql)); // add the rownnumber bit into the
		// outer query select list

		if (hasDistinct(sql)) {
			pagingSelect.append(" row_.* from ( ") // add another (inner)
					// nested select
					.append(sql.substring(startOfSelect)) // add the main
					// query
					.append(" ) as row_"); // close off the inner nested select
		} else {
			pagingSelect.append(sql.substring(startOfSelect + 6)); // add the
		}

		pagingSelect.append(" ) as temp_ where rownumber_ ");

		// add the restriction to the outer select

		pagingSelect.append("between ").append(from).append(" and ").append(to);

		return pagingSelect;
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
