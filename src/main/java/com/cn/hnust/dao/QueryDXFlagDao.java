package com.cn.hnust.dao;

import org.apache.ibatis.annotations.Param;

public interface QueryDXFlagDao {

	String queryFlag(@Param(value = "number") String number,
			@Param(value = "time") String time);
	
	void saveFlag(@Param(value = "Tel_no") String Tel_no,
			@Param(value = "Send_time") String Send_time,
			@Param(value = "Send_flag") String Send_flag);

}
