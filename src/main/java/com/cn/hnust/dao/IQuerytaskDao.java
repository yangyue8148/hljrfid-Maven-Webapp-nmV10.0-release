package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.pojo.User;

public interface IQuerytaskDao {
   

	//User selectByPrimaryKey(String username,String password );
	
	 List<Querytask> selectByusername(@Param(value="username") String username);

	 Querytask selectByOperator(@Param(value="operaotor_id") String operaotor_id , @Param(value ="datetime") String datetime );
  
	 
	 Querytask getQueryitemByoperid(Map<String, Object>map);
	 
	 Querytask QueryTaskStatus(Map<String, Object> map) ;
	 
	 int updatetaskstatus(@Param(value="task_id") String task_id);
	 
	 List<Querytask> QueryTaskAll(@Param(value="Year_month") String CurrentMonth);
	 
	 
	 
}