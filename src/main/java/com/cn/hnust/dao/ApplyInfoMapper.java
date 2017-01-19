package com.cn.hnust.dao;

import java.util.ArrayList;

import com.cn.hnust.pojo.ApplyInfo;

public interface ApplyInfoMapper {
    int insert(ApplyInfo record);

    int insertSelective(ApplyInfo record);
    
    ArrayList<ApplyInfo> selectByPrimaryKey(String equipId);
}