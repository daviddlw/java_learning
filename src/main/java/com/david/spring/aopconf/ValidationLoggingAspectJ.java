package com.david.spring.aopconf;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidationLoggingAspectJ
{
	public void validationMethod(JoinPoint point)
	{
		System.out.println("-->The method " + point.getSignature().getName() + " validate the args "
				+ Arrays.asList(point.getArgs()));
	}
}
