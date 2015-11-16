package com.stone.product.service;





import javax.servlet.http.HttpServletRequest;

import com.stone.base.service.IMybatisBaseService;
import com.stone.product.model.Product;

public interface IProductService extends IMybatisBaseService {
	
	public void addProduct(Product product, HttpServletRequest rqs)throws Exception;
	
	public void updateProduct(Product product, HttpServletRequest rqs)throws Exception;
	
	public Product getById(int id)throws Exception;
}
