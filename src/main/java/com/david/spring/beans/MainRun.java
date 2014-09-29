package com.david.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class MainRun
{
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static void main(String[] args)
	{
		// runWithSpringBean();
		// constructorDIDemo();
		// autoWiredDemo();
		// springOutfileBeanDemo();
		// spelSpringDemo();
		// springLifeTimeDemo();
	}

	private static void runWithCommon()
	{
		// 1. 创建对象
		HelloWorld hw = new HelloWorld();
		// 2. 为属性赋值
		hw.setName("david.dai");
		// 3. 调用方法
		hw.hello();
	}

	private static void runWithSpringBean()
	{
		// 1. 创建Spring的IOC容器对象，
		// ApplicationContext是个IOC容器,ClassPathXmlApplicationContext类路径家在配置文件
		// close与refresh让ApplicationContext有了启动，刷新和关闭上下文的能力
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2. 从IOC容器获取Bean实例
		// HelloWorld hwBean = ctx.getBean(HelloWorld.class);
		HelloWorld hwBean = (HelloWorld) ctx.getBean("helloWorld");

		// 3. 调用hello方法
		hwBean.hello();

		/*
		 * IOC：反转资源获取方向，容器主动将资源推送给它所管理的组件，组件 所需要做的仅仅是选择一个合适的方式磊接受资源
		 * DI：依赖注入，就是IOC的另外一种表述方式，依赖容器把资源注入给所需要的组件
		 * 
		 * IOC前生：分离接口与实现，采用控制反转
		 * 
		 * Spring支持3中依赖注入方式 属性注入，构造器注入，工厂方式注入（很少使用，不推荐）
		 */
	}

	/**
	 * spring注入bean示例
	 */
	private static void constructorDIDemo()
	{

		Car car = (Car) ctx.getBean("car");
		System.out.println(car);

		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);

		Car car3 = (Car) ctx.getBean("car3");
		System.out.println(car3);

		Person p1 = (Person) ctx.getBean("person");
		System.out.println(p1);

		Person p2 = (Person) ctx.getBean("person2");
		System.out.println(p2);

		Person p3 = (Person) ctx.getBean("person3");
		System.out.println(p3);

		Person p4 = (Person) ctx.getBean("person4");
		System.out.println(p4);

		PersonCollection p5 = (PersonCollection) ctx.getBean("person5");
		System.out.println(p5);

		NewPerson p6 = (NewPerson) ctx.getBean("newPerson");
		System.out.println(p6);

		DataSource ds = (DataSource) ctx.getBean("customProperties");
		System.out.println(ds);

		System.err.println("=======================================");
		PersonCollection pc2 = (PersonCollection) ctx.getBean("containsCarListPerson");
		System.out.println(pc2);
		for (Car item : pc2.getCarList())
		{
			System.out.println(item);
		}

		System.err.println("===============================");
		PersonCollection pc3 = (PersonCollection) ctx.getBean("abbreviationBean");
		System.out.println(pc3);

	}

	/**
	 * 自动装配
	 */
	private static void autoWiredDemo()
	{
		AutoWiredPerson awp = (AutoWiredPerson) ctx.getBean("autoWiredBean");
		System.out.println(awp);
	}

}
