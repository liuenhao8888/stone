package com.stone.base.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.stone.base.dao.IMybatisBaseDao;
import com.stone.base.service.IMybatisBaseService;
import com.stone.base.system.SystemConstants.CacheKey;
import com.stone.security.model.TResource;
import com.stone.security.model.TRole;
import com.stone.user.mapper.TUserMapper;
import com.stone.user.model.TUser;

public class ShiroDataBaseRealm extends AuthorizingRealm{

	private RedisTemplate<String, TUser> redisTemplate;

	private IMybatisBaseDao ibatisBaseDao;

    /**
     * 
     * 当用户进行访问链接时的授权方法
     * 
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }
        List<String> roles = new ArrayList<String>();  
        List<String> permissions = new ArrayList<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        TUser user = (TUser) principals.fromRealm(getName()).iterator().next();
//        String currentUsername = (String)super.getAvailablePrincipal(principals); 
        TUser user = (TUser) principals.getPrimaryPrincipal();
        if(user != null){
            for (TRole role : user.getRoleList()) {
                roles.add(role.getName());
                for (TResource r : role.getResourcesList()) {
                    permissions.add(r.getUrl());
                }
            }
        }else{
            throw new AuthorizationException();
        }
        //给当前用户设置角色
        info.addRoles(roles);
        //给当前用户设置权限
        info.addStringPermissions(permissions); 


        return info;
    }

    /**
     * 用户登录的认证方法
     * 
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if (username == null) {
            throw new AccountException("用户名不能为空");
        }
        TUserMapper userMapper = this.ibatisBaseDao.getMapper(TUserMapper.class);
        TUser user = userMapper.selectUserRole(username);
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
//        return new SimpleAuthenticationInfo(user,user.getPassword().toString(),getName());
        return new SimpleAuthenticationInfo(user,new Md5Hash(user.getPassword()).toString(),getName());
    }
    
    
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession(); 
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  

	public RedisTemplate<String, TUser> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, TUser> redisTemplate) {
		this.redisTemplate = redisTemplate.getUserRedisTemplate();
	}

	public IMybatisBaseDao getIbatisBaseDao() {
		return ibatisBaseDao;
	}

	public void setIbatisBaseDao(IMybatisBaseDao ibatisBaseDao) {
		this.ibatisBaseDao = ibatisBaseDao;
	}

    
}