package com.david.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.annotation.controller.UserController;
import com.david.spring.annotation.repository.IUserRepository;
import com.david.spring.annotation.service.UserService;

public class MainFunction
{

	public static void main(String[] args)
	{
		// runTest();
		autowiredDemo();
	}

	private static void runTest()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		TestObject testObj = (TestObject) ctx.getBean("testObject");
		System.out.println(testObj);

		UserService userService = (UserService) ctx.getBean("userService");
		System.out.println(userService);

		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);

		IUserRepository userRepository = (IUserRepository) ctx.getBean("userRepository");
		System.out.println(userRepository);
	}

	private static void autowiredDemo()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.display();
	}

}
