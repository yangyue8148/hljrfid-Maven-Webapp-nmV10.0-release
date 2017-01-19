package com.cn.hnust.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.Term_Info;
import com.cn.hnust.service.ValiDevSnService;
import com.cn.hnust.tool.ResultUtils;

                                               
@Controller                                    
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class ValidataController {    
	private Map<String, Object> jsonResult;
    @Resource                                  
    private ValiDevSnService valiDevSnService; 
    @SuppressWarnings("null")
 	@RequestMapping("/IValidata")
     public String toindex(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{  
    	 Map map = new HashMap();
         String deviceSn = request.getParameter("deviceSn");
         Term_Info terminfo = this.valiDevSnService.QuereySn(deviceSn);             
         if(terminfo != null)
         {           
             map.put("status", true); 
         }
         else 
         {
        	 map.put("status", false);  		
    	 }
         setJsonResult(map);
         System.out.println(jsonResult.toString());
         ResultUtils.toJson(request,resp, this.jsonResult);           
         return "showUser";    
 }
   public void setJsonResult(Map<String, Object> jsonResult) {    	   
	     this.jsonResult = jsonResult;
	   }
    
}
