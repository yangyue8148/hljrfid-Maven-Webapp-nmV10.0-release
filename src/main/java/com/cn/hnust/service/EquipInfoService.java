package com.cn.hnust.service;

import java.util.ArrayList;
import java.util.Map;

import com.cn.hnust.pojo.EquipInfo;

public interface EquipInfoService {
	EquipInfo getDepart(String equipId);
	ArrayList<EquipInfo> getAllDevino();
	
	ArrayList<EquipInfo> getAllNoCheck(Map<String, String> map_exestatusMap);
	
	
}
