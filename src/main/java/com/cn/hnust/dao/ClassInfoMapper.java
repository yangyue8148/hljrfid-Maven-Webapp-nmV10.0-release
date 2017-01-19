package com.cn.hnust.dao;

import java.awt.List;
import java.util.ArrayList;

import com.cn.hnust.pojo.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(String classid);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(String classid);
    
    ArrayList<ClassInfo> selectByall();

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}