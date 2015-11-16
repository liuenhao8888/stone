package com.stone.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserForGanji {
	protected static final Logger log = Logger.getLogger(HtmlParserFor58.class);

	private static int code1 = 100000000;
	private static int code2 = 0;
	private static int code3 = 0;
	private static int unitNum = 3;

	private static Document getDocumentByProxy(String urlStr)
			throws IOException {
		Document doc = null;
		try {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, IsaFactory.getIsa());
			URL url = new URL(urlStr);
			URLConnection uc = url.openConnection(proxy);
			doc = Jsoup.parse(uc.getInputStream(), "utf8", urlStr);
		} catch (Exception e) {
//			e.printStackTrace();
			log.info("************** 代理链接发生异常，从新选择代理  *******************");
			doc = getDocumentByProxy(urlStr);
		}
		return doc;
	}

	public static void main(String[] s) {
		try {
//			IsaFactory.parseProxyAdd();
//			
//			return ;
			
			
			JdbcOpt2.createCityTab();
			JdbcOpt2.createCityTab2();
			JdbcOpt2.createCityTab3();
			String urlStr = "http://www.ganji.com/index.htm";
			Document doc = getDocumentByProxy(urlStr);
			Elements es = doc.getElementsByAttributeValue("class", "all-city");
			es = es.get(0).getElementsByTag("a");
			List<City> cityList = new ArrayList<City>();
			for (Element e : es) {
				code1 = generateNewSiblingCode(code1);
				// if(!"北京".equals(e3.text()))continue;
				printPrent(e.absUrl("href"), "fang1/", e.text());
				int end = e.attr("href").indexOf(".");
				City city = new City();
				city.setId(code1);
				city.setName(e.text());
				city.setCode(e.attr("href").substring(7, end));
				cityList.add(city);
			}
			JdbcOpt2.insertCity(cityList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void printPrent(String urls, String type, String name)
			throws IOException, InterruptedException {
		int end = urls.indexOf(".");
		log.info(code1+"  "+name + "  " + urls.substring(7, end));
		Document doc = getDocumentByProxy(urls + type);
		Elements es = doc.select("div.area>a");
		while (es.size() == 0) {
			System.out
					.println(" ========================== url =============================   ");
			log.info(urls);
			System.out
					.println(" ========================== doc =============================   ");
			log.info(doc);
			// Thread.sleep(new Double(Math.floor(Math.random() * 30000))
			// .longValue());
			doc = Jsoup.connect(urls + type).timeout(60000).get();
			es = doc.select("div.area>a");
		}
		es.remove(0);
		List<City> cityList = new ArrayList<City>();
		boolean isFirst = true;
		for (Element p : es) {
			String href = p.attr("href");
			if (!"".equals(href)) {
				if (isFirst) {
					code2 = generateNewSubCode(code1);
					isFirst = false;
				} else {
					code2 = generateNewSiblingCode(code2);
				}
				// log.info(count2+" "+p.text()+""+p.attr("href").substring(7)+"  "+pid);
				printChildren(urls + type + p.attr("href").substring(7),
						p.text(), code2);
				String urls2 = p.attr("href");
				int end2 = urls2.indexOf(".");
				String temps = urls2.substring(0, urls2.length() - 1);
				int start = temps.lastIndexOf("/") + 1;
				City city = new City();
				city.setId(code2);
				city.setName(p.text());
				city.setCode(temps.substring(start, temps.length()));
				city.setPid(code1);
				cityList.add(city);
			}
		}
		JdbcOpt2.insertCity2(cityList);
	}

	static void printChildren(String urls, String name, int pid)
			throws IOException, InterruptedException {
		String temps = urls.substring(0, urls.length() - 1);
		int start = temps.lastIndexOf("/") + 1;
		log.info("-----" + code2 + "  " + name + "  "
				+ temps.substring(start, temps.length()) + " " + code1);
		Document doc = getDocumentByProxy(urls);
		Elements es = doc.select("div.subarea>a");
		if (es.size() > 0)
			es.remove(0);
		List<City> cityList = new ArrayList<City>();
		boolean isFirst = true;
		for (Element e : es) {
			urls = e.attr("href");
			if (isFirst) {
				code3 = generateNewSubCode(code2);
				isFirst = false;
			} else {
				code3 = generateNewSiblingCode(code3);
			}
			temps = urls.substring(0, urls.length() - 1);
			start = temps.lastIndexOf("/") + 1;
			log.info("----------" + code3 + " " + e.text() + "  "
					+ temps.substring(start, temps.length()) + "  " + code2);
			City city = new City();
			city.setId(code3);
			city.setName(e.text());
			city.setCode(temps.substring(start, temps.length()));
			city.setPid(code2);
			cityList.add(city);
		}
		JdbcOpt2.insertCity3(cityList);
	}

	/**
	 * 生成新的兄弟编码
	 * 
	 * @return
	 */
	private static int generateNewSiblingCode(int code) {
		String codeStr = new Integer(code).toString();
		int power = codeStr.length() - unitNum;
		for (int i = power; i > 1; i -= unitNum) {
			double divisor = Math.pow(10, i);
			if (code % divisor == 0) {
				double code2 = (code / divisor + 1) * divisor;
				return Double.valueOf(code2).intValue();
			}
		}
		return code + 1;
	}

	/**
	 * 生成新子编码 若无子区域即本身就是最底级则返回0
	 * 
	 * @return
	 */
	private static int generateNewSubCode(int code) {
		String codeStr = new Integer(code).toString();
		int power = codeStr.length() - unitNum;
		for (int i = power; i > 1; i -= unitNum) {
			double divisor = Math.pow(10, i);
			if (code % divisor == 0) {
				double code2 = code += divisor / Math.pow(10, unitNum);
				return Double.valueOf(code2).intValue();
			}
		}
		return 0;
	}

	static class IsaFactory {

		static List<InetSocketAddress> isaList = new ArrayList<InetSocketAddress>();
		static int index = 0;

		static {
			
			parseProxyAddr();
			
//			InetSocketAddress isa = new InetSocketAddress("101.4.136.66", 80);
//			isaList.add(isa);
//			isa = new InetSocketAddress("111.161.126.98", 80);
//			isaList.add(isa);
//			isa = new InetSocketAddress("111.206.50.177", 80);
//			isaList.add(isa);
//			isa = new InetSocketAddress("117.167.75.120", 8123);
//			isaList.add(isa);
//			isa = new InetSocketAddress("202.119.25.71", 9999);
//			isaList.add(isa);
			
		}

		static InetSocketAddress getIsa() {
			index++;
			index = index>=isaList.size() ? 0 : index;
			InetSocketAddress isa = isaList.get(index);
			log.info(index+"  "+isa.getHostName()+" : "+isa.getPort());
			return isa;
		}

		private static void parseProxyAddr() {
			try {
				URL url = new URL("http://www.proxy.com.ru/");
				Document doc = Jsoup.parse(url, 300000);
				Elements es = doc.select("table[bordercolor=#CCCCCC]");
				Element e = es.get(3);
				es = e.select("tr");
				es.remove(0);
				es.remove(0);
				es.remove(0);
				for(Element e2 : es){
					Elements es2 = e2.select("td");
					if(es2.size()==5){
						String hostName = es2.get(1).text();
						int port = Integer.parseInt(es2.get(2).text());
//						log.info(hostName + " : "+ port);
						InetSocketAddress isa = new InetSocketAddress(hostName, port);
						isaList.add(isa);
					}
				}
				log.info(isaList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
