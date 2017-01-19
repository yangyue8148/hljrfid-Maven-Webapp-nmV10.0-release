package com.cn.hnust.timeservice;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.service.ClassInfoService;
import com.cn.hnust.service.IQuerydevnoService;
import com.cn.hnust.service.TaskInfoService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.NumberFormat;

public class ExpireJobTask extends QuartzJobBean {
	 /** Logger */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
    @Resource                                  
    private IQuerydevnoService querydevnoService;    
    @Resource
    private ClassInfoService classInfoService ;
    @Resource
    private TaskInfoService taskinfoservice ;
    
    Map<String, Object> map = new  HashMap<String, Object>();
    ArrayList<TaskInfo> TaskInfoList = new ArrayList<>();   
    
    String DateTime = null ;//当前的日期
    String datemonth = null;//当前的月份
    int  daytime ;    
    String classid=null;
    int IntDateTime ;
    String DateTime_tmp = null;
    String  NextTaskId = null ;   
    String dateTimeSecond = null;
    TaskInfo T = null;
    /**
     * 业务逻辑处理
     */
    public void doBiz() {
    	System.out.println("currtent threadid======================="+Thread.currentThread().getId());
    	/*
    	 * 获取当前系统最大的任务ID号
    	 */
    	String currenttaskId = this.taskinfoservice.GetMaxTaskId() ;    
    	/*
    	 * 获取班次信息
    	 */
    	ArrayList<ClassInfo> classlist = classInfoService.selectByall();    	
    	int CountClassid = classlist.size() ; 
    	 
    	Date date = new Date() ;    	 
    	//DateTime= DateUtils.getCurrentCnDateWithdate();    	
    	datemonth= DateUtils.getNextMonthDay().substring(0,6);    	
    	daytime = DateUtils.getNextCountDay(datemonth);//当月的天数
    	logger.debug("daytime+++++++++++++++++++++++++++++"+String.valueOf(daytime));
    	System.out.println(daytime);
        System.out.println("taksid="+currenttaskId);
    	logger.debug("currenttaskId++++++++++++++++++++"+currenttaskId);    
        for(int n = 0 ; n < daytime ;n++)
    	{          	
        	DateTime = DateUtils.getDateCurrentDay(n+1); //获取当前日期的第二天
    		for(int m =0 ; m<CountClassid ; m++)
    		{  			
    			 
    			TaskInfo taskinfo = new TaskInfo() ;
    			if(m==0 && n==0)
    			{
    				NextTaskId=NumberFormat.haoAddOne_2(currenttaskId);
    			}
    			else {
    				NextTaskId=NumberFormat.haoAddOne_2(NextTaskId);
				}
	    		taskinfo.setTaskId(NextTaskId);
	    		taskinfo.setYearMonth(datemonth);
	    		if(m>4)
	    		{
	    			IntDateTime = Integer.valueOf(DateTime)+1 ;
	        		DateTime_tmp = String.valueOf(IntDateTime);
	        		taskinfo.setDate(DateTime_tmp);	        		
	        		dateTimeSecond = DateTime_tmp ;
	    		}
	    		else {
	    			taskinfo.setDate(DateTime);
	    			dateTimeSecond = DateTime ;
				}
	    		//未巡检状态
	    		taskinfo.setStatus("0");	    	
	    		classid = "0"+String.valueOf(m+1);
	    		taskinfo.setClassId(classid);
	    		TaskInfoList.add(taskinfo);
	    	    T = taskinfoservice.selectByOperatorClass(dateTimeSecond, classid);
	    		if(T==null)
	    		{	
	    		    System.out.println("dateTimeSeoncd ++++++++++++++"+Integer.valueOf(dateTimeSecond));
	    		    System.out.println("daytime++++++++++++++++++++++"+Integer.valueOf(daytime));
	    			if(Integer.valueOf(dateTimeSecond.substring(6, 8)) <= Integer.valueOf(daytime))
		    		{
		    			taskinfoservice.InsertTaskidList(taskinfo);
		    		}
	    		}
	    		else {
	    			
				}	
    		}     
    		logger.error(String.valueOf(n));
    		IntDateTime = Integer.valueOf(DateTime)+1 ;
    		DateTime = String.valueOf(IntDateTime);
    	}    
    }

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
}
