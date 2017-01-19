package com.cn.hnust.pojo;

public class Querydevno {
	 private String Equip_id;

	    private String Equip_name;
	    
	    private String machine_name ;
	    
	    private String Equip_spec ;
	    
	    private String Ename ;
	    
	   /* private String Ins_date;
	    
	    private String Class_id ;*/

	   
	    
	    public String getEname()
	    {
	    	return Ename ;
	    }
	    
	    public void setEname(String Ename)
	    {
	    	this.Ename = Ename ;
	    }
	    
	    public String getEquip_spec() {
	        return Equip_spec;
	    }

	    public void setEquip_spec(String Equip_spec) {
	        this.Equip_spec = Equip_spec;
	    }
	    
	    
	    public String getEquip_id() {
	        return Equip_id;
	    }

	    public void setEquip_id(String Equip_id) {
	        this.Equip_id = Equip_id;
	    }

	    public String getEquip_name() {
	        return Equip_name;
	    }
	    
	    private String getMachine_name()
	    {
	    	return machine_name ;
	    }
	    
	    public void setMachine_name(String machine_name)
	    {
	    	this.machine_name = machine_name ;
	    	
	    }

	    public void setEquip_name(String Equip_name) {
	        this.Equip_name = Equip_name == null ? null : Equip_name.trim();
	    }

    
    
}