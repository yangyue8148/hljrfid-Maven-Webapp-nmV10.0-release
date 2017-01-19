package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User;

public interface IUserDao {
    int insert(User record);

    int insertSelective(User record);

	//User selectByPrimaryKey(String username,String password );
	
	 User selectByPrimaryKey(@Param(value="usercode") String usercode,@Param(value="password") String password );
	 
	 User queryflagbyoperator(@Param(value="usercode") String usercode);
     
	 
	 ArrayList<User> queryoperatorList() ;

	
}