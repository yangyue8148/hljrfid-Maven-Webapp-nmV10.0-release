package com.cn.hnust.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;

public interface QueryEquipCountDao {
  
	 int TotalEquipCount();
	 
	 int selectIsExeFlag(Map<String, Object>map) ;
	 
	
	         


	
}