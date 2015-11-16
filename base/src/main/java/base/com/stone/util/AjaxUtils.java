package com.stone.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
 
public class AjaxUtils {
 
    public static void rendText(HttpServletResponse response, String content)  
        throws IOException {  
//        response.setCharacterEncoding("UTF-8");  
        response.getWriter().write(content);  
    }    
       
    public static void rendJson(HttpServletResponse response, boolean success,
         String message) throws IOException{  
        JSONObject json = new JSONObject();  
        json.put("isSuccess", success);  
        json.put("message", message);  
        rendText(response, json.toString());  
    }     
}