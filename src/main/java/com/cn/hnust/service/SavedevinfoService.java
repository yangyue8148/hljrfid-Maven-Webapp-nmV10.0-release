package com.cn.hnust.service;

import java.util.Map;

public interface SavedevinfoService {
	// public int insertsavetask(String task_id,String devicecode,String
	// datetime,String fileName,String rdnflag,String banci,String
	// operator_id,String strTime,byte[] b);
	public int insertsavetask(String task_id, String devicecode,
			String datetime, String fileName, String rdnflag, String banci,
			String operator_id, String strTime, String picnum);

	// public int insertsavetask(String task_id,String devicecode,String
	// datetime,String fileName,String rdnflag,String banci,String
	// operator_id,String operator_second,String strTime);
	public int updateTask(String task_id, String devicecode, String datetime,
			String fileName, String rdnflag, String banci, String operator_id,
			String strTime, String picnum);

	public byte[] getBit(String devicecode);

	public int getExeeuquipCount(Map<String, Object> map);
}
