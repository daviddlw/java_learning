package com.david.spring.aopsp;

import org.springframework.stereotype.Component;

@Component
public class LoggingAspectJ
{
	
	public void beforeMethod()
	{
		System.out.println("before method begin");
	}
}
