package com.stone.base.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class MyRolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		Subject subject = getSubject(arg0, arg1);
		String[] rolesArray = (String[]) arg2;

		if (rolesArray == null || rolesArray.length == 0) { // 没有角色限制，有权限访问
			return true;
		}
		
		// 所有权限
//		Set<String> roles = CollectionUtils.asSet(rolesArray);
//		return subject.hasAllRoles(roles);
		
		
		// 满足一项即可
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) { // 若当前用户是rolesArray中的任何一个，则有权限访问
				return true;
			}
		}
		return false;

	}

}
