package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.QueryAllTaskDao;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.service.QueryAllTaskService;

@Service("QueryAllTaskService")
public class QueryAllTaskServiceImpl implements QueryAllTaskService {

	@Resource  
	private  QueryAllTaskDao queryAllTaskDao;

	@Override
	public ArrayList<TaskInfo> queryAllTask(String yesterday,String today) {
		
		return this.queryAllTaskDao.queryAllTask(yesterday,today);
	}	 

}
