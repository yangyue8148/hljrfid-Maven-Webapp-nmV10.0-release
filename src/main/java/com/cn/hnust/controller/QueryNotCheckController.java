package com.cn.hnust.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.cn.hnust.pojo.EquipInfo;
import com.cn.hnust.service.ClassInfoService;
import com.cn.hnust.service.EquipInfoService;
import com.cn.hnust.service.QueryEquipCountService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.ResultUtils;

/**
 * 漏检查询
 * 
 * @author yy
 * 
 */
@Controller
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class QueryNotCheckController {
	private Map<String, Object> jsonResult;
	@Resource
	private QueryEquipCountService queryEquipCountService;
	@Resource
	private EquipInfoService equipInfoService;
	@Resource
	private ClassInfoService classInfoService;
	private Map<String, String> map_exestatusMap = new HashMap<String, String>() ;

	@SuppressWarnings("null")
	@RequestMapping(value = "/user/queryNotCheck")
	public String taskid(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws IOException, ParseException {
		// 获取全部设备信息
		//ArrayList<EquipInfo> allDevino = this.equipInfoService.getAllDevino();
		 Map map = new HashMap();
	//	System.out.println("----------------数据：------------------"+allDevino.size());
		// 获取当前班次
		ArrayList<ClassInfo> allClass = this.classInfoService.selectByall();
		String banCi = CalculatTool.CalculatClass(allClass);
		map_exestatusMap.put("ban_ci", banCi);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	  /*
	    if(Integer.parseInt(banCi)>5)
		{
			Date befordate = DateUtils.getNextDay(date);
			String strDate = formatter.format(befordate); 
			map_exestatusMap.put("strDate", strDate);			
		}
		else {
			String strDate = formatter.format(date).substring(0, 8);
			map_exestatusMap.put("strDate", strDate);
		}
		*/
		// 获取当前时间		
		String strDate = formatter.format(date).substring(0, 8);
		
		System.out.println("时间="+strDate);
		map_exestatusMap.put("strDate", strDate);
		ArrayList<EquipInfo> allDevino = this.equipInfoService.getAllNoCheck(map_exestatusMap);
		// 未巡检设备信息集合
//		ArrayList<EquipInfo> noCheckList = new ArrayList<>();
		
//		for (int i = 0; i < allDevino.size(); i++) {
//            System.out.println(allDevino.get(i).getEquipId());
//            System.out.println(allDevino.get(i).getEname());
//			EquipInfo equipInfo = allDevino.get(i);
//			//String devicecode = equipInfo.getEquipId();
//			map_exestatusMap.put("devicecode", allDevino.get(i).getEquipId().toString());	
//			map_exestatusMap.put("Install_location", allDevino.get(i).getInstallLocation().toString());
//			map_exestatusMap.put("Cabinet_position",allDevino.get(i).getCabinetPosition().toString());
//			map_exestatusMap.put("ban_ci", banCi);
//			map_exestatusMap.put("strDate", strDate);
//			int IsExtFlag = this.queryEquipCountService
//					.selectIsExeFlag(map_exestatusMap);
//			if (IsExtFlag == 0) {
//				// 未巡检
//				noCheckList.add(equipInfo);
//			}
//		}
		System.out.println("----------------漏检设备信息------------------");
		
		map.put("result", true);
		map.put("data", allDevino);
	//	map.put("data", noCheckList); 
		setJsonResult(map);		
		System.out.println(jsonResult.toString());
		ResultUtils.toJson(request, resp, this.jsonResult);
		return "showUser";

	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}
}
