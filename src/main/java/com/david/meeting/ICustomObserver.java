package com.david.meeting;

public abstract class ICustomObserver
{
	protected String name;

	public ICustomObserver()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ICustomObserver(String name)
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
	}

	public abstract void update(WeatherData data);

}
