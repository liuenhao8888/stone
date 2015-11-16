package com.stone.pay.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class CommonUtil
{
  public static final String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

  public static String httpsRequest(String requestUrl, String requestMethod, String outputStr)
  {
    String strs = null;
    try {
      TrustManager[] tm = { new MyX509TrustManager() };
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init(null, tm, new SecureRandom());

      SSLSocketFactory ssf = sslContext.getSocketFactory();

      URL url = new URL(requestUrl);
      HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
      conn.setSSLSocketFactory(ssf);

      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);

      conn.setRequestMethod(requestMethod);

      if (outputStr != null) {
        OutputStream outputStream = conn.getOutputStream();

        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }

      InputStream inputStream = conn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;
      StringBuffer buffer = new StringBuffer();
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }

      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();
      inputStream = null;
      conn.disconnect();
      strs = buffer.toString();
    }
    catch (ConnectException localConnectException) {
    }
    catch (Exception localException) {
    }
    return strs;
  }

  public static String httpsRequest1(String requestUrl, String requestMethod, String outputStr)
  {
    try
    {
      TrustManager[] tm = { new MyX509TrustManager() };
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init(null, tm, new SecureRandom());

      SSLSocketFactory ssf = sslContext.getSocketFactory();
      URL url = new URL(requestUrl);
      HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
      conn.setSSLSocketFactory(ssf);
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);

      conn.setRequestMethod(requestMethod);
      conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");

      if (outputStr != null) {
        OutputStream outputStream = conn.getOutputStream();

        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }

      InputStream inputStream = conn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;
      StringBuffer buffer = new StringBuffer();
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }

      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();
      inputStream = null;
      conn.disconnect();
      return buffer.toString();
    }
    catch (ConnectException localConnectException) {
    }
    catch (Exception localException) {
    }
    return null;
  }

  public static String urlEncodeUTF8(String source)
  {
    String result = source;
    try {
      result = URLEncoder.encode(source, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static long getDate() {
    Date date = new Date();
    return date.getTime();
  }
}