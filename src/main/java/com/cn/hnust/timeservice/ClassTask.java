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

public class ClassTask extends QuartzJobBean {
	 /** Logger */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClassTask.class);
    @Resource                                  
    private IQuerydevnoService querydevnoService;   
    /**
     * 业务逻辑处理
     */
    public void doBiz() {
    	System.out.println("************************");
    	 String devno = "00000030";    	 
    	 logger.debug(devno);
    	 Querydevno querydevno = this.querydevnoService.getQueryById(devno);       		
    	 if(querydevno != null){ 
    		 System.out.println(querydevno.getEquip_name());     
    	 }   		
    		 
  // 执行业务逻辑
  // ........
    }

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
}
