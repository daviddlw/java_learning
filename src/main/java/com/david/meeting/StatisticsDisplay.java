package com.david.meeting;

public class StatisticsDisplay extends ICustomObserver
{
	public StatisticsDisplay()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsDisplay(String name)
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
		return "StatisticsDisplay [name=" + name + "]";
	}
}
