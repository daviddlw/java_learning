package com.david.spring.beans;

public class HelloWorld
{
	private String name;

	public HelloWorld()
	{
		// TODO Auto-generated constructor stub
		System.out.println("HelloWorld Constructor");
	}

	public HelloWorld(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		System.out.println("Set Property Name: " + name);
	}

	public void hello()
	{
		System.out.println("Welcome to Spring World, " + name);
	}

	@Override
	public String toString()
	{
		return "HelloWorld [name=" + name + "]";
	}

}
