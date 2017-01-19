package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ModelInfoDao;
import com.cn.hnust.pojo.ModelInfo;
import com.cn.hnust.service.ModelInfoService;
@Service("ModelInfoService")
public class ModelInfoServiceImpl implements ModelInfoService {

	@Resource
	private ModelInfoDao modelInfoDao;

	@Override
	public ArrayList<ModelInfo> selectByPrimaryKey(String modelBrand) {
		return this.modelInfoDao.selectByPrimaryKey(modelBrand);
	}

}
