package com.david.meeting;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements ISubject
{
	private double temperature;
	private double humidity;
	private double pressure;
	private List<ICustomObserver> observerLs = new ArrayList<ICustomObserver>();

	public WeatherData()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerObserver(ICustomObserver observer)
	{
		observerLs.add(observer);
	}

	@Override
	public void removeObserver(String name)
	{
		ICustomObserver delObj = null;
		for (ICustomObserver item : observerLs)
		{
			if (item.getName().equalsIgnoreCase(name))
			{
				delObj = item;
			}
		}
		if (delObj != null)
			observerLs.remove(delObj);
	}

	public WeatherData(double temperature, double humidity, double pressure)
	{
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public void updateWeatherData(double temperature, double humidity, double pressure)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		System.err.println("温度发生改变，通知所有观察者...");
		notifyObservers();
	}

	public double getTemperature()
	{
		return temperature;
	}

	public void setTemperature(double temperature)
	{
		this.temperature = temperature;
	}

	public double getHumidity()
	{
		return humidity;
	}

	public void setHumidity(double humidity)
	{
		this.humidity = humidity;
	}

	public double getPressure()
	{
		return pressure;
	}

	public void setPressure(double pressure)
	{
		this.pressure = pressure;
	}

	@Override
	public String toString()
	{
		return "WeatherData [temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + "]";
	}

	@Override
	public void notifyObservers()
	{
		// TODO Auto-generated method stub
		for (ICustomObserver item : observerLs)
		{
			item.update(new WeatherData(temperature, humidity, pressure));
		}
	}

}
