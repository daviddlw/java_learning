package com.david.algorithm;

public class TestInheritedClass
{
	public static void main(String[] args)
	{
		ParentClass obj = new ChildClass();
		obj.fun();
	}
}

class ParentClass
{
	static int i = 200;

	public void fun()
	{
		System.out.println("i=" + i + " fun() in ParentClass");
	}
}

class ChildClass extends ParentClass
{
	static int i = 300;

	@Override
	public void fun()
	{
		System.out.println("i=" + i + " fun() in ChildClass");
	}
}
