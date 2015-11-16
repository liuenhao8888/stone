package com.stone.user.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.ExceptionMap;
import com.stone.user.model.TUser;

/**
 * 会员
 * 
 * @author ce
 *
 */
public class UserFilter implements Filter {

	protected static final Logger log = Logger.getLogger(UserFilter.class);


	
	private BaseController baseController;
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		String url = request.getRequestURI() ;
//		String url = request.getRequestURI() + "?" + request.getQueryString();
		// TUser u = (TUser) request.getSession().getAttribute(
		// SystemConstants.SESSION_USER);
		TUser u = (TUser) baseController.getCurrentUser4redis(request);
		if (u == null || u.getType() != 1) {
			// request.setAttribute("url", url);
			// request.setAttribute("type", "会员");
			// request.getRequestDispatcher("//login.jsp").forward(req, rsp);
			response.sendRedirect("//localhost/user/login_redirect.jsp?url=" + url);
		} else {
			try {
				chain.doFilter(req, rsp);
			} catch (Exception e) {
				if (e.getCause() instanceof MaxUploadSizeExceededException) {
					request.setAttribute("msg", ExceptionMap.maxUploadSizeExceededException);
					request.getRequestDispatcher("../msg.jsp?msg=").forward(req, rsp);
				}
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}
	}

	public void init(FilterConfig fc) throws ServletException {


	}

	public BaseController getBaseController() {
		return baseController;
	}

	public void setBaseController(BaseController baseController) {
		this.baseController = baseController;
	}

	

}
