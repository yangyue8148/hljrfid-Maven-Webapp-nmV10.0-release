package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.User;

public interface IUserService {
	public User getUserById(String password ,String username);
	
	public int querySign(String username, String signdate);
	
	public int  insertSign(String usercode, String signindate , String signtime ) ;
	
	public ArrayList<User> queryoperatorList();
	
	public User queryflagbyoperator(String username) ;
}
