package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.ApplyInfo;
import com.cn.hnust.pojo.brandInfo;

public interface ApplyInfoService {
	 ArrayList<ApplyInfo> selectByPrimaryKey(String equipId);
}
