package com.david.spring.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun
{
	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cycle.xml");

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// springCycleDemo();
		// springLifeTimeDemo();
	}

	private static void springCycleDemo()
	{
		Car car = (Car) ctx.getBean("carBeanCycle");
		System.out.println(car);
		ctx.close();
	}

	/**
	 * spring IOC容器管理bean对象的生命周期
	 */
	private static void springLifeTimeDemo()
	{
		System.out.println("1. 通过构造器或者工厂方法创建bean对象");
		System.out.println("2. 为bean对象属性赋值和引用相关bean对象");
		System.out.println("3. 调用bean的初始化方法");
		System.out.println("4. 可以使用bean对象了");
		System.out.println("5. 调用bean的销毁方法");
	}
}
