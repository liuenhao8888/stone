package com.stone.category.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stone.base.exception.BusinessException;
import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.category.mapper.TCategoryTemplateMapper;
import com.stone.category.model.TCategoryTemplate;
import com.stone.product.mapper.TProductStandardMapper;
@Service("categoryTemplateService")
public class CategoryTemplateServiceImpl extends MybatisBaseServiceImpl implements ICategoryTemplateService {
	
	
	// 两种例外  
    // 1.unchecked 默认回滚事务(RuntimeException)  
    // 2.checked 默认不回滚事务(Exception)  
    // 开启事务.并设置unchecked例外不回滚  
//	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = RuntimeException.class)  
	@Transactional(propagation = Propagation.REQUIRED)  
	@Override
	public void del(TCategoryTemplate t) throws Exception {

		//删除模板属性
		TCategoryTemplateMapper tm = this.getMapper(TCategoryTemplateMapper.class);
		tm.deleteByPrimaryKey(t.getId());
		
		if(t.getType()!=2)return;
		
		//若是规格属性，对规格值存储顺序重新排序
		tm.updateValueOrderById(t);
		
		
		//若是规格属性，删除规格值里面的对应项
		TProductStandardMapper psm = this.getMapper(TProductStandardMapper.class);
		psm.updateStandardValues(t);
		
		
//		throw new Exception("此异常不回滚事务");  
//		throw new BusinessException("此异常是runtime，默认回滚事务");  
//		throw new Error("error，回滚事务");  
		
	}
	
	

}
