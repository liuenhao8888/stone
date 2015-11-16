package com.stone.shop.mapper;

import java.util.List;

import com.stone.shop.model.TShop;

public interface TShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(TShop record);

    int insertSelective(TShop record);

    TShop selectByPrimaryKey(Integer shopId);
    
    List<TShop> selectList();

    int updateByPrimaryKeySelective(TShop record);

    int updateByPrimaryKey(TShop record);
}