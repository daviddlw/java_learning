package com.david.meeting;

public class NewObserver extends ICustomObserver
{
	public NewObserver()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NewObserver(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(WeatherData data)
	{
		// TODO Auto-generated method stub
		System.out.println(this.toString() + "-" + data);
	}

	@Override
	public String toString()
	{
		return "NewObserver [name=" + name + "]";
	}
}
