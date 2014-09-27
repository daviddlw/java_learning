package com.david.spring.beans;

import java.util.Map;

public class NewPerson
{
	private String name;

	private int age;

	private Map<String, Car> mapCar;

	public NewPerson()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NewPerson(String name, int age, Map<String, Car> mapCar)
	{
		super();
		this.name = name;
		this.age = age;
		this.mapCar = mapCar;
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

	public Map<String, Car> getMapCar()
	{
		return mapCar;
	}

	public void setMapCar(Map<String, Car> mapCar)
	{
		this.mapCar = mapCar;
	}

	@Override
	public String toString()
	{
		return "NewPerson [name=" + name + ", age=" + age + ", car=" + mapCar + "]";
	}

}
