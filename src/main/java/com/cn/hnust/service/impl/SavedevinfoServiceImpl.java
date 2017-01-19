package com.cn.hnust.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.SavedevinfoDao;
import com.cn.hnust.service.SavedevinfoService;
@Service("savedevinfoSerive")
public class SavedevinfoServiceImpl  implements SavedevinfoService{
 
	@Resource  
	private SavedevinfoDao SavedevinfoDao ;	

	@Override
//	public int insertsavetask(String task_id,String devicecode,String datetime,String fileName,String rdnflag,String banci,String operator_id,String strTime,byte[] b)
	public int insertsavetask(String task_id,String devicecode,String datetime,String fileName,String rdnflag,String banci,String operator_id,String strTime,String picnum)
	{
		return this.SavedevinfoDao.insertsavetask( task_id, devicecode, datetime,fileName, rdnflag,banci,operator_id,strTime,picnum);  
		
	}
	public int updateTask(String task_id,String devicecode,String datetime,String fileName,String rdnflag,String banci,String operator_id,String strTime,String picnum)
	{
		return this.SavedevinfoDao.updateTask( task_id, devicecode, datetime,fileName, rdnflag,banci,operator_id,strTime,picnum);  
		
	}
	
	
	
	@Override
    public byte[] getBit(String devicecode) 
	{
		return SavedevinfoDao.selectimage(devicecode);
	}
	
	@Override
	public int getExeeuquipCount(Map<String, Object> map ){
		// TODO Auto-generated method stub
		
		System.out.println("*******************2");
	
		System.out.println("QuerydevnoServiceImpl.getQueryById()");
		return this.SavedevinfoDao.selectByOperatorTime(map);  
		
	}
}
