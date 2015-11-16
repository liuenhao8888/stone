package com.stone.product.mapper;

import java.util.List;
import java.util.Map;

import com.stone.product.model.ProductExtend;
import com.stone.product.model.ProductExtendKey;

public interface ProductExtendMapper {
    int deleteByProductId(int goodsId);

    int insert(ProductExtend record);
    
    int insertList(List<ProductExtend> list);
    
    int updateList(List<ProductExtend> list);

    int insertSelective(ProductExtend record);

    ProductExtend selectByPrimaryKey(ProductExtendKey key);
    
    List<Map> selectByProductId(int goodsId);

    int updateByPrimaryKeySelective(ProductExtend record);

    int updateByPrimaryKey(ProductExtend record);
}