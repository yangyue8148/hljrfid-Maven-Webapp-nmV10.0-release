package com.cn.hnust.service;

import java.util.ArrayList;

import com.cn.hnust.pojo.TaskInfo;



public  interface TaskInfoService {
    public String GetMaxTaskId() ; 
    public TaskInfo selectByOperatorClass(String date,String classid);
    public int InsertTaskidList(TaskInfo taskinfolist);
}
