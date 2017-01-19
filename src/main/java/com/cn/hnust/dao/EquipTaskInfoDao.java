package com.cn.hnust.dao;

import java.util.ArrayList;
import java.util.Map;

import com.cn.hnust.pojo.EquipInfo;

public interface EquipTaskInfoDao {
   
   
   ArrayList<EquipInfo> getAllNoCheck(Map<String, String> map_exestatusMap);
}