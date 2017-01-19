package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TypeInfoDao;
import com.cn.hnust.pojo.TypeInfo;
import com.cn.hnust.service.TypeInfoService;

@Service("TypeInfoService")
public class TypeInfoServiceImpl implements TypeInfoService {

	@Resource
	private TypeInfoDao typeInfoDao;

	@Override
	public ArrayList<TypeInfo> selectByPrimaryKey() {
		// TODO Auto-generated method stub
		return this.typeInfoDao.selectByPrimaryKey();
	}
	
}
