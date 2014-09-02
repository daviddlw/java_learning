package com.david.meeting;

/**
 * 10道java经典面试题
 * 
 * @author pc
 * 
 */
public class ClassicMeetingIssue
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		question2();
	}

	/*
	 * Q1: int与Integer的区别 int基本数据类型，Integer引用数据类型（是个对象）
	 * num没有属性，i有属性与方法i为num的封装类（即Integer是int的封装类）
	 */
	private static void question1()
	{
		int num = 100;
		Integer i = 100;

		/*
		 * 
		 */
		i = num; // 装箱
		num = i; // 拆箱
	}

	/*
	 * Q2：==与equals有什么区别 Answer: ==如果两边是数值，比较的是值是否相等，如果两边是对象比较的是引用是否相等
	 * equals比较的是两个对象的内容是否相同
	 */
	private static void question2()
	{
		int a = 100;
		int b = 100;
		System.err.println("a==b: " + (a == b));

		Integer c = 200;
		Integer d = 200;
		System.err.println("c==d: " + (c == d));
		System.err.println("c.equals: " + c.equals(d));

		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");

		System.err.println("s1==s2: " + (s1 == s2));
		System.err.println("s2==s3: " + (s2 == s3));

		System.err.println("s1.equals(s2): " + s1.equals(s2));
		System.err.println("s2.equals(s3): " + s2.equals(s3));
	}
	
	/*
	 * Q3: 面向对象的三大特征
	 * 封装：一个类就是一个封装体
	 * 继承：java属于单根继承，好处是提高了代码的复用性
	 * 多态：同一种行为在不同的对象上有不同的表现形式
	 * 1. 有继承 2.重写 3.父类的引用指向子类对象
	 */

}
