package com.cn.hnust.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.service.ClassInfoService;

public class CalculatTool {
	/*
	 * 获取班次
	 */
	public static String CalculatClass(ArrayList<ClassInfo> classlist)
			throws ParseException {
		String starttime;
		String endtime;
		DateFormat tf = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		String strTime = tf.format(date);
		for (int n = 0; n < classlist.size(); n++) {
			starttime = classlist.get(n).getClassStart();
			endtime = classlist.get(n).getClassEnd();
			Date currtime = tf.parse(strTime);
			Date da1 = tf.parse(starttime);
			Date da2 = tf.parse(endtime);
			if (currtime.getTime() >= tf.parse("23:30").getTime()||currtime.getTime()<tf.parse("02:30").getTime()) {
				return "06";
			}
			if (currtime.getTime() >= da1.getTime()
					&& currtime.getTime() < da2.getTime()) {
				return "0" + (++n);
			}
		}
		return "";
	}

}
