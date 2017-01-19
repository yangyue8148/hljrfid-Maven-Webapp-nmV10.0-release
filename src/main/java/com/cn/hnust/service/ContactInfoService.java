package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.ContactInfo;

public interface ContactInfoService {
	 ArrayList<ContactInfo> getContact (String userDepartment,String notContactType);
}
