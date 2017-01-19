package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.EquipInfoDao;
import com.cn.hnust.pojo.EquipInfo;
import com.cn.hnust.service.EquipInfoService;

@Service("EquipInfoService")
public class EquipInfoServiceImp implements EquipInfoService {
	
	@Resource  
	private  EquipInfoDao equipInfoDao;
	


	@Override
	public EquipInfo getDepart(String equipId) {
		return this.equipInfoDao.getDepart(equipId);
	}
   
	
	@Override
	public ArrayList<EquipInfo> getAllDevino() {
		return this.equipInfoDao.getAllDevino();
	}
	
	@Override
	public ArrayList<EquipInfo> getAllNoCheck(Map<String, String> map_exestatusMap)
	{
		return this.equipInfoDao.getAllNoCheck(map_exestatusMap);
	}


}
