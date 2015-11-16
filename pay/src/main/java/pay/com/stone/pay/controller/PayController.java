package com.stone.pay.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayFunction;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.stone.base.controller.BaseController;
import com.stone.order.model.TOrder;
import com.stone.pay.model.CommonUtil;
import com.stone.pay.model.Pay;
import com.stone.pay.model.PayConstants;
import com.stone.pay.model.WXDOVerify;
import com.stone.pay.model.WeiXinPayDO;
import com.stone.tuan.mapper.TProductTuanMapper;
import com.stone.tuan.model.TProductTuan;
import com.stone.util.MatrixToImageWriter;
import com.stone.util.XMLUtil;

@Controller
public class PayController extends BaseController {

	protected static final Logger log = Logger.getLogger(PayController.class);

	@RequestMapping(value = "/sho/1")
	public String add(HttpServletResponse rps, HttpServletRequest rqs,
			TProductTuan item) throws Exception {
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(
				TProductTuanMapper.class);
		item.setShopId(this.getShopId(rqs));
		mapper.insert(item);
		rps.sendRedirect("tuan_list.do");
		return null;
	}

	@RequestMapping(value = "/sho/2")
	public ModelAndView list(HttpServletResponse rps, HttpServletRequest rqs)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		TProductTuanMapper mapper = this.getMybatisBaseService().getMapper(
				TProductTuanMapper.class);
		List<TProductTuan> list = mapper.selectByShopId(this.getShopId(rqs));
		mav.setViewName("/shop/tuan_list");
		mav.addObject("list", list);
		return mav;
	}

	/**
	 * 提交支付页面
	 * 
	 * @param orderid
	 * @param paytype
	 * @return
	 */
	@SuppressWarnings("unused")
	public String paySubmit(HttpServletRequest rqs, HttpServletResponse rps,
			Integer orderid, Integer preAccountInfoId, String creAccount,
			Integer payid, String payResultURL, String replaceFlag) {

		log.info("paySubmit begin:**************************************************************");
		String attach = payResultURL;
		Pay pay = new Pay();
		rqs.setAttribute("payResultURL", payResultURL);

		rqs.getSession().setAttribute("OrderIdForPay", orderid);

		// 订单信息
		TOrder order = null;

		try {
			if (order != null) {
				String payMethod = "";
				// 支付宝即时到账
				if (payMethod.equals(PayConstants.PAYMETHOD_ZFBJSDZ)) {
					log.info("支付宝即时到账-----begin");
					this.alipaydirectRequest(order, pay, rqs, rps);
					rqs.setAttribute("payform", "AliPaySubmit");
					log.info("支付宝即时到账-----end");
					// 支付宝担保交易
				}
			} else {
				rqs.setAttribute("error", "orderNull");
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		log.info("paySubmit end!**************************************************************");
		return "paySubmit";
	}

	/**
	 * 支付请求（支付宝即时到账交易）页面信息
	 * 
	 * @param order
	 * @param fortuneInstantGatewayid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void alipaydirectRequest(TOrder order, Pay pay,
			HttpServletRequest rqs, HttpServletResponse rps) {

		if (order == null || pay == null) {
			log.error("*** error: Class PayExtAction; Method alipaydirectRequest(); order or pay is null ***");
			showTenpayError(rqs, rps);
		}

		// 交易安全检验码，由数字和字母组成的32位字符串
		String key = pay.getSecretkey();
		if (key == null || key.equals("")) {
			log.error("*** error: Class PayExtAction; Method alipaydirectRequest(); key is null ***");
			showTenpayError(rqs, rps);
		}

		// 合作身份者ID，以2088开头由16位纯数字组成的字符串
		String partner = pay.getBizId();
		if (partner == null || partner.equals("")) {
			log.error("*** error: Class PayExtAction; Method alipaydirectRequest(); bizID is null ***");
			showTenpayError(rqs, rps);
		}

		// 签约支付宝账号或卖家收款支付宝帐户
		String seller_id = partner;

		// 字符编码格式 目前支持 gbk 或 utf-8
		String input_charset = AlipayConfig.input_charset;

		// 签名方式 不需修改
		String sign_type = AlipayConfig.sign_type;

		// 商品展示URL
		String show_url = "";

		// 服务器异步通知页面路径
		String notify_url = getReturnUrl("?method=alipayResponse&pid="
				+ pay.getId().toString(), rqs, rps);
		// String notify_url = getReturnUrl("?method=alipayResponse");

		// 页面跳转同步通知页面路径
		String return_url = getReturnUrl("?method=alipayResponseReturn&pid="
				+ pay.getId().toString(), rqs, rps);
		// String return_url = getReturnUrl("?method=alipayResponse");

		// /////////////////////////////////////////////////////////////////////////////////

		// 以下参数是需要通过下单时的订单数据传入进来获得
		// 必填参数
		String out_trade_no = order.getNumber();// 请与贵网站订单系统中的唯一订单号匹配（订单编号）

		// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
		// 次数为商品code
		// String subject = order.getId().toString();//订单id
		String subject = "";// 修改为显示商品名称
		subject = subject.replace("<br>", "");
		subject = subject.replace("</br>", "");
		subject = subject.replace(" ", "");
		// 订单总金额，显示在支付宝收银台里的“应付总额”里
		String total_fee = order.getNeedPay().toString();

		// 商品描述字段，保存值为支付方式ID
		// String body = pay.getId().toString();
		String body = "";

		// 签约支付宝账号或卖家收款支付宝帐户
		// String seller_email = "alipay-test14@alipay.com";

		// 扩展功能参数——分润(若要使用，请按照注释要求的格式赋值)
		// 提成信息集，与需要结合商户网站自身情况动态获取每笔交易的各分润收款账号、各分润金额、各分润说明。最多只能设置10条
		// 各分润金额的总和须小于等于total_fee
		// 提成信息集格式为：收款方Email_1^金额1^备注1|收款方Email_2^金额2^备注2
		// 如：
		// royalty_type = "10"
		// royalty_parameters = "111@126.com^0.01^分润备注一|222@126.com^0.01^分润备注二"

		// ///////////////////////////////////////////////////////////////////////////////////////////////////

		// 构造函数，生成请求URL
		// String sHtmlText =
		// AlipayDirectorService.BuildForm(partner,return_url,notify_url,show_url,
		// out_trade_no,subject,total_fee,body,seller_id,input_charset,key,sign_type);
		//
		// rqs.setAttribute("sHtmlText", sHtmlText);

		Map sPara = new HashMap();
		sPara.put("service", "create_direct_pay_by_user");
		sPara.put("payment_type", "1");
		sPara.put("partner", partner);
		sPara.put("return_url", return_url);
		sPara.put("notify_url", notify_url);
		sPara.put("_input_charset", input_charset);
		sPara.put("show_url", show_url);
		sPara.put("out_trade_no", out_trade_no);
		sPara.put("subject", subject);
		sPara.put("body", body);
		sPara.put("total_fee", total_fee);
		// sPara.put("seller_email", seller_email);
		sPara.put("seller_id", seller_id);
		sPara.put("agentid", "isv^sh35");

		// *****************************************网银直连***********************************
		// 网银直连
		String defaultbank = ""; // 默认网银代号，代号列表见http://club.alipay.com/read.php?tid=8681379
		defaultbank = rqs.getParameter("bankCN");
		if ("" != defaultbank && null != defaultbank) {
			// 默认支付方式，四个值可选：bankPay(网银); cartoon(卡通); directPay(余额); CASH(网点支付)
			sPara.put("paymethod", "bankPay");
			sPara.put("defaultbank", defaultbank);// BOCB2C "CITIC"
		}
		// ******************************************网银直连**********************************

		Map sParaNew = AlipayFunction.ParaFilter(sPara); // 除去数组中的空值和签名参数
		String mysign = AlipayFunction.BuildMysign(sParaNew, key);// 生成签名结果

		StringBuffer sbHtml = new StringBuffer();
		List keys = new ArrayList(sParaNew.keySet());
		String gateway = "https://mapi.alipay.com/gateway.do?";

		// POST方式传递（GET与POST二必选一）
		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\""
				+ gateway
				+ "_input_charset="
				+ input_charset
				+ "\" method=\"post\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sParaNew.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name
					+ "\" value=\"" + value + "\"/>");
		}
		sbHtml.append("<input type=\"hidden\" name=\"sign\" value=\"" + mysign
				+ "\"/>");
		sbHtml.append("<input type=\"hidden\" name=\"sign_type\" value=\""
				+ sign_type + "\"/>");

		// submit按钮控件请不要含有name属性
		sbHtml.append("</form>");

		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

		rqs.setAttribute("sHtmlText", sbHtml.toString());
	}

	private void showTenpayError(HttpServletRequest rqs, HttpServletResponse rps) {

		Integer orderId = (Integer) rqs.getSession().getAttribute(
				"OrderIdForPay");
		log.info("*** 获得session中的orderId info: Class PayExtAction; Method showTenpayError();获得的orderId为："
				+ orderId);

		if (null == orderId) {// 如果获取orderId为空
			log.error("*** error: Class PayExtAction; Method showTenpayError(); orderId is null ***");
		}
		String show_url = getPayReturnUrl(rqs, "/order_pay.html", orderId, "1",
				null, null);

		rqs.getSession().setAttribute("OrderIdForPay", null);
		log.info("*** 清除session中的orderId info: Class PayExtAction; Method showTenpayError();清除的orderId为："
				+ orderId);

		String strHtml = "<html><head>\r\n"
				+ "<result>1</result>\r\n<redirecturl>" + show_url
				+ "</redirecturl>"
				+ "<script language=\"javascript\">\r\nwindow.location.href='"
				+ show_url + "';\r\n" + "</script>\r\n"
				+ "</head><body></body></html>";

		try {
			PrintWriter out = rps.getWriter();
			out.println(strHtml);
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error(e);
		}

	}

	private String getReturnUrl(String returnSp, HttpServletRequest rqs,
			HttpServletResponse rps) {
		String returnUrl = rqs.getRequestURL().append(returnSp).toString();
		return returnUrl;
	}

	private String getPayReturnUrl(HttpServletRequest rqs, String returnSp,
			Integer orderId, String payResult, String verifyBookRes,
			BigDecimal price) {
		// ---"http://www.zshop.com/OrderExtPay.do"
		String url = rqs.getRequestURL().toString();

		// ---"/OrderExtPay.do"
		String uri = rqs.getRequestURI();

		int i = url.indexOf(uri);
		int j = returnSp.indexOf(".html");

		// ---"/&orderId=qihOzZbKSRWvuVbMTzcnQQ.html"
		String idStr = "/&orderId=" + orderId + "&payResult=" + payResult
				+ "&total_fee=" + (price != null ? price.toPlainString() : "")
				+ "&verifyBookRes=" + verifyBookRes + ".html";

		// ---"http://www.zshop.com" + "/orde_pay" +
		// "/&orderId=qihOzZbKSRWvuVbMTzcnQQ&payResult=0.html"
		String returnUrl = url.substring(0, i) + returnSp.substring(0, j)
				+ idStr;

		log.info("**********PayReturnUrl:" + returnUrl);
		return returnUrl;
	}

	public static  String paySubmit2() throws Exception {
		String codeUrl = "";
		InetAddress netAddress = InetAddress.getLocalHost();
		log.info("微信支付接口-----begin");
		WeiXinPayDO info = new WeiXinPayDO();
		info.setNonce_str(WXDOVerify.getRandomStr());
		info.setBody("测试veryfine");
		info.setOut_trade_no("112233");
		info.setTotal_fee(1);
		info.setSpbill_create_ip(netAddress.getHostAddress());
		WXDOVerify.verifySign(info);
		log.info("微信扫码支付提交信息准备，提交信息info[" + info.toString() + "]-----end");
		String returnXmlStr = CommonUtil.httpsRequest(
				"https://api.mch.weixin.qq.com/pay/unifiedorder", "POST",
				WXDOVerify.verifyXmlData(info));
		log.info("微信扫码支付二维返回xml 数据returnxml[" + returnXmlStr + "]-----end");
		log.info("微信支付接口-----end");

		Map returnMap = null;
		if (StringUtils.isNotBlank(returnXmlStr)) {
			returnMap = XMLUtil.doXMLParse(returnXmlStr);
			if ((returnMap != null) && (returnMap.size() > 0)) {
				codeUrl = returnMap.get("code_url").toString();
				codeUrl = createWeChatCode(codeUrl, "333");
			} else {
				log.info("获取微信支付的二维码失败");
			}
		}
		return "";
	}

	public static String createWeChatCode(String codeUrl, String orderNum) throws Exception {
		int width = 300;
		int height = 300;

		String format = "jpg";
		Hashtable hints = new Hashtable();

		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(codeUrl,
				BarcodeFormat.QR_CODE, width, height, hints);
		String codePath = "d:/local/qr/";
		String srcPath = codePath + orderNum + ".jpg";

		File outputFile = new File(srcPath);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		return "/manager/images/frontpay/qr" + orderNum + ".jpg";
	}
	
	
	public static void main(String[] args) {
		try {
			paySubmit2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * public void notifyVerify(@Read(key="orderid") Integer orderid) { OrderDO
	 * orderDO = this.orderService.getOrderById(orderid);
	 * this.log.info("微信订单号是[" + orderDO.getNumber() + "]-----end"); if (orderid
	 * != null) { this.log.info("微信查询接口-----begin");
	 * this.payLogger.info("微信查询接口-----begin"); WeChatSelectInfo info = new
	 * WeChatSelectInfo(); info.setOut_trade_no(orderDO.getNumber());
	 * info.setNonce_str(WeChatVerify.getRandomStr());
	 * WeChatSelectVerify.verifySign(info); this.log.info("微信扫码查询信息准备，提交信息info["
	 * + info.toString() + "]-----end"); String returnXmlStr =
	 * CommonUtil.httpsRequest("https://api.mch.weixin.qq.com/pay/orderquery",
	 * "POST", WeChatSelectVerify.verifyXmlData(info));
	 * this.log.info("微信扫码查询订单返回xml 数据returnxml[" + returnXmlStr + "]-----end");
	 * this.log.info("微信支付查询接口-----end"); try { Map<String, String> map =
	 * XMLUtil.doXMLParse(returnXmlStr); String returnCode =
	 * map.get("return_code"); String resultCode = map.get("result_code");
	 * String tradeState=map.get("trade_state"); String codeUrl = "";
	 * if(returnCode
	 * .equalsIgnoreCase("SUCCESS")&&resultCode.equalsIgnoreCase("SUCCESS"
	 * )&&tradeState.equalsIgnoreCase("SUCCESS")) { this.log.info(
	 * "查询微信支付的订单信息成功--------------------------------------------------------------"
	 * ); this.log.info("修改订单状态信息-------------------------------begin"); Date
	 * payTime = new Date(); BigDecimal pay_money=orderDO.getAmount(); Integer
	 * payId=orderDO.getPayerid(); String orderStatus =
	 * orderService.getOrderById(orderid) .getPayStatus().toString(); //
	 * 20120801 增加对支付宝双接口中选择担保交易支付的支持----start---------- //
	 * danBaoDeal参数1表示担保，0表示非担保 String danBaoDeal = "0"; // 20120801
	 * 增加对支付宝双接口中选择担保交易支付的支持----end------------ if
	 * (orderStatus.equals(IConstants.ORDER_STATUS_NO)) { String filePath = "";
	 * try { filePath = fileInfoService.getFilePathForXml( "hotel", "source"); }
	 * catch (Exception e) { e.printStackTrace(); } String abPath =
	 * this.createDirectory(filePath); boolean isSuccess =
	 * orderAppService.payOrderHandle(orderid,payId, payTime,
	 * pay_money,orderDO.getNumber(), this.getServlet().getServletContext(),
	 * danBaoDeal, abPath);
	 * 
	 * if( !isSuccess){ log.error(
	 * "payExtAction orderAppService.payOrderHandle int the line 8265 ");
	 * payLogger
	 * .error("payExtAction orderAppService.payOrderHandle int the line 8266 ");
	 * }
	 * 
	 * log.info("***** 修改订单支付状态成功 *****");
	 * payLogger.info("***** 修改订单支付状态成功 *****"); }
	 * showJsp(getPayReturnUrl("/order_pay.html", orderid, "0",null,pay_money));
	 * 
	 * 
	 * }else { this.log.info("查询微信支付的订单信息失败"); } } catch (JDOMException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * this.log.info(
	 * "进来了!**************************************************************");
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * /*String orderNo = null;
	 * this.log.info("微信扫码支付-在线支付异步回调开始，微信服务端返回数据info=[" + info.toString()+
	 * "]-----end"); BufferedReader in = request.getReader(); String str = null;
	 * StringBuffer buffer = new StringBuffer(); while ((str = in.readLine()) !=
	 * null) { buffer.append(str); } // 释放资源 in.close();
	 * this.log.info("微信回调信息解析："+buffer.toString()); Map<String, Object>
	 * returnMap = XMLUtil.doXMLParse(buffer.toString()); xmlToObject(returnMap,
	 * info); if(info.getOut_trade_no()!=null){ orderNo =
	 * info.getOut_trade_no().split("W")[0];//提供微信订单号规则：当前订单号+haixue+当前时间戳
	 * logger.error("当前返回订单号orderNo["+orderNo+"]"); HXPayCallbackResult result =
	 * payHandler.execute(request, PayCallbackMethodEnum.ASYNC, info, orderNo);
	 * logger.error("微信扫码支付-在线支付异步回调结束，数据验证结果result=["+result+"]");
	 * if(result.isFailure()){ //logger.error("微信扫码支付-在线支付异步回调签名验证失败orderNo:{}",
	 * orderNo); }else{ logger.error("微信支付成功返回，给微信发送成功消息");
	 */
	/**
	 * 发送信息给微信服务器
	 */
	/*
	 * SortedMap<Object, Object> toWX = new TreeMap<Object, Object>();
	 * toWX.put("return_code", "SUCCESS"); toWX.put("return_msg", "OK");
	 * response.getWriter().write(PayCommonUtil.getRequestXml(toWX)); } } }
	 *//**
	 * 把微信返回数据封装
	 * 
	 * @param returnMap
	 * @param info
	 */
	/*
	 * private void xmlToObject(Map<String, Object>
	 * returnMap,WeChatPayReturnInfo info){ if(info == null){ info = new
	 * WeChatPayReturnInfo(); } for (Entry<String, Object> entry :
	 * returnMap.entrySet()) { try { java.lang.reflect.Field field =
	 * info.getClass().getDeclaredField(entry.getKey());
	 * field.setAccessible(true); // 如果类型是Integer if
	 * (field.getGenericType().toString().equals( "class java.lang.Integer")) {
	 * field.set(info,Integer.parseInt(entry.getValue().toString())); }else{
	 * field.set(info, entry.getValue()); } } catch (NoSuchFieldException e) {
	 * logger.error("得到WeChatPayReturnInfo的域出现异常，请检查名称是否正确");
	 * e.printStackTrace(); } catch (SecurityException e) {
	 * logger.error("得到WeChatPayReturnInfo的域出现异常，请检查名称是否正确");
	 * e.printStackTrace(); } catch (IllegalArgumentException e) {
	 * logger.error("set赋值非法"); e.printStackTrace(); } catch
	 * (IllegalAccessException e) { logger.error("set赋值非法");
	 * e.printStackTrace(); } }}
	 */

}
