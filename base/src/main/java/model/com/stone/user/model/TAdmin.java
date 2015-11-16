package com.stone.user.model;

import java.io.Serializable;

public class TAdmin implements Serializable {
    /**
     * t_admin.id
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private Integer id;

    /**
     * t_admin.t_s_id
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private Integer tSId;

    /**
     * t_admin.username
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private String username;

    /**
     * t_admin.password
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private String password;

    /**
     * t_admin.linkman
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private String linkman;

    /**
     * t_admin.phone
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private String phone;

    /**
     * t_admin.address
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private String address;

    /**
     * t_admin.status
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private Integer status;

    /**
     * t_admin.type (1：平台 2：分站 )
     * @ibatorgenerated 2015-03-19 13:35:07
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer gettSId() {
        return tSId;
    }

    public void settSId(Integer tSId) {
        this.tSId = tSId;
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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}