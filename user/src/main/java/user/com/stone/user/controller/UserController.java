package com.stone.user.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.base.exception.DaoException;
import com.stone.user.mapper.TUserMapper;
import com.stone.user.model.TUser;
import com.stone.user.service.IUserService;
import com.stone.util.VerifyCodeUtil;

@Controller
public class UserController extends BaseController {

	private static final Logger log = Logger.getLogger(UserController.class);

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request, TUser user) throws Exception {
		userService.register(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/registerOk");
		mav.addObject("user", user);
		return mav;
	}


	@RequestMapping(value = "/login_redirect4shiro")
	public ModelAndView login_redirect4shiro(HttpServletRequest request, HttpServletResponse response, TUser user,
			String submitCode) throws Exception {
		String msg = "验证码不正确";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		String username = user.getUsername();
		String verifyCode = (String) request.getSession().getAttribute("verifyCode");
		log.info("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
		if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {
			mav.addObject("msg", msg);
			return mav;
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username, user.getPassword());
		token.setRememberMe(true);
		log.info("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		Subject currentUser = SecurityUtils.getSubject();
		try {
			log.info("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			msg = "对用户[" + username + "]进行登录验证..验证未通过,未知账户";
		} catch (IncorrectCredentialsException ice) {
			msg = "对用户[" + username + "]进行登录验证..验证未通过,错误的凭证,密码不正确";
		} catch (LockedAccountException lae) {
			msg = "对用户[" + username + "]进行登录验证..验证未通过,账户已锁定";
		} catch (ExcessiveAttemptsException eae) {
			msg = "对用户[" + username + "]进行登录验证..验证未通过,错误次数过多";
		} catch (AuthenticationException ae) {
			msg = "对用户[" + username + "]进行登录验证..验证未通过,用户名或密码不正确";
			ae.printStackTrace();
		}
		if (currentUser.isAuthenticated()) {
			log.info("对用户[" + username + "]进行登录验证..验证通过");
			user = (TUser) currentUser.getPrincipal();
			this.setCurrentUser(user, request, response);
			//根据记录的url跳转
//			String url = "";
//			try {
//				url = WebUtils.getSavedRequest(request).getRequestUrl();
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new Exception(e);
//			}
			
//			if (url != null && !"".equals(url)) {
//				response.sendRedirect(url);
//				return null;
//			}
			if (user.isUser()) {
				mav.addObject("user", user);
				mav.setViewName("user/info");
			} else if (user.isShop()) {
				response.sendRedirect("/shop/shop/index.jsp");
				return null;
			}
		} else {
			token.clear();
		}
		mav.addObject("msg", msg);
		return mav;
	}

	@RequestMapping(value = "/use/logout")
	public String logout(HttpServletRequest request) throws BusinessException {
		// this.userLogout4redis(request);
		SecurityUtils.getSubject().logout();
		return "login";
	}

	@RequestMapping(value = "/use/user/update")
	public ModelAndView updateUser(HttpServletRequest request, TUser user) throws BusinessException {
		TUserMapper um = this.getMybatisBaseService().getMapper(TUserMapper.class);
		um.updateByPrimaryKey(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("use/msg");
		mav.addObject("msg", "chanage finished");
		return mav;
	}

	@RequestMapping(value = "/user/find")
	public ModelAndView findUser(HttpServletRequest request) throws BusinessException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/info");
		TUser user = this.getCurrentUser(request);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "adm/user/list")
	public ModelAndView list(TUser user) throws BusinessException {
		TUserMapper um = this.getMybatisBaseService().getMapper(TUserMapper.class);
		List<TUser> users = um.selectList(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/userList");
		mav.addObject("users", users);
		return mav;
	}

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@RequestMapping("/getVerifyCodeImage")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		// 将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE,
				Color.BLACK, null);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

}
