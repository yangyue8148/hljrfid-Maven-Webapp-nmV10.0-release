package com.cn.hnust.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.ResultUtils;

import javax.annotation.Resource;              
import javax.servlet.http.HttpServletRequest;  
                                               





import javax.servlet.http.HttpServletResponse;








import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;           
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;  

import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.sun.mail.iap.Response;

                                               
@Controller                                    
//@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class QuerytaskController {    
	private Map<String, Object> jsonResult;
    @Resource                                  
    private IQuerytaskService querytaskService;          
                                               
    @SuppressWarnings("null")
	@RequestMapping(value = "/user/querytask")               
    public String taskid(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{ 
    	
    	String usercode = request.getParameter("usercode");
    	String Class_id = null;
    	String class_id = null ;
    	String CurrentMonth = null;

 
    	//List<Querytask> querytasklist = this.querytaskService.getQuerylistById(usercode);  
    	Date d = new Date() ;
    	CurrentMonth = DateUtils.GetCurrentMonth(d);
    	List<Querytask> querytasklist = this.querytaskService.QueryTaskAll(CurrentMonth);      	
    	List<Querytask> list = new ArrayList<Querytask>();
    	 Map map = new HashMap();
    	for(int n = 0 ; n < querytasklist.size() ; n++)
    	{ 
    		
//    		try {
//    			 class_id = querytasklist.get(n).getBanCi() ;
//			} catch (NumberFormatException e) {
//				System.out.println("*************88");
//				class_id="10";
//				// TODO: handle exception
//			}finally
//			{
//				System.out.println("finally");
//			}
//    		System.err.println(class_id);
    	    class_id = querytasklist.get(n).getBanCi() ;
    		if(class_id==null)
    		{	
    			class_id="10";
    			System.out.println(class_id);
    		}
    		
    	
    		switch (Integer.valueOf(class_id)) {
    		case 0:
    		case 1:    		
    		case 2:
    		case 3:
    		case 4:
    			Class_id="白班";
    			break;
    		case 5:
    		case 6:
    		case 7:
    		case 8:
    			Class_id="晚班";
    			break ;
    		case 10:
    			Class_id="--";
    		default:    		
    			break;
    		}      
    		String task_state = querytasklist.get(n).getStatus() ;
    		System.out.println("task_state="+task_state);
    		switch (task_state) {
    		case "0":
    			task_state="未执行";
    			break;
    		case "1":
    			task_state="执行中";
    			break ;
    		case "2":
    			task_state="已执行";
    			break ;
    		default:
    			break;
    		}      
    		
    		
    		querytasklist.get(n).setClass_id(Class_id);
    		querytasklist.get(n).setStatus(task_state);
        	System.out.println("*******1111");
	        
	        list.add(querytasklist.get(n));     
    	}
    	map.put("result", "true");  
    	map.put("data", list); 
        setJsonResult(map);
        System.out.println(jsonResult.toString());
        ResultUtils.toJson(request,resp, this.jsonResult);            
        return "showUser";    
}
    
       public void setJsonResult(Map<String, Object> jsonResult) {    	   
    	     this.jsonResult = jsonResult;
    	   }    
}
