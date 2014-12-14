package com.david.meeting;

public class ForecastDisplay extends ICustomObserver
{
	public ForecastDisplay()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ForecastDisplay(String name)
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
		return "ForecastDisplay [name=" + name + "]";
	}
}
