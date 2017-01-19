package com.cn.hnust.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;

public interface IQuerytaskService {
	public List<Querytask> getQuerylistById(String username );  	
	public Querytask getQueryitemByoperid(Map<String, Object> map);
	public List<Querytask> QueryTaskAll(String  CurrentMonth);
	public int updatetask(TaskInfo record);	
	public Querytask QueryTaskStatus(Map<String, Object> map) ;	
	public int updatetaskstatu(String task_id);
	
}
