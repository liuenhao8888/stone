package com.stone.category.mapper;

import java.util.List;

import com.stone.category.model.TCategoryTemplate;

public interface TCategoryTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCategoryTemplate record);

    int insertSelective(TCategoryTemplate record);

    TCategoryTemplate selectByPrimaryKey(Integer id);

    List<TCategoryTemplate> selectByCategoryId(Integer categoryId);
    
    Integer selectMaxValueOderByCategoryId(Integer categoryId);
    
    int updateByPrimaryKeySelective(TCategoryTemplate record);

    int updateByPrimaryKey(TCategoryTemplate record);
    
    int updateValueOrderById(TCategoryTemplate record);
    
}