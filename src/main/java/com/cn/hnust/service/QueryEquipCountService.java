package com.cn.hnust.service;

import java.util.List;
import java.util.Map;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;


public interface QueryEquipCountService {
	public int TotalEquipCount();  
	
	public int selectIsExeFlag(Map<String, Object>map) ;
	
	public String  QueryMachinenane(String devcode);
}
