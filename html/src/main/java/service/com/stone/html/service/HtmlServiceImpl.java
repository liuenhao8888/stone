package com.stone.html.service;


import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.stone.base.system.MyApplicationContext;
import com.stone.base.system.SystemConstants;
import com.stone.html.thread.HtmlThread;
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Service("htmlService" )
public class HtmlServiceImpl implements IHtmlService {
	
	@Resource(name="htmlThread")
	private HtmlThread htmlThread;
	
	public void batchCreate(){
		ApplicationContext  context = MyApplicationContext.getContext();
		//htmlThread = context.getBean("htmlThread", HtmlThread.class);
		ScheduledExecutorService schedule =  new ScheduledThreadPoolExecutor(1);
		schedule.scheduleWithFixedDelay(htmlThread, SystemConstants.htmlDelay, SystemConstants.htmlCycle, TimeUnit.SECONDS);
	}
	
	@PostConstruct
	private void init(){
//		batchCreate();
	}

}

