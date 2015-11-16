package com.stone.order.model;

import java.io.Serializable;
import java.util.List;

import com.stone.product.model.Product;

public class TOrder implements Serializable {
    /**
     * t_order.order_id
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private long orderId;
    
    private String number;

    /**
     * t_order.user_id (会员id)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer userId;

    /**
     * t_order.time (下单时间)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String time;
    
    
    /**
     * t_order.last_time (最后操作时间)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String lastTime;

    /**
     * t_order.status (1:待确认 2：代发货 3：已发货 4：已完成 5：已取消 6：异常)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer status;

    /**
     * t_order.linkman (收件人)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String linkman;

    /**
     * t_order.phone (收件人电话)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String phone;

    /**
     * t_order.address (收件人地址)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String address;

    /**
     * t_order.pay_way (1：在线支付  2：货到付款 3：银行转账)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer payWay;
    
    /**
     * t_order.pay_status (0：未支付  1：已支付)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer payStatus;

    
    /**
     * t_order.pay_type (1:银联 2：支付宝  3：微信)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer payType;

    /**
     * t_order.total (订单总价)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Float total;

    /**
     * t_order.remark (备注)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String remark;

    /**
     * t_order.bill_title (发票抬头)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String billTitle;

    /**
     * t_order.bill_type (1: 明细  2：办公 3：食品 4：手机 5：电器)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer billType;

    /**
     * t_order.express_id (快递号)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String expressId;

    /**
     * t_order.express_man (快递员)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String expressMan;

    /**
     * t_order.express_type (1:顺风 2：中通 3：申通 4：百世汇通)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private Integer expressType;

    /**
     * t_order.express_phone (快递电话)
     * @ibatorgenerated 2015-03-18 17:34:12
     */
    private String expressPhone;
    
    
    private float needPay;
    
    private List OrderItems;
    

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public String getExpressMan() {
        return expressMan;
    }

    public void setExpressMan(String expressMan) {
        this.expressMan = expressMan;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public String getExpressPhone() {
        return expressPhone;
    }

    public void setExpressPhone(String expressPhone) {
        this.expressPhone = expressPhone;
    }
    
    
    public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}


	public Integer getPayWay() {
		return payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}


	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public List<Product> getOrderItems() {
		return OrderItems;
	}

	public void setOrderItems(List orderItems) {
		OrderItems = orderItems;
	}


	public Float getNeedPay() {
		return needPay;
	}

	public void setNeedPay(float needPay) {
		this.needPay = needPay;
	}


	public static class StatusC{
    	
    	public static final int preconfirm = 1;
    	public static final int presend = 2;
    	public static final int sent = 3;
    	public static final int finish = 4;
    	public static final int cancelled = 5;
    	public static final int exception = 6;
    }
}