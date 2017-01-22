package com.cn.hnust.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Decoder.BASE64Decoder;

import com.cn.hnust.model.CalculatTool;
import com.cn.hnust.pojo.ApplyInfo;
import com.cn.hnust.pojo.ClassInfo;
import com.cn.hnust.pojo.ContactInfo;
import com.cn.hnust.pojo.EquipInfo;
import com.cn.hnust.pojo.EquipType;
import com.cn.hnust.pojo.Message;
import com.cn.hnust.pojo.Sign;
import com.cn.hnust.pojo.TaskInfo;
import com.cn.hnust.pojo.Telnum;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.ApplyInfoService;
import com.cn.hnust.service.ClassInfoService;
import com.cn.hnust.service.ContactInfoService;
import com.cn.hnust.service.EquipInfoService;
import com.cn.hnust.service.EquipTypeService;
import com.cn.hnust.service.IQuerydevnoService;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.MessageService;
import com.cn.hnust.service.QueryEquipCountService;
import com.cn.hnust.service.QueryTelNumService;
import com.cn.hnust.service.SavedevinfoService;
import com.cn.hnust.service.SignService;
import com.cn.hnust.service.TaskEquipService;
import com.cn.hnust.service.WorkListService;
import com.cn.hnust.tool.DateUtils;
import com.cn.hnust.tool.ResultUtils;
import com.cn.hnust.tool.SendMSGUtil;
import com.mysql.fabric.xmlrpc.base.Value;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class SavetaskController {
	private Map<String, Object> jsonResult;
	@Resource
	private SavedevinfoService savedevinfoService;
	@Resource
	private IQuerytaskService querytaskService;
	@Resource
	private IQuerydevnoService querydevnoService;
	@Resource
	private QueryEquipCountService queryEquipCountService;
	@Resource
	private QueryTelNumService queryTelNumService;
	@Resource
	private WorkListService workListService;
	@Resource
	private IUserService userService;
	@Resource
	private SignService signService;
	@Resource
	private QueryEquipCountService QueryEquipCountService;
	@Resource
	private TaskEquipService taskEquipService;
	@Resource
	private EquipInfoService equipInfoService;
	@Resource
	private ContactInfoService contactInfoService;
	@Resource
	private MessageService messageService;
	@Resource
	private ClassInfoService classInfoService;	
	@Resource
	private EquipTypeService equipTypeService;	
	@Resource
	private ApplyInfoService applyInfoService;

	private ArrayList<ContactInfo> contacts;

	private static final String KEZHANG = "2";

	@SuppressWarnings("null")
	@RequestMapping(value = "/taskupload")
	public String exetaskupload(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws IOException, ParseException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, Object> operatormap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat formatter;
		Date befordate;
		String operStatu = null;
		String tagFlag = null;
		String picNum = "0";
		int totalequipcount = 0;
		int exetotalquipcount = 0;
		String fileName = null;
		String filename = null;
		String imgStr = null;
		String logoPathDir = "D:/INS/tjnh/Ins_Pat/showpic";		
		String userDepartment= null;
		String equipType = null; 
		String equipTypeName = null;
		String inspect_totalnum = null;
		String inspect_successnum = null;

		
		//String logoPathDir = "C:/bmp/";
		/** 得到文件保存目录的真实路径* */
		// String logoRealPathDir =
		// multipartRequest.getSession().getServletContext().getRealPath(logoPathDir);
		/** 根据真实路径创建目录* */
		File logoSaveFile = new File(logoPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();

		/** 页面控件的文件流* */
		// MultipartFile multipartFile = multipartRequest.getFile("upload");

		String rdnflag = multipartRequest.getParameter("rdnflag");

		if (rdnflag.compareTo("0") == 0) {
			filename = multipartRequest.getParameter("picname");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<picname="
					+ filename);
			imgStr = multipartRequest.getParameter("bitbase");
			tagFlag = multipartRequest.getParameter("tag");// 0：首次上传信息 1...9
															// 表示重复上传的图片
			picNum = multipartRequest.getParameter("pic_number");
			// System.out.println("bitmap="+imgStr);
		}
		String devicecode = multipartRequest.getParameter("devicecode");
		String task_id = multipartRequest.getParameter("task_id");
		String operator_id = multipartRequest.getParameter("operator_id");
		// againScann =1 时 表示修改已巡检设备的信息
		String againScann = multipartRequest.getParameter("againScann");
		System.out.println(operator_id);
		// String banCi = multipartRequest.getParameter("ban_ci");
		ArrayList<ClassInfo> classlist = classInfoService.selectByall(); // 统计所有的班次
		CalculatTool calculatTool = new CalculatTool();
		String banCi = calculatTool.CalculatClass(classlist);
		DateFormat df = new SimpleDateFormat("yyyyMMdd"); // 如果需要小时、分钟和秒则用字符串"yyyy-MM-dd HH:mm:ss"
		DateFormat tf = new SimpleDateFormat("HH:mm:ss");
		String operator_tmp = null;
		Date date = new Date();
		String strDate = df.format(date).substring(0, 8);
		String strTime = tf.format(date);
		String strhour = df.format(date).substring(8);

		// 获取巡检拍照图片
		if (rdnflag.compareTo("0") == 0) {
			/** 创建图片 **/
			// createbmp(imgStr,filename,logoRealPathDir);
			createbmp(imgStr, filename, logoPathDir);
			/** 获取文件的后缀* */
			// String suffix =
			// multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			/** 使用UUID生成文件名称* */
			// String logImageName = UUID.randomUUID().toString() + suffix;//
			// 构建文件名称
			String logImageName = filename + ".jpg";// 构建文件名称
			/** 拼成完整的文件保存路径加文件* */
			// fileName = logoRealPathDir + File.separator + logImageName;
			fileName = logImageName.trim();
			System.out.println("fileName************************" + fileName);
			/** 打印出上传到服务器的文件的绝对路径* */
			// System.out.println("****************"+fileName+"**************");
			// System.out.println("****************"+rdnflag+"**************");
		} else {
			fileName = "";
		}

		System.out.println("picnum====================" + picNum);
		System.out.println("tagFlag==================" + tagFlag);
		// operStatu 00表示正常 01：一张照片,02：首次上传多张照片 03:中间上传 04:表示最后一次
		if (rdnflag.compareTo("0") == 0) {
			int picnum = Integer.parseInt(picNum);
			if (tagFlag.equals("0") == true && picnum == 1) {
				operStatu = "01"; // 首次上传只有一张照片
			} else if (tagFlag.equals("0") == true && picnum > 1) {
				operStatu = "02"; // 首次上传多张照片
			} else if (tagFlag.equals("1") == true && picnum > 1) {
				operStatu = "03"; // 中间
			} else if (tagFlag.equals("2") == true && picnum > 1) {
				operStatu = "04"; // 最后一张照片
			}
		} else {
			operStatu = "00";
		}

		/***************************************** start *******************************/
//		if (Integer.parseInt(banCi) >= 6) {
//
//			/*
//			 * 计算昨天
//			 */
//			formatter = new SimpleDateFormat("yyyyMMdd");
//		    befordate = DateUtils.getNextDay(date);
//			strDate = formatter.format(befordate);
//		}

		/*
		 * map_exestatusMap.put("devicecode", devicecode) ;
		 * map_exestatusMap.put("ban_ci", banCi);
		 * System.out.println("devicecode***********"+devicecode);
		 * map_exestatusMap.put("strDate",strDate); //判断设备是否已经做过巡检 int IsExtFlag
		 * = this.QueryEquipCountService.selectIsExeFlag(map_exestatusMap);
		 * 
		 * System.out.println("********************=========================="+
		 * IsExtFlag); if( IsExtFlag>0 ) { map.put("status", false);
		 * map.put("dxflag", "00"); map.put("msg", "该设备已巡检");
		 * 
		 * }
		 */

		// else {

		// 上传第一张照片时 发送设备报错短信
		if (tagFlag != null && tagFlag.equals("0")) {
			// 对 有故障的设备 发送给 该科室的科员和科长
			System.out.println("·············我要发送短信了·················");
			// TaskEquip taskError = this.taskEquipService.selectTaskError(
			// devicecode, task_id);
			// 查询设备信息 设备编号
			EquipInfo depart = this.equipInfoService.getDepart(devicecode);
			// 部门编号
			userDepartment = depart.getUser_Department();
			//设备类型
			equipType = depart.getEquipType() ;		
			System.out.println("设备类型******************"+equipType+"部门编号"+userDepartment);
			EquipType EquipType= this.equipTypeService.selectByPrimaryKey(equipType);
			equipTypeName = EquipType.getTypeName().trim() ;			
			ArrayList<ApplyInfo> applyInfoList  = this.applyInfoService.selectByPrimaryKey(devicecode);			
			String hostIp = "";
			String ContactMsg = " " ;
			
			for(int applynum=0;applynum<applyInfoList.size();applynum++)
			{
				if(applynum == 0)
					hostIp=applyInfoList.get(applynum).getHostIp();
				System.out.println("1="+applyInfoList.get(applynum).getApplyName().trim());
			    System.out.println("2="+applyInfoList.get(applynum).getApplyIp().trim()+applyInfoList.get(applynum).getContacts());
				ContactMsg = ContactMsg+applyInfoList.get(applynum).getApplyName().trim()+applyInfoList.get(applynum).getApplyIp().trim()+applyInfoList.get(applynum).getContacts();
			}			
			
			System.out.println("contackMsg="+ContactMsg);
			String notContactType = "3";
			contacts = this.contactInfoService.getContact(userDepartment,
					notContactType);
			// 打印数据
			// String msg = "设备：" + depart.getEname() + "   编号：" + devicecode
			// + "   出现问题，请及时检修。";
			String msg = "";
			/*
			 message = this.messageService.getMessage(1);
			msg = message.getMesData() + depart.getEname();
			message = this.messageService.getMessage(3);
			msg += message.getMesData();*/
			Message message = this.messageService.getMessage(2);
			msg += message.getMesData()+":" + devicecode+"服务器类型:"+equipTypeName;
			if(applyInfoList.size()>0)
			{
				msg+=hostIp;
				msg+=ContactMsg;			
			}
			System.out.println("发送短信的内容="+msg);
			// 发送给短信平台的 手机号
			String contact = "";

			for (int i = 0; i < contacts.size(); i++) {
				// 不给处长发送短信
				if (contacts.get(i).getContact_Type() != "3") {
					if (i == contacts.size() - 1) {
						contact += contacts.get(i).getContact_Tel();
					} else {
						contact += contacts.get(i).getContact_Tel() + ",";
					}
				}
			}
			// 发送信息
			SendMSGUtil sm = new SendMSGUtil();
			sm.sendByHttp(contact, msg, contacts.size() + "");
			// sendByHttp(contact, msg,contacts.size()+"");
		}
		/***************************************** end ********************************/
		System.out.println("fileName************************" + fileName);
		// TODO 更新已巡检设备
		System.out.println("againScann "+againScann);
		if ("1".equals(againScann)) {
			int updateTask = this.savedevinfoService.updateTask(task_id,
					devicecode, strDate, fileName, rdnflag, banCi, operator_id,
					strTime, picNum);
			if (updateTask == 0) {
				map.put("status", false);
				map.put("msg", "更新失败，请重试");
			} else {
				if (rdnflag.compareTo("0") == 0) {
					int rtn_worklist = workListService.querypasmid(devicecode,
							"00");
					System.out.println("rtn_worklist" + rtn_worklist);
					if (rtn_worklist == 0) {
						workListService.insertworklist(devicecode, strDate,
								operator_id, strTime, task_id, picNum,userDepartment);
					}
				}
				map.put("status", true);
				totalequipcount = this.queryEquipCountService.TotalEquipCount();
				inspect_totalnum =String.valueOf(totalequipcount);				
				operatormap.put("Datetime", strDate);
				operatormap.put("Class_id", banCi);	    
				exetotalquipcount = this.savedevinfoService.getExeeuquipCount(operatormap);				
				inspect_successnum =String.valueOf(exetotalquipcount);
				map.put("totalEquipNum", inspect_totalnum);
				map.put("successEquipNum", inspect_successnum);
				map.put("msg", "更新成功");
			}
		} else if (operStatu.equals("00") == true
				|| operStatu.equals("01") == true
				|| operStatu.equals("02") == true) {

			int n = this.savedevinfoService.insertsavetask(task_id, devicecode,
					strDate, fileName, rdnflag, banCi, operator_id, strTime,
					picNum);
			/** 保存到数据库 **/
			// int n =
			// this.savedevinfoService.insertsavetask(task_id,devicecode,strDate,fileName,rdnflag,banCi,operator_id,strTime);
			totalequipcount = this.queryEquipCountService.TotalEquipCount();
			inspect_totalnum =String.valueOf(totalequipcount);
			
			operatormap.put("Datetime", strDate);
			operatormap.put("Class_id", banCi);
    
			exetotalquipcount = this.savedevinfoService
					.getExeeuquipCount(operatormap);
			
			inspect_successnum =String.valueOf(exetotalquipcount);
			if (n == 0) {
				map.put("status", false);
				// map.put("lastdevice", "0");
				map.put("msg", "上传巡检记录失败，请重试");
			} else {
				if (rdnflag.compareTo("0") == 0) {
					int rtn_worklist = workListService.querypasmid(devicecode,
							"00");
					System.out.println("rtn_worklist" + rtn_worklist);
					if (rtn_worklist == 0) {
						workListService.insertworklist(devicecode, strDate,
								operator_id, strTime, task_id, picNum,userDepartment);
					}
				}
				map.put("status", true);
				map.put("totalEquipNum", inspect_totalnum);
				map.put("successEquipNum", inspect_successnum);
				// map.put("lastdevice", "0");
				map.put("msg",
						"保存记录成功" + "总计" + String.valueOf(totalequipcount)
								+ "台设备，已巡检" + String.valueOf(exetotalquipcount)
								+ "台！");
				
			}
			totalequipcount = this.queryEquipCountService.TotalEquipCount();
			exetotalquipcount = this.savedevinfoService
					.getExeeuquipCount(operatormap);
			System.out.println("*****************totalequipcount="
					+ totalequipcount);
			System.out.println("*****************exetotalquipment="
					+ exetotalquipcount);
			System.out.println("*****************totalequipcount="
					+ totalequipcount);

			if (exetotalquipcount == totalequipcount) {
				map.put("msg", "上传巡检记录成功，所有设备巡检完毕");
			}

			if (totalequipcount == exetotalquipcount) {
				int m = 0;
				TaskInfo record = new TaskInfo();
				String operator_second = null;
				try {
					/*
					 * 查询当前操作员是否是营业部
					 */
					User user = userService.queryflagbyoperator(operator_id);
					System.out.println("_______________________________");
					System.out.println(user.getFlagyy());
					if (user.getFlagyy().trim().equals("1")) {
						System.out.println("************************");
						ArrayList<Sign> s = signService
								.querySignListBydate(strDate);
						for (int i = 0; i < s.size(); i++) {
							if (operator_id.equals(s.get(i).getcustom_num()) == false) {
								operator_second = s.get(i).getcustom_num();
								break;
							}
						}
					} else {
						System.out.println("************************");
						ArrayList<User> userlist = userService
								.queryoperatorList();
						ArrayList<Sign> s = signService
								.querySignListBydate(strDate);
						boolean flag = false;
						for (int i = 0; i < s.size(); i++) {
							if (operator_id.equals(s.get(i).getcustom_num()) == false) {
								operator_tmp = s.get(i).getcustom_num();
								System.out.println("+++++++++++++++++++++++++"
										+ operator_tmp);
								for (int count = 0; count < userlist.size(); count++) {
									System.out.println("count = " + count);

									System.out.println(userlist.get(count)
											.getUserCode());
									System.out.println(userlist.get(count)
											.getFlagyy());
									if (userlist.get(count).getUserCode()
											.trim().equals(operator_tmp.trim()) == true
											&& userlist.get(count).getFlagyy()
													.trim().equals("1") == true) {
										operator_second = operator_tmp;
										System.out.println(operator_tmp);
										break;
									}
								}

							}
						}
					}
					System.out.println("******************" + operator_second);
					record.setOperatorSecond(operator_second);
					record.setStatus("2");
					record.setTaskId(task_id);
					record.setOperatorFirst(operator_id);
					m = this.querytaskService.updatetask(record);
					if (m > 0) {
						System.out
								.println("SavetaskController.exetaskupload()");
						ArrayList<Telnum> telnum = this.queryTelNumService
								.getTelnum("2");
						map.put("status", true);
						// map.put("dxflag", "01");
						map.put("telnum", telnum);
						// map.put("lastdevice", "0");
						map.put("msg", "上传巡检记录成功，所有设备巡检完毕");
						// 巡检完成
						// 向科长发送短信
						String tel = "";
						ArrayList<Telnum> tels = this.queryTelNumService
								.getTelnum(KEZHANG);
						for (int i = 0; i < tels.size(); i++) {
							if (i == tels.size() - 1) {
								tel += tels.get(i).getContact_tel();
							} else {
								tel += tels.get(i).getContact_tel() + ",";
							}
						}
						String msg = banCi + "班次已经完成巡检";
						SendMSGUtil sm = new SendMSGUtil();
						sm.sendByHttp(tel, msg, tels.size() + "");
						// sendByHttp(tel, msg, tels.size() + "");
					} else {
						map.put("status", true);
						// map.put("lastdevice", "0");
						map.put("msg", "上传巡检记录成功,更新任务状态失败");
					}
				} catch (Exception e) {

					// TODO: handle exception
				}
			} else if (exetotalquipcount == 1) {
				int m = 0;
				// map.put("dxflag", "00");
				try {
					m = this.querytaskService.updatetaskstatu(task_id);
					if (m > 0) {

					} else {
						map.put("status", true);
						map.put("lastdevice", "0");
						map.put("msg", "上传巡检记录成功,更新任务状态失败");
					}
				} catch (Exception e) {

					// TODO: handle exception
				}
			} else {
				// map.put("dxflag", "00");

				if (totalequipcount - exetotalquipcount == 1) {
					// map.put("status", true);
					map.put("lastdevice", "1");// 标记还剩最后一台设备

				} else {
					map.put("lastdevice", "0");
				}
			}
		} else {
			map.put("status", true);
			map.put("lastdevice", "0");
			map.put("msg", "上传图片成功");
		}

		setJsonResult(map);
		System.out.println(jsonResult.toString());
		ResultUtils.toJson(request, resp, this.jsonResult);
		return "showUser";

	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * 创建图片资源
	 * 
	 * @param imgStr
	 * @param filename
	 * @param logoRealPathDir
	 */
	public void createbmp(String imgStr, String filename, String logoRealPathDir) {
		BASE64Decoder decoder = new BASE64Decoder();
		String logImageName = null;
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			logImageName = filename + ".jpg";// 构建文件名称
			/** 拼成完整的文件保存路径加文件* */
			String fileName = logoRealPathDir + File.separator + logImageName;
			OutputStream out = new FileOutputStream(fileName);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
