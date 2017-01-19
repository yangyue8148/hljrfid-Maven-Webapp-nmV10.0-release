package com.cn.hnust.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SavedevinfoDao {

	// int insertsavetask(@Param(value="task_id") String
	// task_id,@Param(value="devicecode") String
	// devicecode,@Param(value="datetime") String datetime
	// ,@Param(value="fileName") String fileName,@Param(value="rdnflag") String
	// rdnflag,@Param(value="banci") String banci,@Param(value="operator_id")
	// String operator_id,@Param(value="strTime") String strTime
	// ,@Param(value="b") byte[] b);
	int insertsavetask(@Param(value = "task_id") String task_id,
			@Param(value = "devicecode") String devicecode,
			@Param(value = "datetime") String datetime,
			@Param(value = "fileName") String fileName,
			@Param(value = "rdnflag") String rdnflag,
			@Param(value = "banci") String banci,
			@Param(value = "operator_id") String operator_id,
			@Param(value = "strTime") String strTime,
			@Param(value = "picNum") String picNum);

	// int insertsavetask(@Param(value="task_id") String
	// task_id,@Param(value="devicecode") String
	// devicecode,@Param(value="datetime") String datetime
	// ,@Param(value="fileName") String fileName,@Param(value="rdnflag") String
	// rdnflag,@Param(value="banci") String banci,@Param(value="operator_id")
	// String operator_id,@Param(value="operator_second") String
	// operator_second,@Param(value="strTime") String strTime );

	int updateTask(@Param(value = "task_id") String task_id,
			@Param(value = "devicecode") String devicecode,
			@Param(value = "datetime") String datetime,
			@Param(value = "fileName") String fileName,
			@Param(value = "rdnflag") String rdnflag,
			@Param(value = "banci") String banci,
			@Param(value = "operator_id") String operator_id,
			@Param(value = "strTime") String strTime,
			@Param(value = "picNum") String picNum);

	byte[] selectimage(@Param(value = "devicecode") String devicecode);

	int selectByOperatorTime(Map<String, Object> map);
}