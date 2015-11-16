package com.stone.category.mapper;

import java.util.List;

import com.stone.category.model.CategoryTree;
import com.stone.category.model.TCategory;

public interface TCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCategory record);

    int insertSelective(TCategory record);

    TCategory selectByPrimaryKey(Integer id);
    
    List<TCategory> selectByPid(int pid);
    
    List<CategoryTree> selectSublist4Tree(int pid);
    
    List<TCategory> selectSublist(TCategory record);
    
    List<TCategory> selectSiblingById(int id);

    int updateByPrimaryKeySelective(TCategory record);

    int updateByPrimaryKey(TCategory record);
}