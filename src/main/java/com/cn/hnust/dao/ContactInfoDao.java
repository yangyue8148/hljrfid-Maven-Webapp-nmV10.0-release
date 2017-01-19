package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.ContactInfo;

public interface ContactInfoDao {
   ArrayList<ContactInfo> getContact (@Param(value = "userDepartment") String userDepartment,@Param(value = "notContactType") String notContactType);
}