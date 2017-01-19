package com.cn.hnust.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.TaskInfo;

public interface TaskInfoMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(TaskInfo record);

    int insertSelective(TaskInfo record);

    TaskInfo selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(TaskInfo record);

    int updateByPrimaryKey(TaskInfo record);
    
    String SelectMaxId() ;
    
    int UpdateTaskRecord(TaskInfo record);	 
    
   // int AddRecordBath(ArrayList<TaskInfo> taskinfolist);
    int AddRecordBath(TaskInfo taskinfolist);   
    
    TaskInfo selectByOperatorClass(@Param(value="date") String date,@Param(value="classId") String classId) ;
}