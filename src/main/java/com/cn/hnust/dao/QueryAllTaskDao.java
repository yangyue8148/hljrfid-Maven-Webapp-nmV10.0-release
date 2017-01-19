package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.TaskInfo;


public interface QueryAllTaskDao {   
	
	ArrayList<TaskInfo> queryAllTask(@Param(value = "yesterday") String yesterday,@Param(value = "today")String today);
	
}

