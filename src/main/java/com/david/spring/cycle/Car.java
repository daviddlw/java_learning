package com.david.spring.cycle;

public class Car
{
	private String name;

	public Car()
	{
		System.out.println("Car's constructor...");
		// TODO Auto-generated constructor stub
	}

	public Car(String name)
	{
		super();
		this.name = name;
		System.out.println("Car's parameterized constructor...");
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		System.out.println("Set property name: " + name);
	}

	public void initObject()
	{
		System.out.println("init...");
	}

	public void destroyObject()
	{
		System.out.println("destroy...");
	}

	@Override
	public String toString()
	{
		return "Car [name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
