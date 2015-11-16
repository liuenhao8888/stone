package com.stone.tuan.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.tuan.mapper.TProductTuanMapper;
import com.stone.tuan.model.TProductTuan;

@Controller
public class ProductTuanController extends BaseController {

	protected static final Logger log = Logger.getLogger(ProductTuanController.class);

	
	@RequestMapping(value = "/sho/tuan_add")
	public String add(HttpServletResponse rps, HttpServletRequest rqs,TProductTuan item) throws Exception {
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		item.setShopId(this.getShopId(rqs));
		mapper.insert(item);
		rps.sendRedirect("tuan_list.do");
		return null;
	}
	
	@RequestMapping(value = "/sho/tuan_list")
	public ModelAndView list(HttpServletResponse rps, HttpServletRequest rqs) throws Exception {
		ModelAndView mav = new ModelAndView();
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		List<TProductTuan> list = mapper.selectByShopId(this.getShopId(rqs));
		mav.setViewName("/shop/tuan_list");  
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/sho/tuan_del_list")
	public ModelAndView list_del(HttpServletResponse rps, HttpServletRequest rqs) throws Exception {
		ModelAndView mav = new ModelAndView();
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		TProductTuan item = new TProductTuan();
		item.setShopId(this.getShopId(rqs));
		item.setStatus(TProductTuan.StatusC.del);
		List<TProductTuan> list = mapper.select(item);
		mav.setViewName("/shop/tuan_del_list");  
		mav.addObject("list", list);
		return mav;
	}
	
	
	@RequestMapping(value = "/sho/tuan_list_ajax")
	public @ResponseBody List<TProductTuan> list_ajax(HttpServletResponse rps, HttpServletRequest rqs) throws Exception {
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		int shopId = this.getShopId(rqs);
		List<TProductTuan> list = mapper.selectByShopId(shopId);
		return list;
	}
	
	@RequestMapping(value = "/sho/tuan_4_edit")
	public ModelAndView toEdit(HttpServletResponse rps, HttpServletRequest rqs,TProductTuan item) throws Exception{
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		item = mapper.selectByPrimaryKey(item.getId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shop/tuan_edit");  
		mav.addObject("tuan", item);
		return mav;
	}
	
	@RequestMapping(value = "/sho/tuan_edit")
	public ModelAndView edit(HttpServletResponse rps, HttpServletRequest rqs,TProductTuan item) throws Exception{
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
		mapper.updateByPrimaryKeySelective(item);
		rps.sendRedirect("tuan_list.do");
		return null;
	}
	
	@RequestMapping(value = "/sho/tuan_del")
	public ModelAndView del(HttpServletResponse rps, HttpServletRequest rqs,TProductTuan item) throws Exception{
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(TProductTuanMapper.class);
//		mapper.deleteByPrimaryKey(item.getId());
		item.setStatus(TProductTuan.StatusC.del);
		mapper.updateByPrimaryKeySelective(item);
		rps.sendRedirect("tuan_list.do");
		return null;
	}
	


}
