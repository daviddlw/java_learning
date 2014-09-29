package com.david.spring.relation;

public class AutoWiredPerson
{
	private String name;

	private Address autoWiredAddress;

	private Car autoWiredCar;

	public AutoWiredPerson()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoWiredPerson(String name, Address autoWiredAddress, Car autoWiredCar)
	{
		super();
		this.name = name;
		this.autoWiredAddress = autoWiredAddress;
		this.autoWiredCar = autoWiredCar;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Address getAutoWiredAddress()
	{
		return autoWiredAddress;
	}

	public void setAutoWiredAddress(Address autoWiredAddress)
	{
		this.autoWiredAddress = autoWiredAddress;
	}

	public Car getAutoWiredCar()
	{
		return autoWiredCar;
	}

	public void setAutoWiredCar(Car autoWiredCar)
	{
		this.autoWiredCar = autoWiredCar;
	}

	@Override
	public String toString()
	{
		return "AutoWiredPerson [name=" + name + ", autoWiredAddress=" + autoWiredAddress + ", autoWiredCar=" + autoWiredCar
				+ "]";
	}

}
