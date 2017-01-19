package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TelnumDao;
import com.cn.hnust.pojo.Telnum;
import com.cn.hnust.service.QueryTelNumService;

@Service("queryTelNumService")
public class TelNumServiceImpl implements QueryTelNumService {

	@Resource  
	private  TelnumDao telnumDao;	 
	
	@Override
	public  ArrayList<Telnum> getTelnum(String contact_type)
	{
		return this.telnumDao.QueryTelnum(contact_type);  	
	}

}
