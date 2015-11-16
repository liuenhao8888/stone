package com.stone.user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stone.security.model.TResource;
import com.stone.security.model.TRole;

public class TUser implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7088124090233490669L;
	
	/**
     * t_user.user_id
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private Integer userId;

    /**
     * t_user.username
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String username;

    /**
     * t_user.password
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String password;

    /**
     * t_user.realname
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String realname;

    /**
     * t_user.phone
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String phone;

    /**
     * t_user.email
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String email;

    /**
     * t_user.address
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private String address;

    /**
     * t_user.status (1：正常 2：关闭)
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private Integer status;

    /**
     * t_user.type (1： 会员   2：店铺管理员)
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private Integer type;

    /**
     * t_user.time
     * @ibatorgenerated 2015-03-19 13:29:47
     */
    private Date time;
    
    
    private int shopId;
    
    
    private List<TRole> roleList = new ArrayList<TRole>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public List<TRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TRole> roleList) {
		this.roleList = roleList;
	}

    public static int getRoleByType(int type){
    	if(type==1){
    		return 1;
    	}else if(type==2){
    		return 2;
    	}
    	return 0;
    }
    
    public boolean isUser(){
    	return this.type==Type.USER;
    }
    public boolean isShop(){
    	return this.type==Type.SHOP;
    }
    public boolean isAdmin(){
    	return this.type==Type.ADMIN;
    }
    
    class Type {
    	private static final int USER = 1;
    	private static final int SHOP = 2;
    	private static final int ADMIN = 3;
    }
}