package com.cn.hnust.service;

import java.util.ArrayList;
import java.util.List;

import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.pojo.Savedevinfo;
import com.cn.hnust.pojo.WorkList_Info;

public interface WorkListService {

	public int querypasmid(String pasm_id,String state);	
	public int insertworklist(String pasm_id,String gen_date,String gen_person,String strTime ,String task_id,String picNum,String userDepartment);
    public ArrayList<WorkList_Info> queryWorkOrder(String wflow_satus);
}
