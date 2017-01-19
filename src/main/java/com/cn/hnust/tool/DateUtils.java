package com.cn.hnust.tool;

import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;
/**
 * ****************************************************************   
**   文 件 名:   DateUtils.java
**   Copyright   (c)   2007-2011  dhdu@qq.com   
**   创 建 人:   
**   日    期:   
**   修 改 人:   
**   日    期:   2011-03-15
**   描    述:   date
**   
**   版    本:   
**   
**  ==============================================================
**
**   修改记录
**
**   版本号    修改编号    修改者       修改日期        修改说明
**   ======   ========    ========     ==========     =========== 
**   1.0.0       1         XXX       22011-3-15      没改业务，只是修改了注释规范，过期方法没改        
**
*******************************************************************
 */
public class DateUtils {
	
	
	public static Date getNextDay(Date date) {  
		       Calendar calendar = Calendar.getInstance();  
		       calendar.setTime(date);  
		       calendar.add(Calendar.DAY_OF_MONTH, -1);  
		       date = calendar.getTime();  
		       return date;  
		   } 

	 /**
	     **   函 数 名: getCurrentCnDateWithTimestamp
	     **   输    入: 
	     **   输    出: Timestamp   
	     **   功能描述: 得到中国时区的当前系统时间
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static Timestamp getCurrentCnDateWithTimestamp(){
	   Date date=new Date();   
	   SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);   
	   fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));   
	   String moditime=fm.format(date);   
	   Timestamp lasttime=Timestamp.valueOf(moditime); //字符型转换为时间型。   
	   return lasttime;  
	 }
	 /**
	     **   函 数 名: getCurrentCnDateWithString
	     **   输    入: 
	     **   输    出: String yyyy-MM-dd HH:mm:ss   
	     **   功能描述: 得到中国时区的当前系统时间
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getCurrentCnDateWithTime(){
	   Date date=new Date();   
	   SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);   
	   fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));   
	   String moditime=fm.format(date);        
	   return moditime;  
	 }
	 
	 /**
	     **   函 数 名: getCurrentCnDateWithString1
	     **   输    入: 
	     **   输    出: String yyyyMMdd
	     **   功能描述: 得到中国时区的当前系统时间
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getCurrentCnDateWithdate(){
	   Date date=new Date();   
	   SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);   
	   fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));   
	   String moditime=fm.format(date);        
	   return moditime;  
	 }
	 
	 /**
	     **   函 数 名: GetCurrentMonth
	     **   输    入: Date
	     **   输    出: String yyyyMM
	     **   功能描述: 得到中国时区的当前系统的月份
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 
	 public static String GetCurrentMonth(Date d)
	 {
		 Date date=null;
		  if(d!=null)
		   date=d;
		  else 
		   date=new Date();		  
		   SimpleDateFormat fm = new SimpleDateFormat("yyyyMM", Locale.CHINA);  		   
		   String datemonth = fm.format(date);		   
		   return datemonth ;  
	 }
	 
	 
	 /*
	  * 获取当月的天数
	  */
	 public static int getCurrentDay()  
	 {  
	     Calendar a = Calendar.getInstance();  
	     a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	     a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	     int maxDate = a.get(Calendar.DATE);  
	     return maxDate;  
	 } 	 

     
     
