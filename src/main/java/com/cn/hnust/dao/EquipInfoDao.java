package com.cn.hnust.dao;

import java.util.ArrayList;
import java.util.Map;

import com.cn.hnust.pojo.EquipInfo;

public interface EquipInfoDao {
   EquipInfo getDepart(String equipId);
   
   ArrayList<EquipInfo> getAllDevino();
   
   ArrayList<EquipInfo> getAllNoCheck(Map<String, String> map_exestatusMap);
}