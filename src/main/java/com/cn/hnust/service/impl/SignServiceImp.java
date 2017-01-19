package com.cn.hnust.service.impl;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TaskInfoMapper;
import com.cn.hnust.dao.signDao;
import com.cn.hnust.pojo.Sign;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.service.SignService;
import com.cn.hnust.service.TaskInfoService;
@Service("SignService")
public class SignServiceImp implements SignService {
	
	@Resource
	private signDao signDao ;
	
	
	public ArrayList<Sign> querySignListBydate(String date)
	{
		return this.signDao.querySignListBydate(date);
	}
}
