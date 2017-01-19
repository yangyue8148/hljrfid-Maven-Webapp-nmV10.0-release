package com.cn.hnust.timeservice;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.service.IQuerydevnoService;

public class MakeTask extends QuartzJobBean {
	 /** Logger */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MakeTask.class);
      /*
     * 生成任务单
     */
    static int n = 0 ;
    
    public void makelisttask()
    {
    	
    	logger.debug(String.valueOf(n));
    	System.out.println("****************");
    }
    
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
}
