package com.david.meeting;

public class HuaWeiMeeting
{
	public static void main(String[] args)
	{
		// String str = "1234";
		// changeStr(str);
		// System.out.println(str);
		//
		// int num = 123;
		// changeInt(123);
		// System.out.println(num);
		//
		// B b = new B();
		// System.out.println(b.test(1, 2));
		// System.out.println(b.test(1, 2l));

		Person p = new Person(1, "david.dai");
		changeObj(p);
		System.out.println(p);
		System.out.println("hashcode: " + p.hashCode());
	}

	public static void changeObj(Person p)
	{
		p.setId(2);
		p.setName("redis");
		System.out.println(p.hashCode());
	}

	public static void changeStr(String str)
	{
		str = "welcome";
	}

	public static void changeInt(int a)
	{
		a = 88;
	}
}

class Person
{
	private int id;
	private String name;

	public Person(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public Person()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + "]";
	}

}

class A
{
	protected int test(int a, int b)
	{
		return 0;
	}
}

class B extends A
{
	@Override
	protected int test(int a, int b)
	{
		// TODO Auto-generated method stub
		return super.test(a, b);
	}

	public int test(int a, long b)
	{
		// TODO Auto-generated method stub
		return 1;
	}
}
