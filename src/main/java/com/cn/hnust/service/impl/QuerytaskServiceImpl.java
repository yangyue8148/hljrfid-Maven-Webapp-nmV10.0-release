package com.cn.hnust.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.dao.TaskInfoMapper;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.dao.IQuerytaskDao;

@Service("querytaskService")
public class QuerytaskServiceImpl implements IQuerytaskService{

	@Resource  
	private IQuerytaskDao IQuerytaskDao ;	
	
	@Resource
	private TaskInfoMapper taskinfoDao ;
	 
	
	@Override
	public List<Querytask> getQuerylistById(String username ){
		// TODO Auto-generated method stub
		System.out.println(username);
		System.out.println("*******************1");
		System.out.println("QuerytaskServiceImpl.getQuerylistById()");
		return this.IQuerytaskDao.selectByusername(username);  
		
	}

	@Override
	public Querytask getQueryitemByoperid(Map<String, Object> map){
		// TODO Auto-generated method stub
		System.out.println(map.get("operator_id"));
		System.out.println("*******************1");
		System.out.println("QuerytaskServiceImpl.getQueryitemByoperid()");		
		System.out.println(map.get("operaotor_id"));
		System.out.println(map.get("date_time"));
		System.out.println(map.get("class_id"));		
		return this.IQuerytaskDao.getQueryitemByoperid(map);  		
	}
	
	
	@Override
	public Querytask QueryTaskStatus(Map<String, Object> map)
	{
		
		return this.IQuerytaskDao.QueryTaskStatus(map);  	
	}
	
	@Override
	public int updatetask(TaskInfo record){
		
		System.out.println("*********************task_id="+record.getTaskId());
		System.out.println("*********************operator_id"+record.getOperatorFirst());
	
		return this.taskinfoDao.UpdateTaskRecord(record);  
		
	}
	
	@Override
	public int updatetaskstatu(String task_id){
		
		System.out.println("*********************task_id="+task_id);	
		return this.IQuerytaskDao.updatetaskstatus(task_id);  
		
	}
	
	@Override
	public List<Querytask> QueryTaskAll(String  CurrentMonth)
	{
		return this.IQuerytaskDao.QueryTaskAll(CurrentMonth);
	}
	
	


	

}
