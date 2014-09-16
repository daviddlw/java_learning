package com.david.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicReflectDemo
{
	public static void main(String[] args)
	{
		IHelloWorld hwImpl = new HelloWorldImpl();
		hwImpl.sayHello("aa");
		System.err.println("===========================");
		HelloWorldProxy hwProxy = new HelloWorldProxy(hwImpl);
		IHelloWorld hw = (IHelloWorld) Proxy.newProxyInstance(hwImpl.getClass().getClassLoader(), hwImpl.getClass().getInterfaces(),
				hwProxy);
		hw.sayHello("你好...");
	}
}

/**
 * * 接口 * @author David.Dai * @version $Id: DynamicReflectDemo.java, v 0.1
 * 2014年9月16日 上午12:12:15 David.Dai Exp $
 */
interface IHelloWorld
{
	public void sayHello(String name);
}

/**
 * * 委托类 * @author David.Dai * @version $Id: DynamicReflectDemo.java, v 0.1
 * 2014年9月16日 上午12:13:15 David.Dai Exp $
 */
class HelloWorldImpl implements IHelloWorld
{

	@Override
	public void sayHello(String name)
	{
		System.out.println("Hello, " + name);
	}

}

/**
 * * 代理类, 可以加入你需要处理的添加的内容，日志，权限等等 * @author David.Dai * @version $Id:
 * DynamicReflectDemo.java, v 0.1 2014年9月16日 上午12:12:57 David.Dai Exp $
 */
class HelloWorldProxy implements InvocationHandler
{
	Object delegateObj = null;

	public HelloWorldProxy(Object delegateObj)
	{
		this.delegateObj = delegateObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object result = null;
		logBefore();
		result = method.invoke(delegateObj, args);
		logAfter();

		return result;
	}

	private void logBefore()
	{
		System.err.println("logBefore...");
	}

	private void logAfter()
	{
		System.err.println("logAfter...");
	}

}
