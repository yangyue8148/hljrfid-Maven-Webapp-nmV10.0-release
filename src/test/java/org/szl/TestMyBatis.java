package org.szl;


import javax.annotation.Resource;  
  


import org.apache.log4j.Logger;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  


import com.alibaba.fastjson.JSON;  
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})    
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
    	System.out.println("TestMyBatis.test1()");
        User user = userService.getUserById("e10adc3949ba59abbe56e057f20f883e","000001");  
         System.out.println(user.getUserName());  
         logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(user));

    }
    
    

}
