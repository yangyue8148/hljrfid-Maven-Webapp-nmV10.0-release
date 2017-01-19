package com.cn.hnust.timeservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cn.hnust.service.ContactInfoService;
import com.cn.hnust.service.WorkListService;
import com.cn.hnust.tool.SendMSGUtil;
import com.cn.hnust.pojo.ContactInfo;
import com.cn.hnust.pojo.WorkList_Info;

public class WorkOrderRemind extends QuartzJobBean {
	@Resource
	public WorkListService workListService ;	
	@Resource
	public ContactInfoService contactInfoService ;
	
	public ArrayList<WorkList_Info> worklist_info =  new ArrayList<WorkList_Info>();
	
	public static final String  NoAccepted  = "01" ;
	
	public static final String Unsolved = "02" ;
	
	public static final String MSG = "您有未处理的工单，请及时处理";
	
	public static final String notContactType = "3";  //给该科室下所有人发送短信	
	private ArrayList<ContactInfo> contacts = new ArrayList<>();	
//	private final org.apache.commons.logging.Log log = LogFactory.getLog(WorkOrderRemind.class.getName());
	public void unTreadWorkOrder() {			
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");	
		Date curDate = new Date(System.currentTimeMillis());
		String currentTime = formatter.format(curDate);
		String wflowsAllocationDate = null ;
		String wflowsAllocationTime = null ;
		String wflowsPsamId = null ;		
		String wflowsDepartment = null;
		System.out.println("设备有故障还没有处理！！！！");
		worklist_info = workListService.queryWorkOrder(NoAccepted);
		
		if(worklist_info.size() !=0)
		{
		
			for (WorkList_Info workinfo : worklist_info) {
				wflowsAllocationDate = workinfo.getWflowsAcceptDate() ;
				wflowsAllocationDate = workinfo.getWflowsAllocationTime();
				wflowsPsamId  = workinfo.getWflowsPsamId();
				wflowsDepartment = workinfo.getWflowsDepartment();	
				contacts = this.contactInfoService.getContact(wflowsDepartment,	notContactType);	
				String contactList = "";
				for (int i = 0; i < contacts.size(); i++) {
					// 不给处长发送短信
					if (contacts.get(i).getContact_Type() != "3") {
						if (i == contacts.size() - 1) {
							contactList += contacts.get(i).getContact_Tel();
						} else {
							contactList += contacts.get(i).getContact_Tel() + ",";
						}
					}
				}
				// 发送信息
				SendMSGUtil sm = new SendMSGUtil();
				sm.sendByHttp(contactList, MSG, String.valueOf(contacts.size()));	
			}
		}
	}
	
     public void unResolvedWorkOrder() {	    	
    	 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");	
		Date curDate = new Date(System.currentTimeMillis());
		String currentTime = formatter.format(curDate);
		String wflowsAllocationDate = null ;
		String wflowsAllocationTime = null ;
		String wflowsPsamId = null ;		
		String wflowsDepartment = null;
		System.out.println("设备有故障还没未解决！！！！");
		worklist_info = workListService.queryWorkOrder(Unsolved);		
		if(worklist_info.size() !=0)
		{
			for (WorkList_Info workinfo : worklist_info) {
				wflowsAllocationDate = workinfo.getWflowsAcceptDate() ;
				wflowsAllocationDate = workinfo.getWflowsAllocationTime();
				wflowsPsamId  = workinfo.getWflowsPsamId();
				wflowsDepartment = workinfo.getWflowsDepartment();	
				contacts = this.contactInfoService.getContact(wflowsDepartment,	notContactType);	
				String contactList = "";
				for (int i = 0; i < contacts.size(); i++) {
					// 不给处长发送短信
					if (contacts.get(i).getContact_Type() != "3") {
						if (i == contacts.size() - 1) {
							contactList += contacts.get(i).getContact_Tel();
						} else {
							contactList += contacts.get(i).getContact_Tel() + ",";
						}
					}
				}
				// 发送信息
				SendMSGUtil sm = new SendMSGUtil();
				sm.sendByHttp(contactList, MSG, String.valueOf(contacts.size()));	
			}
		}
	}
	

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}
