package com.david.spring.aopconf;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class LoggingAspectJ
{

	public void declareJoinPointExpression()
	{
	}

	public void beforeMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		String args = Arrays.toString(point.getArgs());
		System.out.println(String.format("before %s method begin %s", methodName, args));
	}

	public void afterMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		Object result = point.getKind();
		System.out.println("The method end");
	}

	public void afterReturningMethod(JoinPoint point, Object results)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " result is " + results);
	}

	public void afterThrowingMethod(JoinPoint point, Exception ex)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}

}
