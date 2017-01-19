package com.cn.hnust.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TermInfoDao;
import com.cn.hnust.pojo.Term_Info;
import com.cn.hnust.service.ValiDevSnService;

@Service("ValiDevSnService")
public class TermInfoServiceImpl implements ValiDevSnService {

	@Resource  
	private  TermInfoDao terminfodao;
	
	@Override
	public Term_Info QuereySn(String deviceSn){	
		
		return this.terminfodao.querybysn(deviceSn);  		
	}

}
 