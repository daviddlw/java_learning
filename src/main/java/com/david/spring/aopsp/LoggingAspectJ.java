package com.david.spring.aopsp;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LoggingAspectJ
{

	@Pointcut("execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))")
	public void declareJoinPointExpression()
	{
	}

	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		String args = Arrays.toString(point.getArgs());
		System.out.println(String.format("before %s method begin %s", methodName, args));
	}

	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint point)
	{
		String methodName = point.getSignature().getName();
		Object result = point.getKind();
		System.out.println("The method end");
	}

	@AfterReturning(value = "declareJoinPointExpression()", returning = "results")
	public void afterReturningMethod(JoinPoint point, Object results)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " result is " + results);
	}

	@AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
	public void afterReturningMethod(JoinPoint point, Exception ex)
	{
		String methodName = point.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}

	// @Around("execution(public int com.david.spring.aopsp.CalculatorService.*(int, int))")
	// public Object arroundMethod(ProceedingJoinPoint pjt)
	// {
	// Object result = null;
	// String methodName = pjt.getSignature().getName();
	//
	// try
	// {
	// // 前置通知
	// System.out.println("The method " + methodName + " begin with " +
	// Arrays.asList(pjt.getArgs()));
	// result = pjt.proceed();
	//
	// // 返回通知
	// System.out.println("The method " + methodName + " result is " + result);
	//
	// } catch (Throwable e)
	// {
	// // 异常通知
	// System.out.println("The method " + methodName + " occurs an exception: "
	// + e);
	// throw new RuntimeException(e);
	// }
	// // 后置通知
	// System.out.println("The method ends");
	//
	// return result;
	// }
}
