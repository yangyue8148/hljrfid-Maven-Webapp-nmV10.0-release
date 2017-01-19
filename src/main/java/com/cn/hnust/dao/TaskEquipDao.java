package com.cn.hnust.dao;

import com.cn.hnust.pojo.TaskEquip;

public interface TaskEquipDao {
    TaskEquip selectTaskError(String classId,String insTask);
}