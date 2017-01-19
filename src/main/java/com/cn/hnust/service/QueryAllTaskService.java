package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;



public interface QueryAllTaskService {	
	public  ArrayList<TaskInfo>  queryAllTask(String yesterday,String today );	
	
}



