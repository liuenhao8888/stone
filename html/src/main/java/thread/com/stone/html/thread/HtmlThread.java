package com.stone.html.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Service("htmlThread" )
public class HtmlThread implements Runnable{
	
	
	@Resource(name="catalogHtmlThread")
	private Runnable catalogHtmlThread;
	
	@Resource(name="siteHtmlThread")
	private Runnable siteHtmlThread;
	
	
	public void run() {
		ExecutorService e = Executors.newFixedThreadPool(1);
		e.execute(catalogHtmlThread);
		e.execute(siteHtmlThread);
	}
}
