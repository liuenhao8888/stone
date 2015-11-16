package com.stone.user.mapper;

import java.util.List;

import com.stone.user.model.TAdmin;

public interface TAdminMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    int insert(TAdmin record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    int insertSelective(TAdmin record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    TAdmin selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    int updateByPrimaryKeySelective(TAdmin record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    int updateByPrimaryKey(TAdmin record);
    
    TAdmin selectAdmin(TAdmin admin);
    
    List<TAdmin> selectList(TAdmin admin);
    
}