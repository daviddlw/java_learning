package com.david.spring.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun
{
	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springCycle.xml");

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		springCycleDemo();
	}

	private static void springCycleDemo()
	{
		Car car = (Car)ctx.getBean("carBeanCycle");
		System.out.println(car);
		ctx.close();
	}
}
