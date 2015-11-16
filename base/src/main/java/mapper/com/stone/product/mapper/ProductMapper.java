package com.stone.product.mapper;

import java.util.List;

import com.stone.product.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByProductId(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);
    
    List<Product> selectByProduct(Product product);
    
	List<Product> selectByCategoryID(Integer cid);
	
	List<Product> selectByShopID(Integer shopId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}