package com.stone.tuan.mapper;

import java.util.List;

import com.stone.tuan.model.TProductTuan;

public interface TProductTuanMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    int insert(TProductTuan record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    int insertSelective(TProductTuan record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    TProductTuan selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    int updateByPrimaryKeySelective(TProductTuan record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-04-23 08:39:15
     */
    int updateByPrimaryKey(TProductTuan record);
    
    
    
	List<TProductTuan> selectByShopId(Integer shopId);
	
	
	List<TProductTuan> select(TProductTuan record);
	
}