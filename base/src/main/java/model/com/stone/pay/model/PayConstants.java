package com.stone.pay.model;

public abstract class PayConstants {
	//支付宝标准双接口
		public static final String PAYMETHOD_ZFBSJK = "001";
		
		//支付宝即时到账
		public static final String PAYMETHOD_ZFBJSDZ = "002";
		
		//支付宝担保交易
		public static final String PAYMETHOD_ZFBDBJY = "003";
		
		//财付通中介担保交易
		public static final String PAYMETHOD_CFTZJDB = "004";
		
		//财付通即时到账交易
		public static final String PAYMETHOD_CFTJSDZ = "005";
		
		//网付通
		public static final String PAYMETHOD_WFT = "006";
		
		//快钱
		public static final String PAYMETHOD_KUAIQIAN = "007";
		
		//易宝支付
		public static final String PAYMETHOD_YIBAO = "008";
		
		//银联电子支付ChinaPay
		public static final String PAYMETHOD_YINLIAN = "009";
		
		//首信易支付
		public static final String PAYMETHOD_SXY = "010";
		
		//中国移动网上支付
		public static final String PAYMETHOD_ZGYD = "011";
		
		//货到付款
		public static final String PAYMETHOD_HDFK = "012";
		
		//银联在线支付OnlinePay
		public static final String PAYMETHOD_ONLINE = "013";
		
		//财付通双接口(兼容新中介担保)
		public static final String PAYMETHOD_CFTSJK = "014";
		
		//支付宝手机支付
		public static final String PAYMETHOD_ZFBMOBILE = "015";
		
		//银联支付UnionPay
		public static final String PAYMETHOD_UNIONPAY = "016";
		
		
		//在线支付
		public static final String PAYTYPE_ZXZF = "1";
		
		//银行转账
		public static final String PAYTYPE_YHZZ = "2";
		
		//邮局汇款
		public static final String PAYTYPE_YJHK = "3";
		
		//货到付款
		public static final String PAYTYPE_HDFK = "4";
		
		//我的付款
		public static final String PAYTYPE_WDFK = "0000000000";
		
		//在线支付
		public static final String PAYTYPE_ZXZF_NAME = "在线支付";
		
		//银行转账
		public static final String PAYTYPE_YHZZ_NAME = "银行转账";
		
		//邮局汇款
		public static final String PAYTYPE_YJHK_NAME = "邮局汇款";
		
		//货到付款
		public static final String PAYTYPE_HDFK_NAME = "货到付款";
		
		//预置支付方式配置文件名称
		public static final String PAYTYPE_CONFIG_FILENAME = "payTypeConfig.xml";
		
		//移动提供接口配置文件名称
		public static final String ZGYD_CONFIG_FILENAME = "merchantprofile.xml";
		
		//是否启用-是
		public static final int ISUSE_YES = 0;
		
		//是否启用-否
		public static final int ISUSE_NO = 1;
		
		//是否预置-是
		public static final int ISDEFINED_YES = 0;
		
		//是否预置-否
		public static final int ISDEFINED_NO = 1;
		
		//是否支付_是
		public static final String ORDER_STATUS_YES = "2";
		
		//待分配
		public static final String ORDER_STATUS_DFP = "5";
		
		//是否支付_否
		public static final String ORDER_STATUS_NO = "1";
		
		//默认图片路径
		public static final String YHZZ_DEFAULT_IMG = "/images/pay/logo_new.png";
		
		//银联电子支付ChinaPay--商户密钥 MerPrk
		public static final String CHINAPAY_MERPRK = "MerPrk.key";
		
		//银联电子支付ChinaPay--网关公钥 PgPubk
		public static final String CHINAPAY_PGPUBK = "PgPubk.key";
		
		//银联电子支付ChinaPay路径
		public static final String CHINAPAY_CHINAPAY = "ChinaPay/";
		
		//银联在线支付OnlinePay路径
		public static final String CHINAPAY_ONLINEPAY = "OnlinePay/";
		
		
		/**
	     * 支付宝提供给商户的服务接入网关URL(新)--在线发货
	     */
		public static final String ALIPAY_GATEWAY_NEW   = "https://mapi.alipay.com/gateway.do?";
		
		/**
		 * 支付宝即时到帐批量退款网关
		 */
		public static final String ALIPAY_REFUND_URL   = "https://www.alipay.com/cooperate/gateway.do?";
		
		/**
		 * 在线退款的说明
		 */
		public static final String REFUND_DESCRIPTION = "协商退款";
		
		/**
		 * 银联电子支付在线退款网关地址
		 */
		public static final String ChINAPAY_REFUND_URL = "https://bak.chinapay.com/refund/SingleRefund.jsp";
		
