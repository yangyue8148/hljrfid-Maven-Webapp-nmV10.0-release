package com.cn.hnust.dao;

import com.cn.hnust.pojo.EquipType;

public interface EquipTypeMapper {
    int deleteByPrimaryKey(String typeId);

    int insert(EquipType record);

    int insertSelective(EquipType record);

    EquipType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(EquipType record);

    int updateByPrimaryKey(EquipType record);
}