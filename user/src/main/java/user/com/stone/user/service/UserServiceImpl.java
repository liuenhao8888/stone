package com.stone.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stone.base.exception.BusinessException;
import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.security.mapper.TUserRoleMapper;
import com.stone.security.model.TUserRoleKey;
import com.stone.user.mapper.TUserMapper;
import com.stone.user.model.TUser;

@Service("userServiceImpl")
public class UserServiceImpl extends MybatisBaseServiceImpl implements IUserService {

	// 两种例外
	// 1.unchecked 默认回滚事务(RuntimeException)
	// 2.checked 默认不回滚事务(Exception)
	// 开启事务.并设置unchecked例外不回滚
	// @Transactional(propagation = Propagation.REQUIRED, noRollbackFor =
	// RuntimeException.class)
	@Transactional(propagation = Propagation.REQUIRED)
	public void register(TUser user) throws Exception {
		try {
			TUserMapper um = this.getMapper(TUserMapper.class);
			um.insert(user);
			
			TUserRoleKey ur = new TUserRoleKey();
			ur.setUserId(user.getUserId());
			int roleId = TUser.getRoleByType(user.getType());
			ur.setRoleId(roleId);
			TUserRoleMapper urm = this.getMapper(TUserRoleMapper.class);
			urm.insert(ur);
			
		} catch (Exception e) {
			throw new BusinessException("此异常是runtime，默认回滚事务");
		}
	}

}
