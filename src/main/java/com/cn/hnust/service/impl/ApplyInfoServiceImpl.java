package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ApplyInfoMapper;
import com.cn.hnust.pojo.ApplyInfo;
import com.cn.hnust.service.ApplyInfoService;

@Service("ApplyInfoService")
public class ApplyInfoServiceImpl implements ApplyInfoService {
	@Resource
	private ApplyInfoMapper applyInfoDao;

	@Override
	public ArrayList<ApplyInfo> selectByPrimaryKey(String equipid) {
		return this.applyInfoDao.selectByPrimaryKey(equipid);
	}

}
