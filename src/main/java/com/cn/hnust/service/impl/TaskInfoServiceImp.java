package com.cn.hnust.service.impl;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.TaskInfoMapper;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.service.TaskInfoService;
@Service("TaskInfoService")
public class TaskInfoServiceImp implements TaskInfoService {
	
	@Resource
	private TaskInfoMapper taskInfoMapper ;
	
     @Override
     public String GetMaxTaskId()
     {
    	 return this.taskInfoMapper.SelectMaxId();
     }
     @Override
     //public int InsertTaskidList(ArrayList<TaskInfo> taskinfolist)
     public int InsertTaskidList(TaskInfo taskinfo)
     {
//    	 System.out.println("*********************************");
//    	 
//         for(int n = 0 ; n < taskinfolist.size() ;n++)
//         {
//        	 System.out.println(taskinfolist.get(n).getClassId());
//        	 System.out.println(taskinfolist.get(n).getDate());
//        	 System.out.println(taskinfolist.get(n).getTaskId());
//         }
    	 return this.taskInfoMapper.AddRecordBath(taskinfo);
     }
     
     public TaskInfo selectByOperatorClass(String date,String classid)
     {
    	 return this.taskInfoMapper.selectByOperatorClass(date,classid);
     }
}
