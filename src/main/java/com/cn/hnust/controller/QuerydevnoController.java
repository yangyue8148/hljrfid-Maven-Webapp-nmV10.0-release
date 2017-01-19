package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cn.hnust.model.CalculatTool;
import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.pojo.Querydevno;
import com.cn.hnust.pojo.Querytask;
import com.cn.hnust.service.ClassInfoService;
import com.cn.hnust.service.IQuerydevnoService;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.QueryEquipCountService;
import com.cn.hnust.service.SavedevinfoService;
import com.cn.hnust.service.WorkListService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.ProxyImage;
import com.cn.hnust.tool.ResultUtils;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class QuerydevnoController {
	private Map<String, Object> jsonResult;

	private String task_id;
	private String BanCi = "";
	@Resource
	private IQuerydevnoService querydevnoService;
	@Resource
	private IQuerytaskService querytaskService;
	@Resource
	private QueryEquipCountService QueryEquipCountService;
	@Resource
	private ClassInfoService classInfoService;
	@Resource
	private SavedevinfoService savedevinfoService;
	@Resource
	private WorkListService workListService;
	@SuppressWarnings("null")
	@RequestMapping(value = "/querydevno")
	public String taskid(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws Exception {	
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> operatormap = new HashMap<String, Object>();
		Map<String, Object> map_exestatusMap = new HashMap<String, Object>();
		//HttpServletRequest multipartRequest = request;
		String devicecode = request.getParameter("devicecode");
		String BanCiflag = null;
		String BitmapPath = null;
		SimpleDateFormat formatter;
		Date befordate;
		String operaotor_id = request.getParameter("operator_id");
		// againScann =1 时 可以获得已巡检设备的信息
		String againScann = request.getParameter("againScann");
		System.out.println("operaotr_id1111" + operaotor_id);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddk"); // 如果需要小时、分钟和秒则用字符串"yyyy-MM-dd HH:mm:ss"
		String strDate = df.format(date).substring(0, 8);
		String strhour = df.format(date).substring(8);
		System.out.println("stdDate=" + strDate);
		System.out.println("strhour=" + strhour);
		/******************************** 判断当前巡检任务是否已经执行完成 ******************/
		/*
		 * 计算班次 CalculatClass
		 */
		ArrayList<ClassInfo> classlist = classInfoService.selectByall(); // 统计所有的班次
		CalculatTool calculatTool = new CalculatTool();
		BanCi = calculatTool.CalculatClass(classlist); // 当前时间执行属于哪个班次
		System.out.println("Banci=" + BanCi);
		System.out.println("strDate=" + strDate);
		operatormap.put("date_time", strDate);
		operatormap.put("Class_id", BanCi);
		// 获取任务信息
		Querytask querytask = this.querytaskService
				.QueryTaskStatus((Map<String, Object>) operatormap);
		if (querytask == null) {
				//以上为  新加代码   为实现巡检任务完成后继续修改状态
				map.put("status", false);
				map.put("msg", "当前班次已执行完成");
		} else {
			task_id = querytask.getTask_id();
			map_exestatusMap.put("devicecode", devicecode);
			map_exestatusMap.put("ban_ci", BanCi);
			System.out.println("devicecode***********" + devicecode);
			// System.out.println("task_id***********"+task_id);
			/*if (Integer.parseInt(BanCi) >= 6) {
				
				 * 计算昨天
				 
				formatter = new SimpleDateFormat("yyyyMMdd");
				befordate = DateUtils.getNextDay(date);
				strDate = formatter.format(befordate);
			}*/
			map_exestatusMap.put("strDate", strDate);
			System.out.println("BanCi***********" + BanCi);
			System.out.println("operator_id***********" + operaotor_id);
			// 判断设备是否已经做过巡检
			int IsExtFlag = this.QueryEquipCountService
					.selectIsExeFlag(map_exestatusMap);
			//获得需修改已巡检设备或未巡检设备
			if ("1".equals(againScann) || IsExtFlag <= 0) {
				Querydevno querydevno = this.querydevnoService.getQueryById(devicecode);
				if (querydevno != null) {
					map.put("status", true);
					map.put("data", querydevno.getEquip_name());
					map.put("equip_spec", querydevno.getEquip_spec());
					map.put("task_id", task_id);
					map.put("ban_ci", BanCi);
					if ("1".equals(againScann)) {
						map.put("isAgain", "1");
					}
					// 上传图片到数据采集终端
					BitmapPath = "D:" + File.separator + "normalPic"
							+ File.separator + querydevno.getEquip_spec()
							+ ".jpg";
					System.out.println(BitmapPath);
					File file = new File(BitmapPath);
					if (file.exists()) {
						String bitmapString = ProxyImage
								.imageToBase64(BitmapPath);
						map.put("bitmappic", bitmapString);
						map.put("haspic", "01");
					} else {
						map.put("haspic", "00");
					}
					int rtn_worklist = workListService.querypasmid(devicecode,
							"00");
					System.out.println("rtn_worklist" + rtn_worklist);
					if (rtn_worklist == 0) {
						map.put("isWorkOrder","00");
					}else
					{
						map.put("isWorkOrder","01");
					}
					
					int totalequipcount = this.QueryEquipCountService.TotalEquipCount();
					operatormap.put("Datetime", strDate);
					operatormap.put("Class_id", BanCi);
					int exetotalquipcount = this.savedevinfoService
							.getExeeuquipCount(operatormap);
					// 因为此时还有一个设备没有上传 所以当前巡检过的设备数应加1
					exetotalquipcount++;
					System.out.println(totalequipcount+ "                  --------------totalequipcount");
					System.out.println(exetotalquipcount+ "                  --------------exetotalquipcount");
					if (totalequipcount - exetotalquipcount == 1
							|| totalequipcount - exetotalquipcount == 0) {
						// map.put("status", true);
						map.put("lastdevice", "1");// 标记还剩最后一台设备
					} else {
						map.put("lastdevice", "0");
					}
				} else {
					map.put("status", false);
					map.put("msg", "设备未登记或已停用");
				}

			} else {
					map.put("status", false);
					map.put("msg", "该设备已巡检");
					map.put("dxflag", "00");
				/************************************ end *******************************/
			}

		}
		setJsonResult(map);
		System.out.println(jsonResult.toString());
		ResultUtils.toJson(request, resp, this.jsonResult);
		return "showUser";
	}

	@RequestMapping(value = "/exetask")
	public String exetask(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws IOException {
		String devno = request.getParameter("devicecode");
		String machina_name = null;
		Querydevno querydevno = this.querydevnoService.getQueryById(devno);

		String Equip_spec = querydevno.getEquip_spec();
		String DeviceName = querydevno.getEname();
		Map<String, Object> map = new HashMap<>();
		List<Querydevno> list = new ArrayList<Querydevno>();
		if (querydevno != null) {
			Querydevno q = new Querydevno();
			q.setMachine_name("指示灯状态");
			list.add(q);
			map.put("status", "true");
			map.put("data", list);
			System.out.println("devno=" + devno);
			// machina_name =
			// QueryEquipCountService.QueryMachinenane(Equip_spec);
			map.put("devicename", DeviceName);
		} else {
			map.put("status", "flase");
		}
		setJsonResult(map);
		System.out.println(jsonResult.toString());
		ResultUtils.toJson(request, resp, this.jsonResult);
		return "showUser";
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String CalculatClass1() {
		int starttime;
		int endtime;
		int currtime;
		ArrayList<ClassInfo> classlist = classInfoService.selectByall();
		DateFormat tf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String strTime = tf.format(date).substring(0, 2);
		System.out.println(strTime);
		for (int n = 0; n < classlist.size(); n++) {
			starttime = Integer.valueOf(classlist.get(n).getClassStart()
					.substring(0, 2));
			endtime = Integer.valueOf(classlist.get(n).getClassEnd()
					.substring(0, 2));
			currtime = Integer.valueOf(strTime);
			/*
			 * 当前时间在9点至18点间
			 */
			if (currtime < Integer.valueOf(classlist.get(3).getClassEnd()
					.substring(0, 2).substring(0, 2))
					&& currtime >= Integer.valueOf(classlist.get(0)
							.getClassStart().substring(0, 2).substring(0, 2))) {
				if (currtime >= Integer.valueOf(classlist.get(0)
						.getClassStart().substring(0, 2).substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(0)
								.getClassEnd().substring(0, 2))) {
					return "1";
				} else if (currtime >= Integer.valueOf(classlist.get(1)
						.getClassStart().substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(1)
								.getClassEnd().substring(0, 2))) {
					return "2";
				} else if (currtime >= Integer.valueOf(classlist.get(2)
						.getClassStart().substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(2)
								.getClassEnd().substring(0, 2))) {
					return "3";
				} else {
					return "4";
				}
			} else {
				if (currtime >= Integer.valueOf(classlist.get(7)
						.getClassStart().substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(7)
								.getClassEnd().substring(0, 2))) {
					return "8";
				} else if (currtime >= Integer.valueOf(classlist.get(6)
						.getClassStart().substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(6)
								.getClassEnd().substring(0, 2))) {
					return "7";
				} else if (currtime >= Integer.valueOf(classlist.get(5)
						.getClassStart().substring(0, 2))
						&& currtime < Integer.valueOf(classlist.get(5)
								.getClassEnd().substring(0, 2))) {
					return "6";
				} else {
					return "5";
				}
			}
		}

		return "";
	}
}
