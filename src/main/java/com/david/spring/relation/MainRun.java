package com.david.spring.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring.relation.Car;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MainRun
{
	private static ApplicationContext brCtx = new ClassPathXmlApplicationContext("beanRelation.xml");

	public static void main(String[] args)
	{
		// springDiFromOutfileBeanDemo();
		// spelSpringDemo();
		springRelationDemo();
		// test();
	}

	private static void test()
	{
		Car car = (Car) brCtx.getBean("test");
		System.out.println(car);
	}

	/**
	 * spring bean之间的关系
	 */
	private static void springRelationDemo()
	{
		Address address = (Address) brCtx.getBean("address");
		System.out.println(address);

		Address address2 = (Address) brCtx.getBean("address2");
		System.out.println(address2);

		AutoWiredPerson awp = (AutoWiredPerson) brCtx.getBean("person");
		System.out.println(awp);

		Car car = (Car) brCtx.getBean("scopeCarBean");
		Car car2 = (Car) brCtx.getBean("scopeCarBean");

		System.out.println(car == car2);
	}

	/**
	 * spring读取外部文件
	 */
	private static void springDiFromOutfileBeanDemo()
	{
		ComboPooledDataSource cpds = (ComboPooledDataSource) brCtx.getBean(ComboPooledDataSource.class);
		System.out.println("User: " + cpds.getUser());
		System.out.println("Password: " + cpds.getPassword());
		System.out.println("Url: " + cpds.getJdbcUrl());
		System.out.println("Driver: " + cpds.getDriverClass());
	}

	/**
	 * spring spel表达式
	 */
	private static void spelSpringDemo()
	{
		Car car = (Car) brCtx.getBean("spelBean");
		System.out.println(car);
	}
}
