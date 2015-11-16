package com.stone.site.mapper;

import java.util.List;

import com.stone.site.model.TRegion;

public interface TRegionMapper {
	int deleteByPrimaryKey(long id);

	int insert(TRegion record);

	int insertSelective(TRegion record);

	TRegion selectByPrimaryKey(long id);
	
	Long selectMaxSubCode(TRegion record);
	
	List<TRegion> selectByRegion(TRegion region);

	List<TRegion> selectSublist(TRegion record);

	int updateByPrimaryKeySelective(TRegion record);

	int updateByPrimaryKey(TRegion record);
}