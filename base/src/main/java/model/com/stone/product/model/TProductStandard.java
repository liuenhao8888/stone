package com.stone.product.model;

import java.io.Serializable;

public class TProductStandard implements Serializable {
    /**
     * t_product_standard.id (规格记录id)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private Integer id;

    /**
     * t_product_standard.category_id (类别Id)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private Integer categoryId;

    /**
     * t_product_standard.product_id (商品Id)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private Integer productId;

    /**
     * t_product_standard.values (规格记录值   （按模板里面规格值顺序存储）)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private String values;

    /**
     * t_product_standard.price (商品指定规格的价格)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private Float price;

    /**
     * t_product_standard.stock (库存量)
     * @ibatorgenerated 2015-05-13 14:48:30
     */
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}