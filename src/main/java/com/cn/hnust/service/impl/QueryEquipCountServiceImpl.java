package com.cn.hnust.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IQuerytaskDao;
import com.cn.hnust.dao.QueryMachinenameDao;
import com.cn.hnust.dao.QueryEquipCountDao;
import com.cn.hnust.dao.SavedevinfoDao;
import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.Savedevinfo;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.QueryEquipCountService;
import com.cn.hnust.service.SavedevinfoService;
@Service("queryequipcountservice")
public class QueryEquipCountServiceImpl  implements QueryEquipCountService{

	@Resource  
	private QueryEquipCountDao queryEquipCountDao ;	
	 
	
	@Resource
	private QueryMachinenameDao QueryMachinenameDao ;
	
	@Override
	public int TotalEquipCount()
	{
		// TODO Auto-generated method stub
		
		
		return this.queryEquipCountDao.TotalEquipCount();  
		
	}
	
	
	@Override
	public int selectIsExeFlag(Map<String, Object>map) 
	{
		return this.queryEquipCountDao.selectIsExeFlag(map);
	}
	
	
	@Override
	public String QueryMachinenane(String devcode) 
	{
		
		
		return this.QueryMachinenameDao.QueryMachinenane(devcode);
	}
	
	
}
