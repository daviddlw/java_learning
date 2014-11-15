package com.david.algorithm;

public class TestRunFunction
{
	public static void main(String[] args)
	{
		fun(100);
	}

	private static void fun(short i)
	{
		System.out.println("short i=" + i);
	}

	private static void fun(int i)
	{
		System.out.println("int i=" + i);
	}
	
	private static void fun(long i)
	{
		System.out.println("long i=" + i);
	}
	
	private static void fun(double i)
	{
		System.out.println("double i=" + i);
	}
	
	private static void fun(Object i)
	{
		System.out.println("Object i=" + i);
	}

}
