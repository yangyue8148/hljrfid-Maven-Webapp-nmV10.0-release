package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TaskEquipDao;
import com.cn.hnust.pojo.TaskEquip;
import com.cn.hnust.service.TaskEquipService;

@Service("TaskEquipService")
public class TaskEquipServiceImpl implements TaskEquipService {

	@Resource
	private TaskEquipDao taskEquipDao;

	@Override
	public  TaskEquip selectTaskError(String equipId,String insTask) {
		return this.taskEquipDao.selectTaskError(equipId,insTask);
	}

	

}
