package com.david.spring.factorybean;

import java.util.HashMap;
import java.util.Map;

public class InstanceBeanFactory
{
	private Map<String, Car> rsMap = new HashMap<String, Car>();

	public InstanceBeanFactory()
	{
		// TODO Auto-generated constructor stub
		rsMap.put("audi", new Car("audi_instance", 888));
		rsMap.put("bmw", new Car("bmw_instance", 666));
	}

	public Car getCar(String name, double price)
	{
		if (rsMap.containsKey(name))
		{
			return rsMap.get(name);
		} else
		{
			return null;
		}
	}

}
