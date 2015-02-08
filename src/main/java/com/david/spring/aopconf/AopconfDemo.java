package com.david.spring.aopconf;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopconfDemo
{
	private static Logger logger = Logger.getLogger(AopconfDemo.class.getSimpleName());
	public static void main(String[] args)
	{
		logger.info("AopconfDemo Start...");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-spring-conf.xml");
		CalculatorService service = (CalculatorService) ctx.getBean("calculatorService");
		System.out.println(service.getClass().getName());
		int add = service.add(1, 2);
		int divide = service.divide(12, 6);
		System.out.println("add result: " + add);
		System.out.println("divide result: " + divide);
		ctx.close();
		logger.info("AopconfDemo End...");
	}
}
