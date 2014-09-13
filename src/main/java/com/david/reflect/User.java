package com.david.reflect;

import java.io.Serializable;

public class User implements Serializable, Comparable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private int age;
	private double salary;

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private User(String name, String password)
	{
		super();
		salary = 0;
	}

	public User(String name, String password, int age)
	{
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void sayHello()
	{
		System.err.println("你好");
	}

	private void smoking()
	{
		System.err.println("抽烟");
	}

	public void showMessage(String message)
	{
		System.err.println("Message： " + message);
	}

	@Override
	public String toString()
	{
		return "User [name=" + name + ", password=" + password + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
