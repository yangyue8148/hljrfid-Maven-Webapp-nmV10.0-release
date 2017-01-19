package com.cn.hnust.pojo;

public class Querytask {
    private String Task_id;

    private String Class_id;

    private String Date;
    
    private String Status ;
    
    private String operator_id ;

   
    public String getOperator_id()
    {
    	return operator_id ;
    }
    
    public void setOperator_id(String opetator)
    {
    	this.operator_id = opetator;
    }
    
    
    public String getTask_id() {
        return Task_id;
    }

    public void setTask_id(String Class_id) {
        this.Task_id = Task_id;
    }

    public String getBanCi() {    	
    	
        return Class_id==null?null:Class_id.trim();
    }

    public void setClass_id(String Class_id) {
    	
    	this.Class_id = Class_id ;     
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date == null ? null : Date.trim();
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}