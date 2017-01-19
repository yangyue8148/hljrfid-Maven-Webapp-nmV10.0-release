package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Telnum;


public interface TelnumDao {   
	
	 ArrayList<Telnum> QueryTelnum(@Param(value="contact_type") String contact_type);
	
}

