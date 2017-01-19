package com.cn.hnust.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.Savedevinfo;
import com.cn.hnust.pojo.User;
import com.cn.hnust.pojo.WorkList_Info;

public interface WorkListinfoDao {
   
  //  int   insertsavetask(@Param(value="task_id") String task_id,@Param(value="devicecode") String devicecode,@Param(value="datetime") String datetime ,@Param(value="fileName") String fileName,@Param(value="rdnflag") String rdnflag,@Param(value="banci") String banci,@Param(value="operator_id") String operator_id,@Param(value="strTime") String strTime ,@Param(value="b") byte[] b);
    int queryworklist(@Param(value="PSAM_ID") String pasm_id,@Param(value="state") String state);
    
    int insertworklist(@Param(value="PSAM_ID") String devicecode,@Param(value="gen_date") String gen_date,@Param(value="gen_person") String WFlows_gen_person,@Param(value="state") String psam_state,@Param(value="gen_time") String strTime,@Param(value="task_id") String task_id,@Param(value="picNum") String picNum,@Param(value="userDepartment") String userDepartment);
    
    
    ArrayList<WorkList_Info> queryWorkOrder(@Param(value="wflow_satus")String wflow_satus);

}