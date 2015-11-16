package com.stone.base.page;

import com.stone.base.system.SystemConstants;

/**
 * 分页实体
 * 
 * @author stone
 *
 */
public class Page {
	/**
	 * 总记录数
	 */
	private long rows;
	/**
	 * 每页显示的记录数
	 */
	private long size;
	/**
	 * 当前页数
	 */
	private long current;
	/**
	 * 总页数
	 */
	private long pages;
	/**
	 * 起始行数
	 */
	private long start;
	/**
	 * 翻页方法
	 */
	private String method;

	/**
	 * 构造方法
	 * 
	 */
	public Page() {
		size = SystemConstants.PAGE_SIZE;
	}

	/**
	 * 初始化pager对象
	 * 
	 * @param _totalRows
	 */
	public void init(long _totalRows) {
		// size = SystemConstants.pageSize;
		rows = _totalRows;
		pages = rows / size;
		long mod = rows % size;
		if (mod > 0 || rows == 0) {
			pages++;
		}
		// refresh(current);
		initMethod();
		if (current > pages)
			current = pages;
		if (current < 1)
			current = 1;
		start = (current - 1) * size;
	}

	/**
	 * 刷新当前页
	 * 
	 * @param _currentPage
	 */
	/*
	 * private void refresh(long _currentPage) { current = _currentPage; if
	 * (current > pages) { last(); } start = (current - 1) * size; }
	 */

	/**
	 * 初始化翻页方法
	 */
	private void initMethod() {
		if (method != null && !"".equals(method)) {
			if (method.equals("first")) {
				first();
			} else if (method.equals("previous")) {
				previous();
			} else if (method.equals("next")) {
				next();
			} else if (method.equals("last")) {
				last();
			} else if (method.equals("gotoPage")) {
				gotoPage();
			}
		}
	}

	/**
	 * 跳转到首页
	 * 
	 */
	private void first() {
		current = 1;
		start = 0;
	}

	/**
	 * 上一页
	 * 
	 */
	private void previous() {
		if (current == 1) {
			return;
		}
		current--;
		start = (current - 1) * size;
	}

	/**
	 * 下一页
	 * 
	 */
	private void next() {
		if (current < pages) {
			current++;
		}
		start = (current - 1) * size;
	}

	/**
	 * 跳转到尾页
	 * 
	 */
	private void last() {
		current = pages;
		start = (current - 1) * size;
	}

	/**
	 * 跳转到某页
	 * 
	 */
	private void gotoPage() {
		if (current < 1)
			first();
		else if (current > pages)
			last();
		start = (current - 1) * size;
	}

	public long getRows() {
		return rows;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getStart() {
		return start;
	}

	public long getPages() {
		return pages;
	}

	public long getCurrent() {
		return current;
	}

	public long getSize() {
		return size;
	}

	public void setRows(long totalRows) {
		rows = totalRows;
	}

	public void setPages(long totalPages) {
		pages = totalPages;
	}

	public void setCurrent(long currentPage) {
		current = currentPage;
	}

	public void setSize(long pageSize) {
		size = pageSize;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String pagerMethod) {
		method = pagerMethod;
	}
}
