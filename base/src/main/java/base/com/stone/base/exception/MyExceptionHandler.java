package com.stone.base.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.stone.util.DateUtil;


/**
 * 不必在Controller中对异常进行处理，抛出即可，由此异常解析器统一控制。<br>
 * ajax请求（有@ResponseBody的Controller）发生错误，输出JSON。<br>
 * 页面请求（无@ResponseBody的Controller）发生错误，输出错误页面。<br>
 * Controller中需要有专门处理异常的方法。
 *
 * */

public class MyExceptionHandler implements HandlerExceptionResolver {  
	
	protected static final Logger log = Logger.getLogger(MyExceptionHandler.class);
	   
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
        Object handler, Exception ex) {  
    	log.warn(ex);
    	ex.printStackTrace();
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("exception", ex);  
        model.put("time", DateUtil.getCurrentTime(DateUtil.DATE_TIME));  
        if(ex instanceof BusinessException) {  
        	 model.put("msg", "业务操作异常，若有必要请联系管理员！");  
//            return new ModelAndView("error/business", model);  
        }else if(ex instanceof DaoException) {  
        	 model.put("msg", "数据库操作异常，若有必要请联系管理员！");  
//            return new ModelAndView("error/dao", model);  
        }else {  
        	 model.put("msg", "未知错误，若有必要请联系管理员！");  
//            return new ModelAndView("error/error", model);  
        }  
        return new ModelAndView("error/error_all", model);  
    }  
}
