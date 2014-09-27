package com.david.spring.beans;

import java.util.List;

public class PersonCollection
{
	private String name;

	private int age;

	private List<Car> carList;

	public PersonCollection()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonCollection(String name, int age, List<Car> carList)
	{
		super();
		this.name = name;
		this.age = age;
		this.carList = carList;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public List<Car> getCarList()
	{
		return carList;
	}

	public void setCarList(List<Car> carList)
	{
		this.carList = carList;
	}

	@Override
	public String toString()
	{
		return "PersonCollection [name=" + name + ", age=" + age + ", car=" + carList + "]";
	}

}