	 /**
	     **   函 数 名: getCurrentCnDateWithString1
	     **   输    入: Date
	     **   输    出: String yyyy-MM-dd
	     **   功能描述: 得到中国时区的当前系统时间
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getCurrentCnDateWithString1(Date d){
	  Date date=null;
	  if(d!=null)
	   date=d;
	  else 
	   date=new Date();
	   SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);   
	   fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));   
	   String moditime=fm.format(date);        
	   return moditime;  
	 }
	 

	 
	 
	 /**
	     **   函 数 名: getCurrentCnDateWithDatetime
	     **   输    入: 
	     **   输    出: Date
	     **   功能描述: 得到中国时区的当前系统时间
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static Date getCurrentCnDateWithDatetime(){
	   Date date=new Date();   
	   SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);   
	   fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));   
	   String moditime=fm.format(date);      
	   Timestamp lasttime=Timestamp.valueOf(moditime); //字符型转换为时间型。     
	   return new Date(lasttime.getTime());
	 }
	 
	 /**
	     **   函 数 名: getAfterDateWithDate
	     **   输    入: date日期，amount数字，type 1：月 2：季度 3：年
	     **   输    出: Date
	     **   功能描述: 得到已知日期以后相隔多久的日期
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static Date getAfterDateWithDate(Date date,int amount,int type){  
	   Calendar c=Calendar.getInstance();
	   c.setTimeInMillis(date.getTime());
	   if(type==1){
	    c.add(GregorianCalendar.MONTH, amount);   
	   }else if(type==2){
	     c.add(GregorianCalendar.MONTH, (amount*3));    
	   }else  if(type==3){
	    c.add(GregorianCalendar.YEAR, amount);   
	   }
	   return c.getTime();  
	 }
	 /**
	     **   函 数 名: getAfterDateWithTimestamp
	     **   输    入: date日期，amount数字，type 1：月 2：季度 3：年
	     **   输    出: Timestamp
	     **   功能描述: 得到已知日期以后相隔多久的日期
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static Timestamp getAfterDateWithTimestamp(Date date,int amount,int type){  
	   Calendar c=Calendar.getInstance();
	   c.setTimeInMillis(date.getTime());
	   if(type==1){
	   c.add(GregorianCalendar.MONTH, amount);    
	   }else if(type==2){
	   c.add(GregorianCalendar.MONTH, (amount*3));    
	   }else  if(type==3){
	   c.add(GregorianCalendar.YEAR, amount);   
	   }   
	  return new Timestamp(c.getTimeInMillis());  
	 }
	 
	 /**
	     **   函 数 名: getDateYY
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述: 得到当前时间的两位数年份
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateYY(Date d)
	 {
	  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8")); 
	  if(d!=null)
	   c.setTime(d);
	  String year=String.valueOf(c.get(Calendar.YEAR));
	  year=year.substring(year.length()-2);
	  return year;
	 }
	 /**
	     **   函 数 名: getDateYYYY
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述:得到当前时间的四位数年份
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateYYYY(Date d)
	 {
		  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8")); 
		  if(d!=null)
		   c.setTime(d);
		  return String.valueOf(c.get(Calendar.YEAR));
	 }
	 
	 

	 /**
	     **   函 数 名: getDateMM
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述: 得到当前时间的两位数月份
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateMM(Date d)
	 {
	  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8")); 
	  if(d!=null)
	   c.setTime(d);
	  String month=String.valueOf(c.get(Calendar.MONTH)+1);
	  if(month.length()==1)
	   month="0"+month;
	  return month;
	  
	 }
	 
	 /**
	     **   函 数 名: getDateDD
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述: 得到当前时间的两位数月份中的第几日
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateDD(Date d)
	 {
	  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8")); 
	  if(d!=null)
	   c.setTime(d);
	  String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
	  if(day.length()==1)
	   day="0"+day;
	  return day;
	  
	 }
	 
	 /**
	     **   函 数 名: getDateQQ
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述: 得到当前时间的两位数季度
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateQQ(Date d)
	 {
		  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		  if(d!=null)
		   c.setTime(d);
		  String q=String.valueOf(Double.valueOf(Math.ceil((c.get(Calendar.MONTH)+1)/3d)).intValue());
		  if(q.length()==1)
		   q="Q"+q;
		  return q;
	  
	 }
	 
	 /**
	     **   函 数 名: getDateWW
	     **   输    入: date日期
	     **   输    出: String
	     **   功能描述: 得到当前时间的两位数一年中的第几周
	     **   全局变量:   
	     **   调用模块:   
	     **   作    者:   XXX
	     **   日    期:   
	     **   修    改:   
	     **   日    期:
	     */
	 public static String getDateWW(Date d)
	 {
		  Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT+8")); 
		  if(d!=null)
		   c.setTime(d);
		  String w=String.valueOf(c.get(Calendar.WEEK_OF_YEAR));
		  if(w.length()==1)
		   w="0"+w;
		  return w;
	  
	 }
	 public static String getDateCurrentDay(int gapday)
	 {
		 
		 Calendar c=Calendar.getInstance();
	     //当前的day_of_month加一就是明天时间
	     c.add(Calendar.DAY_OF_MONTH,gapday);
	     String tomorrow=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
	     System.out.println("明天的日期"+tomorrow);
	     return tomorrow ;
	     
	 }
      /*
       * 获取下个月1号的具体日期
       */
	   public static String  getNextMonthDay()
	   {
			String nextMonth = null ;
		    Calendar c = Calendar.getInstance();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 //System.out.println(c.getTime());
		   c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		   c.set(Calendar.DAY_OF_MONTH, 1);
	       //System.out.println("下个月的第一天: " +sdf.format(c.getTime()));	   
		   nextMonth = sdf.format(c.getTime());
		   return nextMonth;
	   }

		/*
		 * 获取下个月天数
		 */
	   public static int  getNextCountDay(String strDate)
	   {		  
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
		   Calendar calendar = new GregorianCalendar(); 
		   Date date1 = null;
		try {
			date1 = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   calendar.setTime(date1); //放入你的日期 
		   System.out.println("天数为=" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		   return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	   }
	
}