		/**
		 * 银联在线支付在线退款网关地址
		 */
		public static final String UPOP_REFUND_URL = "https://unionpaysecure.com/api/BSPay.action";
		
		/**
		 * 银联在线支付在线退款 组装消费请求包
		 */
		public static final String[] reqVo = new String[]{
			"version",
	        "charset",
	        "transType",
	        "origQid",
	        "merId",
	        "merAbbr",
	        "acqCode",
	        "merCode",
	        "commodityUrl",
	        "commodityName",
	        "commodityUnitPrice",
	        "commodityQuantity",
	        "commodityDiscount",
	        "transferFee",
	        "orderNumber",
	        "orderAmount",
	        "orderCurrency",
	        "orderTime",
	        "customerIp",
	        "customerName",
	        "defaultPayType",
	        "defaultBankNumber",
	        "transTimeout",
	        "frontEndUrl",
	        "backEndUrl",
	        "merReserved"
		};
		
		/**
		 * 支付宝合并支付请求网关
		 */
		public static final String ALIPAY_MERGERPAY_URL = "https://mapi.alipay.com/gateway.do?";
		
		/**
		 * 财付通双接口支付请求网关(兼容新中介担保)
		 */
		public static final String TENPAY_B2C_URL = "https://gw.tenpay.com/gateway/pay.htm";
		
		/**
		 * 财付通担保交易支付请求网关
		 */
		public static final String TENPAY_MED_URL = "https://www.tenpay.com/cgi-bin/med/show_opentrans.cgi";
		
		/**
		 * ZSHOP支持的手机支付方式列表
		 */
		public static final String[] MOBILEPAYS= new String[]{
			PAYMETHOD_ZFBMOBILE
		};
		
		/**
		 * 预付款在线支付时显示的商品名称
		 */
		public static final String ADVPAYMENT_PRODUCTNAME = "预存款充值";
		
		//预付款在线支付时显示的订单描述
		public static final String ADVPAYMENT_DESCRIPTION = "预存款充值在线支付";
		
		public static final String CREDITPAYMENT_PRODUCTNAME = "信用账户充值";
		
		//信用付款在线支付时显示的订单描述
		public static final String CREDITPAYMENT_DESCRIPTION = "信用账户充值在线支付";
	//******************************************银联UnionPay*****************************************************************
		/**  银联UnionPay 交易网关 */
		final static String UPOP_BASE_URL = "http://58.246.226.99/UpopWeb/api/";
		/**  银联UnionPay 请求连接方法 */
		final static String gateWay = UPOP_BASE_URL + "Pay.action";
		/**  银联UnionPay 交易查询 */
		final static String UPOP_QUERY_BASE_URL = "http://58.246.226.99/UpopWeb/api/";
		/**  银联UnionPay 交易查询方法 */
		final static String queryUrl = UPOP_QUERY_BASE_URL + "Query.action";
		/**  银联UnionPay  MD5 加密方式 */
		public final static String signType = "MD5";
		/**  银联UnionPay  SHA1withRSA 加密方式 */
		public final static String signType_SHA1withRSA = "SHA1withRSA";
		/**  银联UnionPay 签名signature 变量*/
		public final static String signature = "signature";
		/**  银联UnionPay 签名signMethod 变量 */
		public final static String signMethod = "signMethod";
		/**  银联UnionPay 版本号 */
		public final static String version = "1.0.0";
		/**  银联UnionPay 编码方式*/
		public final static String charset = "UTF-8";
		/**  银联UnionPay 交易类型 */
		public final static String transType = "01";
		/**  银联UnionPay 交易币种 */
		public final static String orderCurrency = "156" ;
		/**  银联UnionPay 交易超时时间 单位：毫秒 */
		public final static String transTimeout = "300000" ;
		/**  银联UnionPay 响应变量数据组 */
	    public final static String[] notifyVo = new String[]{
		            "charset",
		            "cupReserved",
		            "exchangeDate",
		            "exchangeRate",
		            "merAbbr",
		            "merId",
		            "orderAmount",
		            "orderCurrency",
		            "orderNumber",
		            "qid",
		            "respCode",
		            "respMsg",
		            "respTime",
		            "settleAmount",
		            "settleCurrency",
		            "settleDate",
		            "traceNumber",
		            "traceTime",
		            "transType",
		            "version"
			};
	    
		/** 银联UnionPay 交易查询变量数据组 */ 
	   public final static String[] queryVo = new String[]{
				"version",
				"charset",
				"transType",
				"merId",
				"orderNumber",
				"orderTime",
				"merReserved"
			};
}
