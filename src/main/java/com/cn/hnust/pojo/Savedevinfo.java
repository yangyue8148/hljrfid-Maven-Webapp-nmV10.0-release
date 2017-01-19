package com.cn.hnust.pojo;

public class Savedevinfo {
    private String status;    
    private String Equip_id;
    private String Ins_state;
    private String Ins_task;
    private String Pic_url;
    private String Datetime;
    private byte[] bitimage ;
    private String Class_id ;
 
    
    
    public String getClass_id() {
        return Class_id;
    }    
    
    public void setClass_id(String Class_id)
    {
    	this.Class_id = Class_id ;    	
    }  
   
    public String getEquip_id() {
        return Equip_id;
    }    
    
    public void setEquip_id(String Equip_id)
    {
    	this.Equip_id = Equip_id ;    	
    }    
    
    public void setbitimage(byte[] b) {    	
    	bitimage = b ;
	}
    
    public byte[] getBitimage() {
    	return bitimage;		
	}
    
    
    public String getIns_state() {
        return Ins_state;
    }    
    
    public void setIns_state(String Ins_state)
    {
    	this.Ins_state = Ins_state ;    	
    }
    
    public String getIns_task() {
        return Ins_task;
    }    
    
    public void setIns_task(String Ins_task)
    {
    	this.Ins_task = Ins_task ;    	
    }
    
    public String getPic_url() {
        return Pic_url;
    }    
    
    public void setPic_url(String Pic_url)
    {
    	this.Pic_url = Pic_url ;    	
    }
    
    
    public String getDatetime() {
        return Pic_url;
    }    
    
    public void setDatetime(String Datetime)
    {
    	this.Datetime = Datetime ;    	
    }
    
}