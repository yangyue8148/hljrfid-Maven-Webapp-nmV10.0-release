package com.cn.hnust.tool;

import java.text.DecimalFormat;

public class NumberFormat {
	
	 private static final String STR_FORMAT = "000000";   
	  
	    public static String haoAddOne_2(String liuShuiHao){  
	        Integer intHao = Integer.parseInt(liuShuiHao);  
	        intHao++;  
	        DecimalFormat df = new DecimalFormat(STR_FORMAT);  
	        return df.format(intHao);  
	    }  

}
