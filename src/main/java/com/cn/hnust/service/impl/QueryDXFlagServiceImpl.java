package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.QueryAllTaskDao;
import com.cn.hnust.dao.QueryDXFlagDao;
import com.cn.hnust.service.QueryAllTaskService;
import com.cn.hnust.service.QueryDXFlagService;

@Service("QueryDXFlagService")
public class QueryDXFlagServiceImpl implements QueryDXFlagService {

	@Resource  
	private  QueryDXFlagDao queryDXFlagDao;

	@Override
	public String queryFlag(String number, String time) {
		return this.queryDXFlagDao.queryFlag(number, time);
	}

	@Override
	public void saveFlag(String Tel_no, String Send_time,String Send_flag) {
		this.queryDXFlagDao.saveFlag(Tel_no,Send_time,Send_flag);
	}



}
