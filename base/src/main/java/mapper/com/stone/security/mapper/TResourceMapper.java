package com.stone.security.mapper;

import java.util.List;

import com.stone.security.model.TResource;

public interface TResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TResource record);

    int insertSelective(TResource record);

    TResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
    
    List<TResource> getAll();
}