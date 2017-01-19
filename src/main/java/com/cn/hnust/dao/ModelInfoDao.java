package com.cn.hnust.dao;

import java.util.ArrayList;

import com.cn.hnust.pojo.ModelInfo;

public interface ModelInfoDao {
    int deleteByPrimaryKey(String modelId);

    int insert(ModelInfo record);

    int insertSelective(ModelInfo record);

    ArrayList<ModelInfo> selectByPrimaryKey(String modelBrand);

    int updateByPrimaryKeySelective(ModelInfo record);

    int updateByPrimaryKey(String modelId,String modelPic);
}