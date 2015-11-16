package com.stone.util;

import java.security.MessageDigest;

public class MD5Util {

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			if (Integer.toHexString(0xFF & b[i]).length() == 1){
				sb.append("0").append(
						Integer.toHexString(0xFF & b[i]));
			}else{
				sb.append(Integer.toHexString(0xFF & b[i]));
			}
		}
		return sb.toString();
	}


	public static String toMD5(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			if ((charsetname == null) || ("".equals(charsetname)))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception localException) {
		}
		return resultString;
	}

	public static void main(String[] args) {
		System.out.println(toMD5("123456",null));
	}
}