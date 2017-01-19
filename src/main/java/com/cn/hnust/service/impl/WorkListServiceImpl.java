package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IQuerytaskDao;
import com.cn.hnust.dao.QueryEquipCountDao;
import com.cn.hnust.dao.SavedevinfoDao;
import com.cn.hnust.dao.WorkListinfoDao;
import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.Savedevinfo;
import com.cn.hnust.pojo.WorkList_Info;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.SavedevinfoService;
import com.cn.hnust.service.WorkListService;
@Service("WorkListService")
public class WorkListServiceImpl  implements WorkListService {
 
	@Resource  
	private WorkListinfoDao WorkListDao ;	


	
	
	@Override
	public int querypasmid(String pasm_id,String state)
	{
		return WorkListDao.queryworklist(pasm_id,state);
	}
	@Override
	public int insertworklist(String pasm_id,String gen_date,String gen_person,String strTime,String task_id,String picNum,String userDepartment)
	{
		return WorkListDao.insertworklist( pasm_id, gen_date,gen_person,"02",strTime,task_id,picNum,userDepartment);
		
	}
	@Override
	public ArrayList<WorkList_Info> queryWorkOrder(String wflow_satus)
	{
		return WorkListDao.queryWorkOrder(wflow_satus);
	}
	
}
