package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.MessageDao;
import com.cn.hnust.pojo.Message;
import com.cn.hnust.service.MessageService;

@Service("MessageService")
public class MessageServiceImp implements MessageService {
	
	@Resource  
	private  MessageDao messageDao;

	@Override
	public  Message getMessage(int i) {
		return this.messageDao.getMessage(i);
	}

	

}
