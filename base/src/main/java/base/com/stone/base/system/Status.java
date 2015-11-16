package com.stone.base.system;

/**
 * 信息条目的状态
 * 
 * @author stone
 *
 */
public class Status {

	public final static int waiting = 0; // 刚入库的信息 等待审批
	public final static int no = 1; // 审批未通过
	public final static int yes = 2; // 审批通过
	public final static int display = 3; // 前台显示
	public final static int hidden = 4; // 取消前台显示
	public final static int top = 5;// 置顶

}
