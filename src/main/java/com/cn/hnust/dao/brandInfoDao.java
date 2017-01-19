package com.cn.hnust.dao;

import java.util.ArrayList;

import com.cn.hnust.pojo.brandInfo;

public interface brandInfoDao {
    int deleteByPrimaryKey(String brandId);

    int insert(brandInfo record);

    int insertSelective(brandInfo record);

    ArrayList<brandInfo> selectByPrimaryKey(String Brand_type);

    int updateByPrimaryKeySelective(brandInfo record);

    int updateByPrimaryKey(brandInfo record);
}