package com.cn.hnust.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Term_Info;

public interface TermInfoDao {
   public Term_Info querybysn(@Param(value="Term_no") String devicesn);   
}
