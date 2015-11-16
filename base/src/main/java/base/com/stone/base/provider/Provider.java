package com.stone.base.provider;

import java.util.Map;

public class Provider {

	public String updateStatusByIds(Map m) {
		int[] ids = (int[]) m.get("ids");
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < ids.length; i++) {
			sb.append(ids[i]).append(",");
		}
		int status = (Integer) m.get("status");
		return "update " + m.get("tblName") + " set status=" + status
				+ " where id in (" + sb.substring(0, sb.length() - 1) + ")";
	}
}
