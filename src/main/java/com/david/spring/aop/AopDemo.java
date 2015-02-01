package com.david.spring.aop;

public class AopDemo
{
	public static void main(String[] args)
	{
		CalculatorService service = new CalculatorServiceImpl();
		CalculatorService serviceProxy = new CalculatorServiceProxy(service).getCalculatorServiceProxy();
		
		int add = serviceProxy.add(1, 2);
		int minus = serviceProxy.minus(1, 2);
		System.out.println(add);
		System.out.println(minus);
	}
}
