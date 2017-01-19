package com.cn.hnust.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.cn.hnust.tool.ResultUtils;

import javax.annotation.Resource;              
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;           
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;  

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IQuerytaskService;
import com.cn.hnust.service.IUserService;
import com.sun.mail.iap.Response;
                                              
@Controller                                    
public class AppverController {    
	private Map<String, Object> jsonResult; 
    private static final String TYPE_APK = "apk";
    @SuppressWarnings("null")
 	@RequestMapping("/ApkUpdateService/ver")               
     public String toindex(HttpServletRequest request,Model model,HttpServletResponse resp) throws IOException{  
    	     Map map = new HashMap();      
    	     Properties prop = new Properties(); 
    	     InputStream in = this.getClass().getClassLoader().getResourceAsStream("/appver.properties");      	     
    	     try {    	    	
    	         prop.load(in);     	    
    	     } catch (IOException e) { 
    	      e.printStackTrace(); 
    	     }  	       	     
    	     System.out.println(prop.getProperty("verCode"));
    	     map.put("verCode", prop.getProperty("verCode"));
    	     map.put("verName", prop.getProperty("verName"));
    	     map.put("status",true);
             setJsonResult(map);
             System.out.println(jsonResult.toString());
             ResultUtils.toJson(request,resp, this.jsonResult);
             return "showUser";    
 } 
    /**
     * 下载app
     * @param request
     * @param response
     */
    @RequestMapping(value="/ApkUpdateService/abchina.apk")
    public void getApp(HttpServletRequest request,HttpServletResponse response){
        try {
            this.downloadFile(request, response,TYPE_APK, "ApkUpdate/abchina.apk");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void downloadFile(HttpServletRequest request,HttpServletResponse response,String type,String fileName)throws IOException{
        String path = request.getServletContext().getRealPath("/");
        if(StringUtils.isEmpty(path)) 
        {
        	System.out.println("AppverController.downloadFile()");
        	return;
        }
        System.out.println(path);
      
        if(path.contains("\\") == true )
           path = path.replace("\\", "/");
        System.out.println(path);
        path = path.concat(fileName);
        File file = new File(path);
        if(file == null || !file.exists()|| !file.isFile())
            return;
        response.setHeader("Content-Length", String.valueOf(file.length()));  
        InputStream in = new FileInputStream(file);
        BufferedInputStream bin = new BufferedInputStream(in);
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(out);
        FileCopyUtils.copy(bin, bout);
    }
    
       public void setJsonResult(Map<String, Object> jsonResult) {    	   
    	     this.jsonResult = jsonResult;
    	   }
    
}
