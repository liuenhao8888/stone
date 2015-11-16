package com.stone.order.mapper;

import java.util.List;

import com.stone.order.model.TOrder;

public interface TOrderMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    int deleteByPrimaryKey(long orderId);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    int insert(TOrder record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    int insertSelective(TOrder record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    TOrder selectByPrimaryKey(long orderId);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    int updateByPrimaryKeySelective(TOrder record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    int updateByPrimaryKey(TOrder record);
    
    int updateStatusById(TOrder record);
    
    List<TOrder> selectList(TOrder record);
}