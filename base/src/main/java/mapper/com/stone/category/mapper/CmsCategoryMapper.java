package com.stone.category.mapper;

import com.stone.category.model.CmsCategory;

public interface CmsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsCategory record);

    int insertSelective(CmsCategory record);

    CmsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsCategory record);

    int updateByPrimaryKey(CmsCategory record);
}