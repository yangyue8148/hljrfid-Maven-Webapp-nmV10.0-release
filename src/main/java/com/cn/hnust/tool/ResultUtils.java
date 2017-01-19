package com.cn.hnust.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;



public class ResultUtils {
	public static void toJson(HttpServletRequest request,HttpServletResponse response, Object data) throws IOException{
		Gson gson = new Gson();
		String result = gson.toJson(data);
		System.out.println("ResultUtils.toJson()");
		System.out.println(result);
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Cache-Control","no-cache"); //取消浏览器缓存
		HttpSession seesion = request.getSession();
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	
}
