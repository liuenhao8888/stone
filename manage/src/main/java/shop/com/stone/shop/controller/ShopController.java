package com.stone.shop.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.shop.model.TShop;
import com.stone.shop.mapper.TShopMapper;

@Controller
public class ShopController extends BaseController{
	protected static final Logger log = Logger.getLogger(ShopController.class);
	
	@RequestMapping(value = "adm/shop/add")
	public String add4adm(HttpServletResponse rps, TShop shop) throws BusinessException, IOException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		sm.insert(shop);
		rps.sendRedirect("list.do");
		return null;
	}
	
	@RequestMapping(value = "register")
	public ModelAndView register(HttpServletResponse rps, TShop shop) throws BusinessException, IOException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		sm.insert(shop);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("msg");   
	    mav.addObject("msg", "注册成功");
	    return mav;
	}
	
	@RequestMapping(value = "adm/shop/list")
	public ModelAndView list(HttpServletRequest rqs, TShop shop) throws BusinessException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		List<TShop> list = sm.selectList();
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/shopList");   
	    mav.addObject("list", list);
	    log.info(list);
	    return mav;
	}
	
	@RequestMapping(value = "adm/shop/get4Edit")
	public ModelAndView get4Edit(HttpServletRequest rqs, int shopId) throws BusinessException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		TShop shop = sm.selectByPrimaryKey(shopId);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/shopEdit");  
	    mav.addObject("shop", shop);
	    return mav;
	}
	@RequestMapping(value = "adm/shop/get4Check")
	public ModelAndView get4Check(HttpServletRequest rqs, int shopId) throws BusinessException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		TShop shop = sm.selectByPrimaryKey(shopId);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/shopCheck");  
	    mav.addObject("shop", shop);
	    return mav;
	}
	
	@RequestMapping(value = "adm/shop/update")
	public String update(HttpServletResponse rps, TShop shop) throws BusinessException, IOException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		sm.updateByPrimaryKeySelective(shop);
		rps.sendRedirect("list.do");
		return null;
	}
	
	@RequestMapping(value = "adm/shop/del")
	public String delete(HttpServletResponse rps, TShop shop) throws BusinessException, IOException {
		TShopMapper sm = this.getMybatisBaseService().getMapper(TShopMapper.class);
		sm.deleteByPrimaryKey(shop.getShopId());
		rps.sendRedirect("list.do");
		return null;
	}
	
}
