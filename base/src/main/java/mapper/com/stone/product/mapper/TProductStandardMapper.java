package com.stone.product.mapper;

import java.util.List;
import java.util.Map;

import com.stone.category.model.TCategoryTemplate;
import com.stone.product.model.Product;
import com.stone.product.model.ProductExtend;
import com.stone.product.model.TProductStandard;

public interface TProductStandardMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    int insert(TProductStandard record);
    
    /**
     * 批量插入商品规格信息
     * @param list
     * @return
     */
    int insertList(List<TProductStandard> list);
    
    /**
     * 批量插入带有id的商品规格信息
     * @param list
     * @return
     */
    int insertListWithId(List<TProductStandard> list);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    int insertSelective(TProductStandard record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    TProductStandard selectByPrimaryKey(Integer id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    int updateByPrimaryKeySelective(TProductStandard record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    int updateByPrimaryKey(TProductStandard record);
    
    void updateList(List<TProductStandard> stdList);
    
    int updateStandardValues(TCategoryTemplate record);
    
    int deleteByProductId(int productId);
    
    List<Map> selectByProductId(int id);
    
    List<Map> callTemplateAndStandard(Product record);
}