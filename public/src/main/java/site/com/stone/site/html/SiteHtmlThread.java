package com.stone.site.html;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.stone.base.system.SystemConstants;
import com.stone.site.model.Catalog;
import com.stone.site.service.ISiteService;
import com.stone.util.FreeMarker2Html;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Service("siteHtmlThread" )
public class SiteHtmlThread implements Runnable{
	
	@Resource(name="siteService")
	private ISiteService siteService;
	
	private final FreeMarker2Html html = new FreeMarker2Html();
	
	@SuppressWarnings("unchecked")
	public void run() {
		System.out.println("************************     siteHtmlThread    **********************************");
		List<Map> list =  this.siteService.listSites();
		for(Map m : list){
			try {
				String page = ((Catalog)m.get("catalog")).getId()+".html";
				html.createHtmlFile("/template","sites.ftl",m,SystemConstants.webRoot,page);
				System.out.println("************************     静态化site "+page+" 页面    **********************************");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("************************     定时静态化site信息完成 共计 "+list.size()+" 页面    **********************************");
	}
}