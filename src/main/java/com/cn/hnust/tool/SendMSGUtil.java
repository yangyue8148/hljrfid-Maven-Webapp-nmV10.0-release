package com.cn.hnust.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class SendMSGUtil {

	private String address;
	private int port;
	private Properties prop;

	public SendMSGUtil() {
		super();
		 prop = new Properties(); 
	     InputStream in = this.getClass().getClassLoader().getResourceAsStream("/SendAddress.properties");      	     
	     try {    	    	
	         prop.load(in);     	    
	     } catch (IOException e) { 
	      e.printStackTrace(); 
	     }  
	}

	public void sendByHttp(String contact, String msg, String num) {
		try {
			address = prop.getProperty("address");
			String string = prop.getProperty("port");
			port = Integer.parseInt(string);
			System.out.println("我要发短信了==========  address   "+address);
			System.out.println("我要发短信了==========  port   "+port);
			// 1.建立客户端socket连接，指定服务器位置及端口
			Socket socket = new Socket(address, port);
			// Socket socket = new Socket("10.139.20.101", 9991);
			// 2.得到socket读写流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			// 输入流
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// 3.发送给 平台的 数据
			String info = num + "|" + contact + "|" + msg;
			pw.write(info);
			pw.flush();
			socket.shutdownOutput();
			// 接收服务器的相应
			String reply = null;
			while (!((reply = br.readLine()) == null)) {
				System.out.println("接收服务器的信息：" + reply);
			}
			// 4.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
