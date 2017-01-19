package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



import com.cn.hnust.dao.ClassInfoMapper;
import com.cn.hnust.dao.QueryAllTaskDao;
import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.service.ClassInfoService;

@Service("ClassInfoService")
public class ClassInfoServiceImp implements ClassInfoService {
	
	@Resource  
	private  ClassInfoMapper classInfoMapper;

	@Override
	public ArrayList<ClassInfo> selectByall() {
		// TODO Auto-generated method stub	
	
		return classInfoMapper.selectByall();
	}

}
