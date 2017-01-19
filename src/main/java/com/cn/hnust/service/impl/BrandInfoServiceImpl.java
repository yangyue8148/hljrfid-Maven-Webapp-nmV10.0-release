package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.brandInfoDao;
import com.cn.hnust.pojo.brandInfo;
import com.cn.hnust.service.BrandInfoService;
@Service("BrandInfoService")
public class BrandInfoServiceImpl implements BrandInfoService {
	@Resource
	private brandInfoDao brandInfoDao;

	@Override
	public ArrayList<brandInfo> selectByPrimaryKey(String Brandtype) {
		return this.brandInfoDao.selectByPrimaryKey(Brandtype);
	}

}
