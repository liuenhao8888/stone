package com.stone.base.page;

/**
 * 分页数据集处理类
 * 
 * @author 崔辉
 *
 */
public class PageUtil {

	// 数据库类型
	private String dbType;
	private PageDialect pageDialect = null;
	// 每页显示的记录数
	private int numPerPage;
	// 记录总数
	private int totalRows = -1;
	// 总页数
	private int totalPages;
	// 当前页码
	private int currentPage;
	// 起始行数
	private int startIndex;
	// 结束行数
	private int lastIndex;

	public PageUtil() {

	}

	/**
	 * 返回构造完成的sql语句
	 * 
	 * @param sql
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public String getPaginationString(String sql, int start, int pageSize) {
		StringBuffer strBuffer = null;
		checkPageDialect();

		// 计算起始页数
		setStartIndex(start);
		// 设置每页显示记录数
		setNumPerPage(pageSize);
		// 设置要显示的页数
		setCurrentPage();
		// 计算总页数
		setTotalPages();
		// 计算结束行数
		setLastIndex();

		if ("oracle".indexOf(dbType) != -1 || "sqlserver".indexOf(dbType) != -1
				|| "mysql".indexOf(dbType) != -1) {
			strBuffer = pageDialect.getPaginationString(sql, startIndex,
					lastIndex);
		} else {
			strBuffer = pageDialect.getPaginationString(sql, start, pageSize);
		}

		return strBuffer.toString();
	}

	/**
	 * 计算结束时候的索引
	 *
	 */
	public void setLastIndex() {
		// 如果在前没有设置过总数，最后数为start + num
		if (totalRows == -1) {
			this.lastIndex = startIndex + numPerPage;
			return;
		}
		// 如果在前设置过总数，按照算法计算
		if (totalRows < numPerPage) {
			this.lastIndex = totalRows;
		} else if ((totalRows % numPerPage == 0)
				|| (totalRows % numPerPage != 0 && currentPage < totalPages)) {
			this.lastIndex = currentPage * numPerPage;
		} else if (totalRows % numPerPage != 0 && currentPage == totalPages) {// 最后一页
			this.lastIndex = totalRows;
		}
	}

	/**
	 * 设置总页数
	 *
	 */
	public void setTotalPages() {
		if (totalRows % numPerPage == 0) {
			this.totalPages = totalRows / numPerPage;
		} else {
			this.totalPages = (totalRows / numPerPage) + 1;
		}
	}

	/**
	 * 设置当前要显示的页数
	 *
	 */
	public void setCurrentPage() {
		this.currentPage = (this.startIndex / this.numPerPage) + 1;
	}

	/**
	 * 设置每页显示记录数
	 * 
	 * @param pageSize
	 */
	public void setNumPerPage(int pageSize) {
		this.numPerPage = pageSize;
	}

	/**
	 * 设置起始行数
	 * 
	 * @param start
	 */
	public void setStartIndex(int start) {
		// TODO Auto-generated method stub
		this.startIndex = start;
	}

	/**
	 * 判断当前数据库类型,默认为DB2
	 *
	 */
	public void checkPageDialect() {
		if (pageDialect == null) {
			if ("oracle".indexOf(dbType) != -1) {
				pageDialect = new PageDialectOracle();

			} else if ("sqlserver".indexOf(dbType) != -1) {
				pageDialect = new PageDialectSqlServer();

			} else if ("mysql".indexOf(dbType) != -1) {
				pageDialect = new PageDialectMySql();

			} else {
				// 默认为DB2
				pageDialect = new PageDialectDB2();
			}
		}
	}

	/**
	 * 获得设置的数据库类型
	 * 
	 * @return
	 */
	public String getDbType() {
		return dbType;
	}

	/**
	 * 设置数据库类型
	 * 
	 * @param dbType
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/**
	 * 获得设置的数据库方言
	 * 
	 * @return
	 */
	public PageDialect getPageDialect() {
		return pageDialect;
	}

	/**
	 * 设置数据库方言
	 * 
	 * @param pageDialect
	 */
	public void setPageDialect(PageDialect pageDialect) {
		this.pageDialect = pageDialect;
	}
}
