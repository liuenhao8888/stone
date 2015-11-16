package com.stone.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stone.base.system.SystemConstants;
import com.stone.user.model.TAdmin;
import com.stone.user.model.TUser;
/**
 * 平台管理人员
 * @author ce
 *
 */
public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		TAdmin a = (TAdmin) request.getSession().getAttribute(
				SystemConstants.SESSION_ADMIN);
		if (a==null || a.getType()!=1) {
			request.getRequestDispatcher("/login.jsp").forward(req, rsp);
		} else {
			chain.doFilter(req, rsp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
