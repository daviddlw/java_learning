package com.david.spring.aopsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopspDemo
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-spring.xml");
		CalculatorService service = (CalculatorService)ctx.getBean("calculatorServiceImpl");
		int add = service.add(1, 2);
		int divide = service.divide(12, 6);
		System.out.println(add);
		System.out.println(divide);		
	}
}
