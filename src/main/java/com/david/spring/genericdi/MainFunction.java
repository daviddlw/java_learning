package com.david.spring.genericdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFunction
{
	public static void main(String[] args)
	{
		execteDemo();
	}

	private static void execteDemo()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-genericdi.xml");
		BaseService<User> userService = (UserService)ctx.getBean("userService");
		userService.execte();
		System.out.println(ctx.getEnvironment());
	}
}
