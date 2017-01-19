package com.cn.hnust.timeservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONException;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.pojo.Telnum;
import com.cn.hnust.service.QueryAllTaskService;
import com.cn.hnust.service.QueryDXFlagService;
import com.cn.hnust.service.QueryTelNumService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.SendMSGUtil;

/**
 * 给处长定时发短信
 * 
 * @author pc-yy
 * 
 */
public class HeadMsg extends QuartzJobBean {
	@Resource
	private QueryTelNumService queryTelNumService;
	@Resource
	private QueryDXFlagService queryDXFlagService;
	@Resource
	private QueryAllTaskService queryAllTaskService;

	private ArrayList<Telnum> telnum;
	private String currentTime;
	// 处长
	private final static String CHUZHANG = "3";
	private String num = "";
	private int count;
	private String send_flag;
	private DateFormat tf;
	private Date curDate;
	private Date cTime;
	private Date sTime;

	/**
	 * 业务逻辑处理
	 * @throws ParseException 
	 * @throws JSONException 
	 */

	public void doBiz() throws JSONException, ParseException {
		String type = CHUZHANG;
		System.out.println("我要发送处长短信了····························");
		telnum = this.queryTelNumService.getTelnum(type);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		tf = new SimpleDateFormat("HH:mm");
		curDate = new Date(System.currentTimeMillis());
		currentTime = formatter.format(curDate);

		sendMessage();
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {

	}

	private void sendMessage() throws JSONException, ParseException{
		if (telnum.size() != 0) {
			count = telnum.size();
			for (int i = 0; i < telnum.size(); i++) {

				String time = telnum.get(i).getSend_time();
				String number = telnum.get(i).getContact_tel();
				String contact_flag = telnum.get(i).getSend_flag();
				// 判断号码是否停用
				if (contact_flag.equals("00")) {
					String nowTime = tf.format(curDate);
//					String sendTime = currentTime.substring(9, 11);
//					cTime = Integer.valueOf(sendTime);
					String sendDate = currentTime.substring(0, 8);
					cTime = tf.parse(nowTime);

					send_flag = this.queryDXFlagService.queryFlag(
							number, sendDate);

					// Send_flag = "1" 标识没有发送过
					if (send_flag == null || "".equals(send_flag)) {
						send_flag = "1";
					}
					sTime = tf.parse(time);
					//time = time.substring(0, 2);
					//sTime = Integer.valueOf(time);
					// 判断条件 时间 该时间是否发送过
					if (cTime.getTime() >= sTime.getTime() && send_flag.equals("1")) {
						// 获取 发送处长的电话
						System.out.println("这个时间没有给处长发过短信····························");
						
						if (i == telnum.size() - 1) {
							num += telnum.get(i).getContact_tel();
						} else {
							num += telnum.get(i).getContact_tel() + ",";
						}
						// 保存 处长发送状态 0表示已经发送
						this.queryDXFlagService.saveFlag(number, sendDate, "0");
					}
				} else {
					// 发送短信的人数
					count--;
				}
			}
			// 获取处长短信内容
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
			Date befordate = DateUtils.getNextDay(curDate);
			String today = formatter.format(curDate);
			String yesterday = formatter.format(befordate);

			ArrayList<TaskInfo> querytasList = new ArrayList<TaskInfo>();
			querytasList = this.queryAllTaskService.queryAllTask(yesterday,
					today);
			// 完成
			int over = 0;
			// 未完成
			int never = 0;
			for (int i = 0; i < querytasList.size(); i++) {
				if (querytasList.get(i).getDate().equals(yesterday)
						&& Integer.valueOf(querytasList.get(i).getClassId()) < 6) {
					if (querytasList.get(i).getStatus().equals("02")) {
						over++;
					} else {
						never++;
					}
				} else if (querytasList.get(i).getDate().equals(today)
						&& Integer.valueOf(querytasList.get(i).getClassId()) > 5) {
					if (querytasList.get(i).getStatus().equals("02")) {
						over++;
					} else {
						never++;
					}
				}

			}
			String msg = "昨天巡检任务情况：" + over + "个班次任务完成       " + never
					+ "个班次任务未完成";
			// sendByHttp(num, msg);
			if (cTime.getTime() >= sTime.getTime() && send_flag.equals("1")) {
				SendMSGUtil sm = new SendMSGUtil();
				sm.sendByHttp(num, msg, count + "");
				num = "";
			}
		}
	}
}
