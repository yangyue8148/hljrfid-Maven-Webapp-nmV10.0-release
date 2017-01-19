package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Sign;

public interface signDao {
	int insertSigninout(@Param(value="custom_num") String usercode ,@Param(value="signin_date")  String signindate,@Param(value="signin_time") String signtime) ;
    int querySigninout(@Param(value="custom_num")  String usercode ,@Param(value="signin_date") String signindate) ;
    
    ArrayList<Sign> querySignListBydate(@Param(value="signin_date") String date);
}
