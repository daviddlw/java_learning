package com.david.spring.aopsp;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class AnotherLoggingAspectJ
{
	@Before("LoggingAspectJ.declareJoinPointExpression()")
	public void validationMethod(JoinPoint point)
	{
		System.out.println("-->The method " + point.getSignature().getName() + " validate the args "
				+ Arrays.asList(point.getArgs()));
	}
}
