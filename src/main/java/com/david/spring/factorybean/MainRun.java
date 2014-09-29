package com.david.spring.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun
{
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("factory-bean.xml");

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		factoryBeanDemo();
	}

	private static void factoryBeanDemo()
	{
		AbstractHuman human = (AbstractHuman) ctx.getBean("humanFactoryBean");
		System.out.println(human);
	}
}
