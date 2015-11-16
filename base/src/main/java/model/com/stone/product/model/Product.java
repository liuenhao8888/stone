package com.stone.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  /**
     * t_product.id
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Integer id;

    /**
     * t_product.shop_id
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Integer shopId;

    /**
     * t_product.t_c_id (商品类别)
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Integer cid;

    /**
     * t_product.title
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private String title;

    /**
     * t_product.price
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Float price;

    /**
     * t_product.imgs (商品图片 英文分号 ; 分割   )
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private String imgs;

    /**
     * t_product.time
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Date time;

    /**
     * t_product.status (1：上架 2：下架)
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Integer status;

    /**
     * t_product.type (0：普通 1：团购  2：抢购)
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private Integer type;

    /**
     * t_product.introduction (商品介绍)
     * @ibatorgenerated 2015-05-29 09:07:39
     */
    private String introduction;
    
    
    
    private List<TProductStandard> stdList = new ArrayList<TProductStandard> ();
    
    private List<ProductExtend> extList = new ArrayList<ProductExtend> ();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

	public List<TProductStandard> getStdList() {
		return stdList;
	}

	public void setStdList(List<TProductStandard> stdList) {
		this.stdList = stdList;
	}

	public List<ProductExtend> getExtList() {
		return extList;
	}

	public void setExtList(List<ProductExtend> extList) {
		this.extList = extList;
	}


}