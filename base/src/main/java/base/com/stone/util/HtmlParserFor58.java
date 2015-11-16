package com.stone.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserFor58 {
	
	protected static final Logger log = Logger.getLogger(HtmlParserFor58.class);

	private static long code1 = 133000000000L;
	private static long code2 = 0;
	private static long code3 = 0;
	private static long code4 = 0;
	private static int unitNum = 3;
	private static List<Area> areaList1 = new ArrayList<Area>();
	
	

	public static void main(String[] s) {
		try {
			JdbcOpt.createAreaTab();
			String urlStr = "http://www.58.com/changecity.aspx?PGTID=14277594266420.17232047809122608&ClickID=1";
			URL url = new URL(urlStr);
			Document doc = Jsoup.parse(url, 3000000);
			Element e = doc.getElementById("clist");
			Elements es = e.getElementsByTag("dd");
			es.remove(1);
			es.remove(27);
			for (int i=0;i<1;i++) {
				code1 = generateNewSiblingCode(code1);
				Area area = areaList1.get(i);
				area.setId(code1);
				
				Elements es2 = es.get(i).getElementsByTag("a");
				List<Area> areaList2 = new ArrayList<Area>();
				boolean isFirst = true;
				for (Element e3 : es2) {
					if(isFirst){
						code2 = generateNewSubCode(code1);
						isFirst = false;
					}else{
						code2 = generateNewSiblingCode(code2);
					}
//					if(code2<365000000)continue;
//					printPrent(e3.absUrl("href"), "ershoufang", e3.text());
					printPrent("http://am.58.com/", "ershoufang", "上海市");
					break;
//					String hr = e3.attr("href");
//					Area a2 = new Area();
//					a2.setId(code2);
//					a2.setPreName(e3.text());
//					a2.setcName(hr.substring(7, hr.indexOf(".")));
//					a2.setAreaCode(JdbcOpt.selectAreaCode(a2.getPreName(),1));
//					a2.setParentId(code1);
//					a2.setGrade(2);
//					areaList2.add(a2);
				}
//				JdbcOpt.insertArea(areaList2);
			}
//			JdbcOpt.insertArea(areaList1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void printPrent(String urls, String type, String name)
			throws IOException, InterruptedException {
		if(code2<124001000000L)return;
		log.info(code2 + " " + name + " " + urls);
//		Thread.sleep(new Double(Math.floor(Math.random() * 10000)).longValue());
		Document doc = Jsoup.connect(urls + type).timeout(10000).get();
		Elements es = doc.select(".relative_show");
		es = es.get(0).select("a[href~=/[a-zA-Z0-9]+/ershoufang/]");
//		Elements es = doc.select("dl#region>dd>a");
		while(es.size()==0){
			log.info(" ========================== url =============================   ");
			log.info(urls+type);
			log.info(" ========================== doc =============================   ");
			log.info(doc);
			Thread.sleep(new Double(Math.floor(Math.random() * 10000)).longValue());
			doc = Jsoup.connect(urls + type).timeout(60000).get();
			es = doc.select(".relative_show");
			es = es.get(0).select("a[href~=/[a-zA-Z0-9]+/ershoufang/]");
		}
		List<Area> areaList3 = new ArrayList<Area>();
		boolean isFirst = true;
		for (Element p : es) {
			String href = p.attr("href");
			if (!"".equals(href)) {
				if(isFirst){
					code3 = generateNewSubCode(code2);
					isFirst = false;
				}else{
					code3 = generateNewSiblingCode(code3);
				}
				printChildren(urls + p.attr("href"), p.text());
				String urls2 = p.attr("href");
				String temps = urls2.substring(0, urls2.length() - 1);
				Area area = new Area();
				area.setId(code3);
				area.setPreName(p.text());
				area.setcName(temps.substring(1, temps.lastIndexOf("/")));
				area.setAreaCode(JdbcOpt.selectAreaCode(area.getPreName(),2));
				area.setParentId(code2);
				area.setGrade(3);
				areaList3.add(area);
			}
		}
		JdbcOpt.insertArea(areaList3);
	}

	static void printChildren(String urls, String name)
			throws IOException, InterruptedException {
		if(code3<=123010006000L)return;
		String temps = urls.substring(urls.lastIndexOf("//") + 2,
				urls.lastIndexOf("/"));
		int end = temps.lastIndexOf("/");
		log.info("-----" + code3 + " " + name + " "
				+ temps.substring(0, end) + " " + code2);
//		Thread.sleep(new Double(Math.floor(Math.random() * 10000)).longValue());
		Document doc = Jsoup.connect(urls).timeout(20000).get();
		Elements es = doc.select("div.subarea>a");
//		while(es.size()==0){
//			log.info(" ========================== url =============================   ");
//			log.info(urls);
//			log.info(" ========================== doc =============================   ");
//			log.info(doc);
//			Thread.sleep(new Double(Math.floor(Math.random() * 10000)).longValue());
//			doc = Jsoup.connect(urls).timeout(60000).get();
//			es = doc.select("div.subarea>a");
//		}
		
		List<Area> areaList4 = new ArrayList<Area>();
		boolean isFirst = true;
		for (Element e : es) {
			String hanyu = e.text();
			String pinyin =(new Hanyu()).getStringPinYin(hanyu);
			if(isFirst){
				code4 = generateNewSubCode(code3);
				isFirst = false;
			}else{
				code4 = generateNewSiblingCode(code4);
			}
			log.info("----------" + code4 + " " + e.text() + " "+ pinyin + " " + code3);
			Area area = new Area();
			area.setId(code4);
			area.setPreName(e.text());
			area.setcName(pinyin);
			area.setAreaCode("");
			area.setParentId(code3);
			area.setGrade(4);
			area.setIsLeaf(1);
			areaList4.add(area);
		}
		log.info(areaList4);
		JdbcOpt.insertArea(areaList4);
	}
	
	/**
	 * 生成新的兄弟编码
	 * @return
	 */
	private static long generateNewSiblingCode(long code) {
		String codeStr = new Long(code).toString();
		int power = codeStr.length()-unitNum;
		for(int i=power; i>1;i-=unitNum){
			double divisor = Math.pow(10, i);
			if (code % divisor == 0) {
				double code3 =(code/divisor+1)*divisor;
				return Double.valueOf(code3).longValue();
			}
		}
		return code+1;
	}

	/**
	 * 生成新子编码
	 * 若无子区域即本身就是最底级则返回0
	 * @return
	 */
	private static long generateNewSubCode(long code) {
		String codeStr = new Long(code).toString();
		int power = codeStr.length()-unitNum;
		for(int i=power; i>1;i-=unitNum){
			double divisor = Math.pow(10, i);
			if (code % divisor == 0) {
				code += divisor/Math.pow(10, unitNum);
				return Double.valueOf(code).longValue();
			}
		}
		return 0;
	}
	
	static{
//		areaList1.add(new Area("山东","shandong","370000"));
//		areaList1.add(new Area("江苏","jiangsu","320000"));
//		areaList1.add(new Area("浙江","zhejiang","330000"));
//		areaList1.add(new Area("安徽","anhui","340000"));
//		
//		areaList1.add(new Area("广东","guangdong","440000"));
//		areaList1.add(new Area("福建","fujian","350000"));
//		areaList1.add(new Area("广西","guangxi","450000"));
//		areaList1.add(new Area("海南","hainan","460000"));
//		
//		areaList1.add(new Area("河南","henan","410000"));
//		areaList1.add(new Area("湖北","hubei","420000"));
//		areaList1.add(new Area("湖南","hunan","430000"));
//		areaList1.add(new Area("江西","jiangxi","360000"));
//		
//		areaList1.add(new Area("辽宁","liaoning","210000"));
//		areaList1.add(new Area("黑龙江","heilongjiang","230000"));
//		areaList1.add(new Area("吉林","jilin","220000"));
//		
//		areaList1.add(new Area("四川","sichuan","510000"));
//		areaList1.add(new Area("云南","yunnan","530000"));
//		areaList1.add(new Area("贵州","guizhou","520000"));
//		areaList1.add(new Area("西藏","xizang","540000"));
//		
//		areaList1.add(new Area("河北","hebei","130000"));
//		areaList1.add(new Area("山西","shanxi","140000"));
//		areaList1.add(new Area("内蒙古","neimenggu","150000"));
//		
//		areaList1.add(new Area("陕西","shanxi","610000"));
//		areaList1.add(new Area("新疆","xinjiang","650000"));
//		areaList1.add(new Area("甘肃","gansu","620000"));
//		areaList1.add(new Area("宁夏","ningxia","640000"));
//		areaList1.add(new Area("青海","qinghai","630000"));
		
		areaList1.add(new Area("北京","beijing","110000"));
		areaList1.add(new Area("上海","shanghai","310000"));
		areaList1.add(new Area("天津","tianjin","120000"));
		areaList1.add(new Area("重庆","chongqing","510200"));
		
		areaList1.add(new Area("台湾","taiwan","710000"));
		areaList1.add(new Area("香港","xianggang","720000"));
		areaList1.add(new Area("澳门","aomen","730000"));
		
//		areaList1.add(new Area("其他","qita","100000"));
		
		
	}
}
