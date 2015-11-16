/** 支付方式 * */
var payWayMap = {
	1 : "在线支付",
	2 : "货到付款",
	3 : "银行转账"
};

/** 支付类型 * */
var payTypeMap = {
	1 : "银联",
	2 : "支付宝",
	3 : "微信"
};

/** 支付状态 * */
var payStatusMap = {
	0 : "未支付",
	1 : "已支付"
};

/** 发票类型 * */
var billTypeMap = {
	1 : "办公",
	2 : "食品",
	3 : "手机",
	4 : "电器"
};

/** 订单状态 * */
var statusMap = {
	1 : "待确认",
	2 : "代发货",
	3 : "已发货",
	4 : "已完成",
	5 : "已取消",
	6 : "异常"
};

jQuery.fn.extend({
	initializePayWay : function() {
		for ( var k in payWayMap) {
			$(this).append(
					'<input name="payWay" type="radio" value="' + k + '" />'
							+ payWayMap[k]);
		}
	},
	initializePayType : function() {
		for ( var k in payTypeMap) {
			$(this).append(
					'<input name="payType" type="radio" value="' + k + '" />'
							+ payTypeMap[k]);
		}
	},
	initializeBillType : function() {
		for ( var k in billTypeMap) {
			$(this).append(
					'<input name="billType" type="radio" value="' + k + '" />'
							+ billTypeMap[k]);
		}
	},
	setPayWay : function(k) {
		$(this).html(payWayMap[k]);
	},
	setPayType : function(k) {
		$(this).html(payTypeMap[k]);
	},
	setBillType : function(k) {
		$(this).html(billTypeMap[k]);
	},
	getStatus : function(k) {
		return statusMap[k];
	},
	getPayWay : function(k) {
		return payWayMap[k];
	},
	getPayStatus : function(k) {
		return payStatusMap[k];
	}

});