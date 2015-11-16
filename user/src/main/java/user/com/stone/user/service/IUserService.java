package com.stone.user.service;

import com.stone.base.exception.BusinessException;
import com.stone.base.service.IMybatisBaseService;
import com.stone.user.model.TUser;

public interface IUserService extends IMybatisBaseService {
	
	public void register(TUser user) throws Exception;
	

}
