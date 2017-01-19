package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.User;

public interface IQuerydevnoDao {
    Querydevno selectByusername(@Param(value="Equip_id") String Equip_id);
    int  selectByOperator(Map<String, Object> map);  
   
     
}