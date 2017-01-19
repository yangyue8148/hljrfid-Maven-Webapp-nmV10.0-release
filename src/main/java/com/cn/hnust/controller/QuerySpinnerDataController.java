package com.cn.hnust.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.cn.hnust.pojo.ModelInfo;
import com.cn.hnust.pojo.TypeInfo;
import com.cn.hnust.pojo.brandInfo;
import com.cn.hnust.service.BrandInfoService;
import com.cn.hnust.service.ModelInfoService;
import com.cn.hnust.service.TypeInfoService;
import com.cn.hnust.tool.ResultUtils;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class QuerySpinnerDataController {
	private Map<String, Object> jsonResult;
	@Resource
	private TypeInfoService typeInfoService;
	@Resource
	private BrandInfoService brandInfoService;
	@Resource
	private ModelInfoService modelInfoService;
	/**
	 * 下拉菜单的编号
	 */
	private String code;

	@SuppressWarnings("null")
	@RequestMapping(value = "/getData")
	public String exetaskupload(HttpServletRequest request, Model model,
			HttpServletResponse resp) throws IOException {
		MultipartHttpServletRequest upLoadRequest = (MultipartHttpServletRequest) request;

		code = upLoadRequest.getParameter("code");

		HashMap<String, Object> backData = new HashMap<>();
		ArrayList<Object> list = new ArrayList<>();
		switch (code) {
		// 第一下拉菜单
		case "1":
			ArrayList<TypeInfo> typeInfo = this.typeInfoService
					.selectByPrimaryKey();

			// for (TypeInfo bean : typeInfo) {
			// list.add(bean);
			// }
			// System.out.println("222222222222222222222222222222222222-----------------");
			// TypeInfo selectByPrimaryKey2 =
			// this.typeInfoService.selectByPrimaryKey();
			// System.out.println("11111111111111111111111111111111-----------"+selectByPrimaryKey2.getTypeName());
			// list.add(selectByPrimaryKey2);
			TypeInfo ti = new TypeInfo();
			ti.setTypeId("000");
			ti.setTypeName("请选择");
			typeInfo.add(0, ti);
			backData.put("1", typeInfo);
			// 将数据发送给终端
			ResultUtils.toJson(request, resp, backData);
			break;
		// 第二下拉菜单
		case "2":
			String Brand_type = upLoadRequest.getParameter("typeId");

			ArrayList<brandInfo> brandInfo = this.brandInfoService
					.selectByPrimaryKey(Brand_type);

			backData.clear();
			backData.put("2", brandInfo);
			ResultUtils.toJson(request, resp, backData);
			break;
		// 第三下拉菜单
		case "3":
			String Model_brand = upLoadRequest.getParameter("brandId");
			ArrayList<ModelInfo> selectByPrimaryKey = this.modelInfoService
					.selectByPrimaryKey(Model_brand);

			backData.clear();
			backData.put("3", selectByPrimaryKey);
			ResultUtils.toJson(request, resp, backData);
			break;
		// 错误提示 没有传code值
		default:

			break;
		}

		return null;

	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

}
