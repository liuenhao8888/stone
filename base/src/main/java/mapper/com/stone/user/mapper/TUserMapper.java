package com.stone.user.mapper;

import java.util.List;

import com.stone.user.model.TUser;

public interface TUserMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    int insert(TUser record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    int insertSelective(TUser record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    TUser selectByPrimaryKey(Integer userId);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    int updateByPrimaryKeySelective(TUser record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-03-19 13:29:48
     */
    int updateByPrimaryKey(TUser record);
    
    List<TUser> selectList(TUser user);
    
    TUser selectUser(TUser user);
    
    TUser select4login(TUser user);
    
    TUser getUserByUsername(String username);
    
    TUser selectUserRole(String username);
    
}