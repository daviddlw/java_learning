package com.david.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("postProcessAfterInitialization...");
		System.out.println("bean name: " + beanName);
		if (bean instanceof Car)
		{
			Car car = (Car) bean;
			System.out.println("Car‘s name: " + car.getName());
		}

		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("postProcessAfterInitialization...");
		System.out.println("bean name: " + beanName);
		Car newCar = new Car("宝马X5");

		return newCar;
	}

}
