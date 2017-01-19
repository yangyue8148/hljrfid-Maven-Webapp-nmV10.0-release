package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.ModelInfo;

public interface ModelInfoService {
	ArrayList<ModelInfo> selectByPrimaryKey(String modelBrand);
}
