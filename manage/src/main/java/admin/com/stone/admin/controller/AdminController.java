package com.stone.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.base.exception.DaoException;
import com.stone.user.mapper.TAdminMapper;
import com.stone.user.mapper.TUserMapper;
import com.stone.user.model.TAdmin;

@Controller
public class AdminController extends BaseController {

	@RequestMapping(value = "/adm/add")
	public String add(HttpServletRequest request, TAdmin admin) throws DaoException {
		TAdminMapper am = this.getMybatisBaseService().getMapper(TAdminMapper.class);
		am.insert(admin);
		return "admin/index";
	}

	@RequestMapping(value = "/adm/delete/{id}")
	public String delete(HttpServletResponse rsp, @PathVariable int id) throws IOException {
		TAdminMapper am = this.getMybatisBaseService().getMapper(TAdminMapper.class);
		am.deleteByPrimaryKey(id);
		rsp.sendRedirect("../list.do");
		return null;
	}

	@RequestMapping(value = "admLogin")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, TAdmin admin)
			throws BusinessException, IOException, ServletException {
		TAdminMapper am = this.getMybatisBaseService().getMapper(TAdminMapper.class);
		TAdmin a = am.selectAdmin(admin);
		ModelAndView mav = new ModelAndView();
		if (a != null) {
			admin = a;
			this.setCurrentAdmin(request, admin);
			mav.addObject("admin", admin);
			mav.setViewName("admin/index");
		} else {
			mav.setViewName("login");
			mav.addObject("msg", "找不到账号为" + admin.getUsername() + ", 密码为" + admin.getPassword() + "的管理员");
		}
		return mav;
	}

	@RequestMapping(value = "/adm/logout")
	public String logout(HttpServletRequest request) throws BusinessException {
		this.adminLogout(request);
		return "index";
	}

	@RequestMapping(value = "adm/list")
	public ModelAndView list() throws BusinessException {
		TAdminMapper am = this.getMybatisBaseService().getMapper(TAdminMapper.class);
		List admins = am.selectList(null);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminList");
		mav.addObject("admins", admins);
		return mav;
	}

}
