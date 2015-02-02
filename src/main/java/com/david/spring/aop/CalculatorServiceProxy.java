package com.david.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorServiceProxy
{
	private CalculatorService target;

	public CalculatorServiceProxy()
	{
		// TODO Auto-generated constructor stub
	}

	public CalculatorServiceProxy(CalculatorService target)
	{
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	public CalculatorService getCalculatorServiceProxy()
	{
		CalculatorService proxy = null;
		// 得到需要代理的类的加载器，因为他不是被new出来的
		ClassLoader loader = target.getClass().getClassLoader();
		// 得到需要代理的类的接口类型数组
		// Class<?>[] interfaces = new Class[] { CalculatorService.class };
		Class<?>[] interfaces = target.getClass().getInterfaces();
		// invokeHandler真正的代理执行的方法
		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
			{
				// 一般不调用proxy自己的方法，因为会引起死循环
				String info = String.format("The method %s start with %s", method.getName(), Arrays.toString(args));
				System.err.println(info);
				Object result = null;
				try
				{
					//前置通知
					
					// 调用相关方法invoke
					result = method.invoke(target, args);
					
					//后置通知
				} catch (Exception e)
				{					
					//异常通知
					e.printStackTrace();
				}

				String resultInfo = String.format("The result is %s", result.toString());
				System.err.println(resultInfo);
				return result;
			}
		};

		proxy = (CalculatorService) Proxy.newProxyInstance(loader, interfaces, handler);

		return proxy;
	}
}
