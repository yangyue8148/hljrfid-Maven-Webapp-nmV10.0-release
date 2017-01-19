package com.cn.hnust.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;

public interface QueryMachinenameDao {
	
	 String  QueryMachinenane(@Param(value="Espec_id") String devcode);	         
}