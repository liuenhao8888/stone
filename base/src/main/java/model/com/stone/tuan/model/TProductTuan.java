package com.stone.tuan.model;

import java.io.Serializable;

public class TProductTuan implements Serializable {
    /**
     * t_product_tuan.id
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer id;

    /**
     * t_product_tuan.product_id (商品id)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer productId;

    /**
     * t_product_tuan.title (团购标题)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private String title;

    /**
     * t_product_tuan.price (团购价格)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Float price;

    /**
     * t_product_tuan.discount (折扣 0-100直接的整数)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer discount;

    /**
     * t_product_tuan.start_time (开始时间)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private String startTime;

    /**
     * t_product_tuan.end_time (结束时间)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private String endTime;

    /**
     * t_product_tuan.sales_volume (已售数量)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer salesVolume;

    /**
     * t_product_tuan.shop_id (店铺id)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer shopId;

    /**
     * t_product_tuan.status (0:存库 1：上架  2：下架  3：下架)
     * @ibatorgenerated 2015-04-24 16:12:44
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
public static class StatusC{
    	
    	public static final int store = 0;
    	public static final int on = 1;
    	public static final int off = 2;
    	public static final int del = 3;
    }
}