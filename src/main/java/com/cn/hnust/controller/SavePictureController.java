package com.cn.hnust.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Decoder.BASE64Decoder;

import com.cn.hnust.dao.brandInfoDao;
import com.cn.hnust.dao.ModelInfoDao;
import com.cn.hnust.dao.TypeInfoDao;
import com.cn.hnust.tool.ResultUtils;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class SavePictureController {
	// 设备规格
	@Resource
	private ModelInfoDao modelInfoDao;

	private String imgStr;
	private String Model_id;

	private Map<String, Object> map;
	private MultipartHttpServletRequest multipartRequest;

	private String picname;

	@SuppressWarnings("null")
	@RequestMapping(value = "/savepic")
	public String getSmsTel(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws IOException {
		multipartRequest = (MultipartHttpServletRequest) request;

		map = new HashMap<String, Object>();

		String logoPathDir = "D:/normalPic/";
		//String logoPathDir = "C:/normalPic/";
		/** 根据真实路径创建目录* */
		File logoSaveFile = new File(logoPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();

		getUpLoadData();

		// 获取拍照图片

		/** 创建图片 **/
		createbmp(imgStr, Model_id, logoPathDir);
		// 构建文件名称
		String logImageName = Model_id + ".jpg";// 构建文件名称
		Model_id = logImageName.trim();
		/** 打印出上传到服务器的文件的绝对路径* */
		// System.out.println("****************"+fileName+"**************");
		// System.out.println("****************"+rdnflag+"**************");
        map.put("status", true);
		ResultUtils.toJson(request, resp, map);

		return "showUser";

	}

	/**
	 * 获得上传的数据
	 * 
	 * @return
	 */
	private void getUpLoadData() {

		Model_id = multipartRequest.getParameter("picname");
		// picname = multipartRequest.getParameter("picname");
		imgStr = multipartRequest.getParameter("bitbase");
		System.out.println(imgStr
				+ "``````````````````````````````````````````````````````````");
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
			// 插入数据库
			int num = this.modelInfoDao.updateByPrimaryKey(Model_id, picname);
			boolean status = false;
			if (num > 0) {
				status = true;
			}
			map.put("status", status);
		} catch (Exception e) {

		}

	}
}
