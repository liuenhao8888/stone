package com.stone.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.ExceptionMap;
import com.stone.base.system.SystemConstants;
import com.stone.user.model.TUser;
/**
 * 店铺管理人员
 * @author ce
 *
 */
public class ShopUserFilter implements Filter {
	
	private BaseController baseController;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		String url = request.getRequestURI();
//		String url = request.getRequestURI() + "?" + request.getQueryString();
//		TUser u = (TUser) request.getSession().getAttribute(
//				SystemConstants.SESSION_USER);
		TUser u = (TUser) baseController.getCurrentUser4redis(request);
		if (u==null || u.getType()!=2) {
//			request.setAttribute("url", url);
//			request.setAttribute("type", "商家");
//			request.getRequestDispatcher("//login.jsp").forward(req, rsp);
			response.sendRedirect("//localhost/user/login_redirect4shop.jsp?url=" + url);
		} else {
			try {
				chain.doFilter(req, rsp);
			} catch (Exception e) {
				if (e.getCause() instanceof MaxUploadSizeExceededException) {
					request.setAttribute("msg", ExceptionMap.maxUploadSizeExceededException);
					request.getRequestDispatcher("../msg.jsp?msg=").forward(
							req, rsp);
				}
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public BaseController getBaseController() {
		return baseController;
	}

	public void setBaseController(BaseController baseController) {
		this.baseController = baseController;
	}
	
	

}
