package com.david.meeting;

public class CurrentConditionDisplay extends ICustomObserver
{
	public CurrentConditionDisplay()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentConditionDisplay(String name)
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
		return "CurrentConditionDisplay [name=" + name + "]";
	}
}
