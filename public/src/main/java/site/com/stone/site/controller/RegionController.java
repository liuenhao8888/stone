package com.stone.site.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.site.mapper.TRegionMapper;
import com.stone.site.model.TRegion;

@Controller
public class RegionController extends BaseController{
	
	@RequestMapping(value = "adm/region/getPrecode")
	public ModelAndView getPrecode(HttpServletResponse rps, TRegion region) throws BusinessException, IOException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		region.setParentid(region.getId());
		Long id = rm.selectMaxSubCode(region);
		if(id==null){
			region.setId(region.generateNewSubCode());
		}else{
			region.setId(id);
			region.setId(region.generateNewSiblingCode());
		}
		region.setGrade(region.getGrade()+1);
		region.setIsleaf(region.getGrade()==4?1:0);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/regionAdd");   
	    mav.addObject("region", region);
	    return mav;
	}
	
	@RequestMapping(value = "adm/region/add")
	public String add(HttpServletResponse rps, TRegion region) throws BusinessException, IOException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		rm.insert(region);
		if(region.getGrade()==1){
			return "redirect:list.do?grade=0&id=0";
		}else{
			return "redirect:sublist.do?grade="+(region.getGrade()-1)+"&id="+region.generateParentCode();
		}
	}
	
	@RequestMapping(value = "adm/region/list")
	public ModelAndView list(HttpServletRequest rqs, TRegion region) throws BusinessException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		List<TRegion> list = rm.selectSublist(region);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/regionList");   
	    mav.addObject("list", list);
	    mav.addObject("region", region);
	    return mav;
	}
	
	@RequestMapping(value = "adm/region/sublist")
	public ModelAndView sublist(HttpServletRequest rqs, TRegion region) throws BusinessException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		List<TRegion> list = rm.selectSublist(region);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/regionList");   
	    mav.addObject("list", list);
	    mav.addObject("region", region);
	    return mav;
	}
	
	@RequestMapping(value = "adm/region/get4Edit")
	public ModelAndView get4Edit(HttpServletRequest rqs, long id) throws BusinessException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		TRegion region = rm.selectByPrimaryKey(id);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("/admin/regionEdit");   
	    mav.addObject("region", region);
	    return mav;
	}
	@RequestMapping(value = "adm/region/update")
	public String update(HttpServletResponse rps, TRegion region) throws BusinessException, IOException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		rm.updateByPrimaryKey(region);
		if(region.getGrade()==1)
			rps.sendRedirect("list.do?grade=0&id=0");
		else
			rps.sendRedirect("sublist.do?grade="+(region.getGrade()-1)+"&id="+region.generateParentCode());
		return null;
	}
	
	@RequestMapping(value = "adm/region/del")
	public String delete(HttpServletResponse rps, TRegion region) throws BusinessException, IOException {
		TRegionMapper rm = this.getMybatisBaseService().getMapper(TRegionMapper.class);
		rm.deleteByPrimaryKey(region.getId());
		if(region.getGrade()==1)
			return "redirect:list.do?grade=0&id=0";
		else
			return "redirect:sublist.do?grade="+(region.getGrade()-1)+"&id="+region.generateParentCode();
	}
	
}
