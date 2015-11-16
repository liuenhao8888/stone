package com.stone.category.controller;




import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.category.mapper.CmsCategoryMapper;
import com.stone.category.model.CmsCategory;

@Controller
public class CategoryController extends BaseController{
	protected static final Logger log = Logger.getLogger(CategoryController.class);
	
	
	@RequestMapping(value = "category/add")
	public String add(HttpServletResponse rps, CmsCategory ctg) throws BusinessException, IOException {
		
		CmsCategoryMapper cm = this.getMybatisBaseService().getMapper(CmsCategoryMapper.class);
		cm.insertSelective(ctg);
		if(ctg.getPid()==0)
			rps.sendRedirect("list.do?pid=0");
		else
			rps.sendRedirect("sublist.do?pid="+ctg.getPid());
		return null;
	}

	
}
