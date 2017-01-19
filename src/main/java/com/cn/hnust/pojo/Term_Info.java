package com.cn.hnust.pojo;

public class Term_Info {
	
	private String Term_no  ;
	private String Term_time ;
	
	
	
	public String getTerm_no()
	{
		return Term_no ;
	}
	
	
	public void setTerm_no(String term_no)
	{
		this.Term_no = term_no==null?null:term_no.trim() ;
	}
	
	
	public String getTerm_time()
	{
		return Term_time ;
		
	}
     
	
	public void  setTerm_time(String Term_time)
	{		
		this.Term_time = Term_time==null?null:Term_time ;
	}
}
