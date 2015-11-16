package com.stone.site.html;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.stone.base.system.SystemConstants;
import com.stone.site.model.CatalogList;
import com.stone.site.service.ICatalogService;
import com.stone.util.FreeMarker2Html;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Service("catalogHtmlThread" )
public class CatalogHtmlThread implements Runnable{
	
	@Resource(name="catalogService")
	private ICatalogService catalogService;
	
	private final FreeMarker2Html html = new FreeMarker2Html();
	
	@SuppressWarnings("unchecked")
	public void run() {
		System.out.println("************************     catalogHtmlThread    **********************************");
		CatalogList cl = this.catalogService.listCatalog();
		Map m = new HashMap();
		m.put("cl",cl);
		try {
			html.createHtmlFile("/template","index.ftl",m,SystemConstants.webRoot,"index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("************************     定时静态化catalog信息完成    **********************************");
	}
}