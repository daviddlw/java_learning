package com.david.spring.aopsp;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectJ
{

	@Before("execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))")
	public void beforeMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		String args = Arrays.toString(point.getArgs());
		System.out.println(String.format("before %s method begin %s", methodName, args));
	}

	@After("execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))")
	public void afterMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		Object result = point.getKind();
		System.out.println("The method end");
	}

	@AfterReturning(value = "execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))", returning = "results")
	public void afterReturningMethod(JoinPoint point, Object results)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " result is " + results);
	}

	@AfterThrowing(value = "execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))", throwing = "ex")
	public void afterReturningMethod(JoinPoint point, Exception ex)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}
}
