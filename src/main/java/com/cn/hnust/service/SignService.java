package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.dao.signDao;
import com.cn.hnust.pojo.Sign;




public  interface SignService {  
    public ArrayList<Sign> querySignListBydate(String date);   
}
