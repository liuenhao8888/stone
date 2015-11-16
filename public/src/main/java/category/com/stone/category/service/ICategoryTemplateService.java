package com.stone.category.service;


import com.stone.base.service.IMybatisBaseService;
import com.stone.category.model.TCategory;
import com.stone.category.model.TCategoryTemplate;

public interface ICategoryTemplateService extends IMybatisBaseService {
	
	public void del(TCategoryTemplate t)throws Exception;


	

}
