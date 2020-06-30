package com.bawei.hgshop;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动服务
 * @author 45466
 *
 */
public class StartUserService {
	
	public static void main(String[] args) throws IOException {
		System.out.println("启动用户服务");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo-provider.xml",
				"classpath:applicationContext-dao.xml");
		System.out.println("启动用户完成，可以开始调用服务");
		// 进行阻塞
		System.in.read();
		
	}

}
