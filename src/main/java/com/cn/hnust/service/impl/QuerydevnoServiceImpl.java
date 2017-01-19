package com.cn.hnust.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.Trimspec;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IQuerydevnoDao;
import com.cn.hnust.dao.IUserDao;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IQuerydevnoService;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.dao.IQuerytaskDao;

@Service("QuerydevnoService")
public class QuerydevnoServiceImpl implements IQuerydevnoService{

	@Resource  
	private IQuerydevnoDao IQuerydevnoDao ;		 
	
	
	
	@Override
	public Querydevno getQueryById(String username ){
		// TODO Auto-generated method stub
		
		System.out.println("*******************2");
		System.out.println(username);
		System.out.println("QuerydevnoServiceImpl.getQueryById()");
		return this.IQuerydevnoDao.selectByusername(username.trim());  
		
	}

}
