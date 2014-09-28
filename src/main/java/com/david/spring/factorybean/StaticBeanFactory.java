package com.david.spring.factorybean;

import java.util.HashMap;
import java.util.Map;

public class StaticBeanFactory
{
	private static Map<String, Car> rsMap = new HashMap<String, Car>();

	static
	{
		rsMap.put("audi", new Car("audi", 300000));
		rsMap.put("bmw", new Car("ford", 500000));
	}

	public static Car getCar(String name)
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
