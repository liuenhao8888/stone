package com.stone.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;


import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarker2Html {

		public boolean createHtmlFile(String templatePath,String templateFileName, Object object,
				String htmlFilePath, String htmlFileName) throws Exception {
				File f = new File(htmlFilePath);
				if(!f.exists()){
					if(!f.mkdirs()){
						return false;
					}
				}
				Locale locale = new Locale("zh_CN");
				Template t = getFreeMarkerConfiguration(templatePath).getTemplate(templateFileName);
				t.setEncoding("UTF-8");
				t.setLocale(locale);
				t.setOutputEncoding("UTF-8");
				File afile = new File(htmlFilePath + htmlFileName);
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile), "UTF-8"));
				t.process(object, out);
			return true;
		}

		private Configuration getFreeMarkerConfiguration(String templatePath){
			Configuration configuration = new Configuration();
			try {
				Locale locale = new Locale("zh_CN");
				configuration.setClassForTemplateLoading(this.getClass(),templatePath);
				configuration.setDefaultEncoding("UTF-8");
				configuration.setEncoding(locale, "UTF-8");
				configuration.setLocale(locale);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return configuration;
		}

		
	}
