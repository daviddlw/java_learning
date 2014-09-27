package com.david.spring.beans;

public class Car
{
	private String brand;
	private String corp;
	private double price;
	private int maxSpeed;

	public Car()
	{
		super(); // TODO Auto-generated constructor stub
		System.err.println("Car's Constructor");
	}

	public Car(String brand, String corp, double price)
	{
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}

	public Car(double price, String brand)
	{
		super();
		this.brand = brand;
		this.price = price;
	}

	public Car(String brand, String corp, double price, int maxSpeed)
	{
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
		this.maxSpeed = maxSpeed;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getCorp()
	{
		return corp;
	}

	public void setCorp(String corp)
	{
		this.corp = corp;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getMaxSpeed()
	{
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString()
	{
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}

}
