package com.cn.hnust.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.dao.signDao;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource  
	private IUserDao userDao;
	
	@Resource
	private signDao signDao ;
	 
	//public User getUserById(int userId)
	@Override
	public User getUserById(String password ,String username){
		// TODO Auto-generated method stub
		System.out.println(username);
		return this.userDao.selectByPrimaryKey(username,password);  		
	}	
	@Override
	public int querySign(String usercode, String signindate )
	{
		 return this.signDao.querySigninout(usercode ,signindate) ;
	}
	
  public int  insertSign(String usercode, String signindate , String signtime ) 
  {
	  return this.signDao.insertSigninout(usercode ,signindate,signtime) ;
	  
  }
	@Override
	public User queryflagbyoperator(String username){
	// TODO Auto-generated method stub
		System.out.println(username);
		return this.userDao.queryflagbyoperator(username);  		
	}
  
  @Override
  public ArrayList<User> queryoperatorList()
  {
	  return this.userDao.queryoperatorList();
  }

}
 