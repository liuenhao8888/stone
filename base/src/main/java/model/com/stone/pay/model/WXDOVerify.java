package com.stone.pay.model;

import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.stone.util.MD5Util;

public class WXDOVerify implements Serializable {
	private static final long serialVersionUID = -3208569838179379623L;
	private static Logger logger = LoggerFactory.getLogger(WXDOVerify.class);

	private static String appendParam(String returnStr, String paramId,
			String paramValue) {
		if ((returnStr != null) && (!returnStr.equals(""))) {
			if ((paramValue != null) && (!paramValue.equals(""))) {
				returnStr = returnStr + "&" + paramId + "=" + paramValue.trim();
			}
		} else if ((paramId != null) && (!paramId.equals(""))
				&& (paramValue != null) && (!paramValue.equals(""))) {
			returnStr = paramId + "=" + paramValue.trim();
		}

		return returnStr;
	}

	private static String getPostXml(String returnStr, String paramId,
			String paramValue) {
		if ((returnStr != null) && (!returnStr.equals(""))) {
			if ((paramId != null) && (!paramId.equals(""))
					&& (paramValue != null) && (!paramValue.equals(""))) {
				returnStr = returnStr + "<" + paramId + ">" + paramValue + "</"
						+ paramId + ">";
			}

		} else if ((paramId != null) && (!paramId.equals(""))
				&& (paramValue != null) && (!paramValue.equals(""))) {
			returnStr = "<xml><" + paramId + ">" + paramValue + "</" + paramId
					+ ">";
		}

		return returnStr;
	}


	public static void verifySign(WeiXinPayDO info) {
		String stringSignTemp = "";
		stringSignTemp = appendParam(stringSignTemp, "appid", info.getAppid());
		stringSignTemp = appendParam(stringSignTemp, "body", info.getBody());
		stringSignTemp = appendParam(stringSignTemp, "mch_id", info.getMch_id());
		stringSignTemp = appendParam(stringSignTemp, "nonce_str",
				info.getNonce_str());
		stringSignTemp = appendParam(stringSignTemp, "notify_url",
				info.getNotify_url());
		stringSignTemp = appendParam(stringSignTemp, "out_trade_no",
				info.getOut_trade_no());
		stringSignTemp = appendParam(stringSignTemp, "spbill_create_ip",
				info.getSpbill_create_ip());
		stringSignTemp = appendParam(stringSignTemp, "total_fee",
				String.valueOf(info.getTotal_fee()));
		stringSignTemp = appendParam(stringSignTemp, "trade_type",
				info.getTrade_type());
		stringSignTemp = stringSignTemp + "&key=" + info.getAppSecret();
		logger.error("数字签名生成字符串stringSignTemp：" + stringSignTemp);
		System.out.println("数字签名生成字符串stringSignTemp：" + stringSignTemp);
		info.setSign(MD5Util.toMD5(stringSignTemp, "utf-8").toUpperCase());
	}

	public static String verifyXmlData(WeiXinPayDO info) {
		String postXmlStr = "";
		postXmlStr = getPostXml(postXmlStr, "appid", info.getAppid());
		postXmlStr = getPostXml(postXmlStr, "body", info.getBody());
		postXmlStr = getPostXml(postXmlStr, "mch_id", info.getMch_id());
		postXmlStr = getPostXml(postXmlStr, "nonce_str", info.getNonce_str());
		postXmlStr = getPostXml(postXmlStr, "notify_url", info.getNotify_url());
		postXmlStr = getPostXml(postXmlStr, "out_trade_no",
				info.getOut_trade_no());
		postXmlStr = getPostXml(postXmlStr, "spbill_create_ip",
				info.getSpbill_create_ip());
		postXmlStr = getPostXml(postXmlStr, "total_fee",
				String.valueOf(info.getTotal_fee()));
		postXmlStr = getPostXml(postXmlStr, "trade_type", info.getTrade_type());
		postXmlStr = getPostXml(postXmlStr, "sign", info.getSign());
		postXmlStr = postXmlStr + "</xml>";
		logger.error("数字签名生成字符串stringSignTemp：" + postXmlStr);
		return postXmlStr;
	}

	public static String getRandomStr() {
		StringBuffer nonce_str = new StringBuffer("HAIXUE");
		nonce_str.append(new Date().getTime());

		nonce_str
				.append(String.valueOf(Math.round(Math.random() * 8999.0D + 1000.0D)));
		return nonce_str.toString().toUpperCase();
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getServerIp() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			logger.error("成功获取服务器ip地址：[" + ip + "]");
		} catch (Exception ee) {
			logger.error("获取服务器ip出现问题");
			ee.printStackTrace();
		}

		return ip;
	}

	public static String EncoderByMd5(String str)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String newstr = MD5Util.toMD5(str,"utf-8");
		return newstr;
	}

	public static void main(String[] arg0) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {

		logger.info(EncoderByMd5("123456"));

		// WeiXinPayDO info = new WeiXinPayDO();
		// info.setNonce_str(getRandomStr());
		// info.setOut_trade_no("no456456456456456");
		// info.setTotal_fee(new BigDecimal("100.40").multiply(new
		// BigDecimal(100)).intValue());
		// info.setSpbill_create_ip(getServerIp());
		// verifySign(info);
		// System.out.println(info.toString());
		// verifyXmlData(info);
	}
}