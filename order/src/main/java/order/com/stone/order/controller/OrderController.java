package com.stone.order.controller;


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
import com.stone.order.mapper.TOrderMapper;
import com.stone.order.model.TOrder;


@Controller
public class OrderController extends BaseController{
	
	
	@RequestMapping(value = "use/order/preadd")
	public ModelAndView preadd(HttpServletResponse rps, TOrder order) throws BusinessException, IOException {
		order.setOrderId(System.currentTimeMillis());
		ModelAndView mav = new ModelAndView();
	    mav.addObject("order", order);
	    mav.setViewName("user/orderConfirm");   
	    return mav;
	}
	
	@RequestMapping(value = "use/order/add")
	public String add(HttpServletRequest rqs, HttpServletResponse rps, TOrder order) throws BusinessException, IOException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		order.setOrderId(System.currentTimeMillis());
		order.setUserId(this.getCurrentUserId(rqs));
		om.insert(order);
	    rqs.getSession().setAttribute("order", order);
	    rps.sendRedirect("../../user/orderConfirm.jsp");
	    return null;
	}
	
	@RequestMapping(value = "use/order/list")
	public ModelAndView list(HttpServletRequest rqs, TOrder order) throws BusinessException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		order.setUserId(this.getCurrentUserId(rqs));
		List<TOrder> list = om.selectList(order);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/user/orderList");   
	    mav.addObject("list", list);
	    log.info(list);
	    return mav;
	}
	
	@RequestMapping(value = "adm/order/list")
	public ModelAndView list4Adm(HttpServletRequest rqs, TOrder order) throws BusinessException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		List<TOrder> list = om.selectList(order);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/user/orderList");   
	    mav.addObject("list", list);
	    log.info(list);
	    return mav;
	}
	
	@RequestMapping(value = "use/order/{id}")
	public ModelAndView add(HttpServletResponse rps, @PathVariable long id) throws BusinessException, IOException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		TOrder order = om.selectByPrimaryKey(id);
		ModelAndView mav = new ModelAndView();
	    mav.addObject("order", order);
	    mav.setViewName("user/order");   
	    return mav;
	}
	
	@RequestMapping(value = "use/order/cancel")
	public void cancel(HttpServletResponse rps, TOrder order) throws BusinessException, IOException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		order.setStatus(TOrder.StatusC.cancelled);;
		om.updateStatusById(order);
		rps.sendRedirect("list.do");
	}
	
	@RequestMapping(value = "use/order/finish")
	public void finish(HttpServletResponse rps, TOrder order) throws BusinessException, IOException {
		TOrderMapper om = this.getMybatisBaseService().getMapper(TOrderMapper.class);
		order.setStatus(TOrder.StatusC.finish);;
		om.updateByPrimaryKeySelective(order);
		rps.sendRedirect("list.do");
	}
	
	
}
