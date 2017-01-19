package com.cn.hnust.dao;

import java.util.ArrayList;

import com.cn.hnust.pojo.TypeInfo;

public interface TypeInfoDao {
    int deleteByPrimaryKey(String typeId);

    int insert(TypeInfo record);

    int insertSelective(TypeInfo record);

    ArrayList<TypeInfo> selectByPrimaryKey();
   //  TypeInfo selectByPrimaryKey();

    int updateByPrimaryKeySelective(TypeInfo record);

    int updateByPrimaryKey(TypeInfo record);
}