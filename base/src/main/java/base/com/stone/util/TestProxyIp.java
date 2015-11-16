package com.stone.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Jason
 * @date Oct 27, 2010
 * @version 1.0
 */
public class TestProxyIp {
	private static final Logger log = Logger.getLogger(TestProxyIp.class);

	public static void main(String[] args) throws IOException {
		System.setProperty("http.maxRedirects", "50");
		System.getProperties().setProperty("proxySet", "true");
		// 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
		String ip = "93.91.200.146";
		ip = "221.130.18.5";
		ip = "221.130.23.135";
		ip = "221.130.18.78";
		ip = "221.130.23.134";
		ip = "221.130.18.49";
		ip = "111.1.32.36";
		ip = "221.130.18.49";
		ip = "221.130.18.49";
		System.getProperties().setProperty("http.proxyHost", ip);
		System.getProperties().setProperty("http.proxyPort", "80");

		for (int i = 0; i < 100; i++) {
			// 确定代理是否设置成功
			String urls = "http://www.ganji.com/index.htm";
			URL url = new URL(urls);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
			Document doc = Jsoup.parse(conn.getInputStream(), "utf8", urls);
			System.out.println(doc);
		}

	}
}
