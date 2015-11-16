package com.stone.category.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.category.mapper.TCategoryTemplateMapper;
import com.stone.category.model.TCategoryTemplate;
import com.stone.category.service.ICategoryTemplateService;

@Controller
public class TemplateController extends BaseController{
	protected static final Logger log = Logger.getLogger(TemplateController.class);
	
	@Resource(name = "categoryTemplateService")  
	private ICategoryTemplateService categoryTemplateService ; 
	
	@RequestMapping(value = "adm/template/add")
	public String add(HttpServletResponse rps, TCategoryTemplate template, String[] options) throws BusinessException, IOException {
		log.info("options:"+options);
		if(template.getFormat()<3) template.setOptions("");
		TCategoryTemplateMapper tm = this.getMybatisBaseService().getMapper(TCategoryTemplateMapper.class);
		tm.insert(template);
		rps.sendRedirect("list.do?categoryId="+template.getCategoryId());
		return null;
	}
	
	@RequestMapping(value = "adm/template/list")
	public ModelAndView list(HttpServletRequest rqs, TCategoryTemplate template) throws BusinessException {
		TCategoryTemplateMapper tm = this.getMybatisBaseService().getMapper(TCategoryTemplateMapper.class);
		List<TCategoryTemplate> list = tm.selectByCategoryId(template.getCategoryId());
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/templateList");   
	    mav.addObject("list", list);
	    mav.addObject("template", template);
	    log.info(template);
	    return mav;
	}
	
	@RequestMapping(value = "adm/template/get4Edit")
	public ModelAndView get4Edit(HttpServletRequest rqs, int id) throws BusinessException {
		TCategoryTemplateMapper tm = this.getMybatisBaseService().getMapper(TCategoryTemplateMapper.class);
		TCategoryTemplate t = tm.selectByPrimaryKey(id);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/templateEdit");  
	    mav.addObject("template", t);
	    log.info(t.getOptions());
	    return mav;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "template/getByCid")
	public @ResponseBody Map getByCid(HttpServletRequest rqs, int cid) throws BusinessException {
		TCategoryTemplateMapper tm = this.getMybatisBaseService().getMapper(TCategoryTemplateMapper.class);
		List<TCategoryTemplate> list = tm.selectByCategoryId(cid);
		int maxValueOrder = tm.selectMaxValueOderByCategoryId(cid);
		Map m = new HashMap();
		m.put("list", list);
		m.put("maxValueOrder", maxValueOrder);
	    return m;
	}
	
	@RequestMapping(value = "adm/template/update")
	public String update(HttpServletResponse rps, TCategoryTemplate template) throws BusinessException, IOException {
		TCategoryTemplateMapper tm = this.getMybatisBaseService().getMapper(TCategoryTemplateMapper.class);
		tm.updateByPrimaryKey(template);
		rps.sendRedirect("list.do?categoryId="+template.getCategoryId());
		return null;
	}
	
	@RequestMapping(value = "adm/template/del")
	public String delete(HttpServletResponse rps, TCategoryTemplate template) throws Exception{
		this.categoryTemplateService.del(template);
		rps.sendRedirect("list.do?categoryId="+template.getCategoryId());
		return null;
	}
	
}
