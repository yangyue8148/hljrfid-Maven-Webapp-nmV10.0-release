package com.cn.hnust.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.service.QueryAllTaskService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.ResultUtils;
@Controller                                    
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class QueryAllTaskController {	
	@Resource                                  
    private QueryAllTaskService queryAllTaskService;  
    @SuppressWarnings("null")
	@RequestMapping(value="/alltask")               
    public String allTask(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		Date befordate = DateUtils.getNextDay(curDate);		
		String today = formatter.format(curDate);
		String yesterday = formatter.format(befordate); 
		ArrayList<TaskInfo> querytasList = new ArrayList<TaskInfo>();
		querytasList = this.queryAllTaskService.queryAllTask(yesterday,today);
    	HashMap<String, String> hm = new HashMap<>();
    	int over = 0;
    	int never= 0;
    	for (int i = 0; i < querytasList.size(); i++) {
    		if(querytasList.get(i).getDate().equals(yesterday) && Integer.valueOf(querytasList.get(i).getClassId())<6 )
    		{
    			if(querytasList.get(i).getStatus().equals("02"))
    			{
    				over++ ;
    			}
    			else {
					never++;
				}    			
    		}
    		else if(querytasList.get(i).getDate().equals(today) && Integer.valueOf(querytasList.get(i).getClassId())>5 )
    		{
    			if(querytasList.get(i).getStatus().equals("02"))
    			{
    				over++ ;
    			}
    			else {
					never++;
				}
    		}
    		else
    		{
    			
    		}
		}  
    	System.out.println("over   "+over);
    	System.out.println("never   "+never);
    	hm.put("over", String.valueOf(over));
    	hm.put("never", String.valueOf(never));
    	System.out.println(hm);
    	ResultUtils.toJson(request, resp, hm);
		return "showUser";    	
    }
}
