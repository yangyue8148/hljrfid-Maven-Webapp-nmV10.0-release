package com.cn.hnust.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.hnust.tool.ResultUtils;

import javax.annotation.Resource;              
import javax.servlet.http.HttpServletRequest;  
                                               





import javax.servlet.http.HttpServletResponse;







import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;           
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;  
import javax.ws.rs.PUT;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.sun.mail.iap.Response;

                                               
@Controller                                    
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class UserController {    
	private Map<String, Object> jsonResult;
    @Resource                                  
    private IUserService userService; 
    @SuppressWarnings("null")
 	@RequestMapping("/showUser")
     public String toindex(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{  
    	 Map map = new HashMap();
         String password = request.getParameter("password");
         String operator_id = request.getParameter("usercode");
         String signflag = request.getParameter("signflag");
         System.out.println("signflag"+signflag);
         System.out.println(password);
         System.out.println(operator_id);
         User user = this.userService.getUserById(password, operator_id);             
         if(user != null)
         {
             System.out.println(user.getUserName());            
             map.put("username", user.getUserName());
             map.put("status", true);              
             DateFormat df = new SimpleDateFormat("yyyyMMdd"); // 如果需要小时、分钟和秒则用字符串"yyyy-MM-dd HH:mm:ss"
             DateFormat tf = new SimpleDateFormat("HH:mm:ss");
             Date date = new Date() ;    
             String signindate = df.format(date).substring(0,8); 
             String signtime = tf.format(date);         
            //签到      
            if(signflag !=null && signflag.equals("1")==true)
            {   
            	  //校验是否重复签到
                    int retflag  = this.userService.querySign(operator_id,signindate);
	                if(retflag == 1)
	                {
	             	   map.put("status", true); 
	             	   map.put("msg", "已签到过!");	             	   
	             	   map.put("signstatus", "02");
	                }else {
	                	int returnflag = this.userService.insertSign(operator_id, signindate, signtime);	   
	                    System.out.println("++++++++++++++++++++++++++"+returnflag);
	                    if(returnflag ==1)
	                    { 
	                    	map.put("status", true);
	                    	map.put("msg", "签到成功");
	                    	map.put("signstatus", "01");
	                    }
	                    else {
	                    	map.put("status", false);
	                    	map.put("msg", "签到失败");
	                    	map.put("signstatus", "03");	                    	
						}	                   	                 
					}
             }
         }
         else {
        	 map.put("status", false);  
        	 map.put("msg", "用户名或密码错");
        	 map.put("signstatus", "04");
        	 }
             setJsonResult(map);
             System.out.println(jsonResult.toString());
             ResultUtils.toJson(request,resp, this.jsonResult);
         
            //model.addAttribute("user", user);     
           
         return "showUser";    
 }
    
    
       public void setJsonResult(Map<String, Object> jsonResult) {    	   
    	     this.jsonResult = jsonResult;
    	   }
    
}
