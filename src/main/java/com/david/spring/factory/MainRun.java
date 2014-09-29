package com.david.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun
{
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("factory.xml");
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		staticBeanFactoryDemo();
	}
	
	private static void staticBeanFactoryDemo()
	{
		Car car1 = (Car)ctx.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car)ctx.getBean("car2");
		System.out.println(car2);
	}

}
