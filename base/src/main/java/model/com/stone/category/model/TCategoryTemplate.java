package com.stone.category.model;

import java.io.Serializable;

public class TCategoryTemplate implements Serializable {
    /**
     * t_category_template.id
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer id;

    /**
     * t_category_template.category_id
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer categoryId;

    /**
     * t_category_template.name
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private String name;

    /**
     * t_category_template.status (1：正常 2：停用)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer status;

    /**
     * t_category_template.order (属性显示位次)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer order;
    
    /**
     * t_category_template.value_order (值存储顺序 此字段只有type=2即规格属性时才有效)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer valueOrder;


    /**
     * t_category_template.format (1：text 2：area 3：radio 4：checkbox 5：select)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer format;

    /**
     * t_category_template.options (项分隔符：$&@  选中项：^ 开通  例性别： ^男$&@女  表示两个选择项 男  女，默认选择男)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private String options;

    /**
     * t_category_template.type (1：普通属性  2：规格属性)
     * @ibatorgenerated 2015-04-27 09:08:19
     */
    private Integer type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public Integer getValueOrder() {
		return valueOrder;
	}

	public void setValueOrder(Integer valueOrder) {
		this.valueOrder = valueOrder;
	}
    
    
}