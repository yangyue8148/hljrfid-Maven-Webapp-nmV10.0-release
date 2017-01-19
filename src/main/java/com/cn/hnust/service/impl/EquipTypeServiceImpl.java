package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.EquipTypeMapper;
import com.cn.hnust.dao.brandInfoDao;
import com.cn.hnust.pojo.EquipType;
import com.cn.hnust.pojo.brandInfo;
import com.cn.hnust.service.BrandInfoService;
import com.cn.hnust.service.EquipTypeService;
@Service("EquipTypeService")
public class EquipTypeServiceImpl implements EquipTypeService {
	@Resource
	private  EquipTypeMapper EquipTypeDao;

	@Override
	public EquipType selectByPrimaryKey(String EquiType) {
		return this.EquipTypeDao.selectByPrimaryKey(EquiType);
	}

}
