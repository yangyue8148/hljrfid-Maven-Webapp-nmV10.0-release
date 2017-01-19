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

import com.cn.hnust.pojo.Telnum;
import com.cn.hnust.service.QueryTelNumService;
import com.cn.hnust.tool.ResultUtils;

@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class QuerySmsTelController {
	
	@Resource
	private QueryTelNumService queryTelNumService;

	@SuppressWarnings("null")
	@RequestMapping(value = "/tel")
	public String getSmsTel(HttpServletRequest request, Model model,HttpServletResponse resp) throws IOException {
		String type = request.getParameter("contact_type");
System.out.println("11111111");
		 ArrayList<Telnum> telnum = this.queryTelNumService.getTelnum(type);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Telnum", telnum);
		map.put("status", true);
		System.out.println(map);
		ResultUtils.toJson(request, resp, map);
		
		return "showUser";

	}

}
