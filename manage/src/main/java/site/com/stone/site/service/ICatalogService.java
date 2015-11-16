package com.stone.site.service;


import org.springframework.stereotype.Service;

import com.stone.site.model.CatalogList;


@Service
public interface ICatalogService {

	CatalogList listCatalog();
	
	
	
}
