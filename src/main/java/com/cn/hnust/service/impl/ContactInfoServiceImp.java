package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.ContactInfoDao;
import com.cn.hnust.pojo.ContactInfo;
import com.cn.hnust.service.ContactInfoService;

@Service("ContactInfoService")
public class ContactInfoServiceImp implements ContactInfoService {
	
	@Resource  
	private  ContactInfoDao contactInfoDao;

	@Override
	public ArrayList<ContactInfo> getContact(String userDepartment,String notContactType) {
		return this.contactInfoDao.getContact(userDepartment,notContactType);
	}


}
