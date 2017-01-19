package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.brandInfo;

public interface BrandInfoService {
	 ArrayList<brandInfo> selectByPrimaryKey(String Brandtype);
}
