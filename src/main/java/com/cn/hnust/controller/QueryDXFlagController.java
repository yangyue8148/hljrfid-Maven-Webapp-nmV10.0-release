package com.cn.hnust.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.service.QueryAllTaskService;
import com.cn.hnust.service.QueryDXFlagService;
import com.cn.hnust.tool.ResultUtils;

@Controller                                    
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class QueryDXFlagController {

	
	@Resource                                  
    private QueryDXFlagService queryDXFlagService;          
                                               
    @SuppressWarnings("null")
	@RequestMapping(value="/isSend")               
    public String selectFlag(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{
    	
    	String number = request.getParameter("Tel_no");
    	String time = request.getParameter("Send_time");
    	String thing = request.getParameter("Do");
		if (thing.equals("select")) {
			String flag = this.queryDXFlagService.queryFlag(number,time);
	    	
	    	HashMap<String, String> hm = new HashMap<>();
	    	if(flag==null||"".equals(flag)){
	    		flag = "1";
	    	}
	    	hm.put("flag", flag);
	    	System.out.println(hm);
	    	ResultUtils.toJson(request, resp, hm);
			return "showUser";
		}
		
		if (thing.equals("save")) {
			
			String send_flag = request.getParameter("Send_flag");
			
			System.out.println("保存处长");
			this.queryDXFlagService.saveFlag(number, time, send_flag);
			return "showUser";
		}
		return "showUser";
    	
    	
    }
}
