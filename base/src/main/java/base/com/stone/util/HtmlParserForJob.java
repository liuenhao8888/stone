package com.stone.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserForJob {
	
	public static void main(String[] s) {
		try {
			parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void parse() throws IOException{
		
		Document doc = Jsoup.parse(new File("E:/job.htm"), "UTF-8");
		Elements es = doc.getElementsByAttributeValue("class", "content");
		Elements siders = doc.getElementsByAttributeValue("class", "fenlei");
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		b1.append("[");
		b2.append("[");
			
		for(int i=0;i<siders.size();i++){
			Element s = siders.get(i);
			Element dt = s.getElementsByTag("dt").get(0);
			String txt = dt.text().replaceAll(">>","");
			if(i==siders.size()-1)
				b1.append("'"+txt).append("'");
			else
				b1.append("'"+txt).append("',");
			System.out.println(txt);
			
			Element dd = s.getElementsByTag("dd").get(0);
			Elements as = dd.getElementsByTag("a");
			b2.append("[");
			for(int j=0;j<as.size();j++){
				Element a = as.get(j);
				if(j==as.size()-1)
					b2.append("'"+a.text()).append("'");
				else
					b2.append("'"+a.text()).append("',");
				System.out.println("-----   "+a.text());
			}
			b2.append("],");
			System.out.println();
		}
		b1.append("]");
		b2.append("]");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(new File("E:/job.js")),"utf-8");
		w.write("var vocation ="+ b1.toString());
		w.write("\n\n");
		w.write("var position ="+b2.toString());
		w.close();
		
	}
	
	
}
