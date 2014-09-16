package com.david.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo
{
	private static Method smokingMethod;

	public static void main(String[] args)
	{
		// generateObjWithReflect();
		// constructorDemo();
		// dynamicInstance();
		// fieldDemo();
		// superClassDemo();
		arrayDemo();
	}

	/**
	 * Arrays工具类用法
	 */
	private static void arrayDemo()
	{
		User[] users = new User[] { new User("张三", "123456", 25), new User("李四", "123456", 26), new User("王五", "123456", 27) };

		System.out.println("对象数组的长度：" + Array.getLength(users));
		Class<?> c = users.getClass();
		Class<?> c2 = User.class;
		System.out.println("是否为数组类型：" + c.isArray());
		System.out.println("是否为数组类型：" + c2.isArray());
		
		for (int i = 0; i < Array.getLength(users); i++)
		{
			System.out.println(Array.get(users, i));
		}
	}

	/**
	 * 反射父类demo
	 */
	private static void superClassDemo()
	{
		Class<?> c = User.class;
		try
		{
			User u = (User) c.newInstance();
			Class<?> sc = c.getSuperclass();
			System.err.println(sc);
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * field反射
	 */
	private static void fieldDemo()
	{
		Class<?> c = User.class;

		System.out.println("==========所有成员变量==========");
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields)
		{
			System.err.println(field.toGenericString());
		}

		System.out.println();
		System.out.println("==========所有成员方法===============");
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods)
		{
			System.err.println(method);
		}

		System.out.println();
		System.err.println("===========所有公共方法================");
		Method[] otherMethods = c.getMethods();
		for (Method method : otherMethods)
		{
			System.out.println(method);
		}

		System.err.println("=============反射调用公共方法==========");
		try
		{
			Method sayHelloMethod = c.getMethod("showMessage", new Class[] { String.class });
			sayHelloMethod.invoke(new User(), new Object[] { "你好" });

			User u = (User) c.newInstance();
			smokingMethod = c.getDeclaredMethod("smoking", new Class[] {});
			smokingMethod.setAccessible(true);
			smokingMethod.invoke(u, null);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		System.err.println("=========获取接口信息============");
		Class<?>[] interfaces = c.getInterfaces();
		for (Class<?> item : interfaces)
		{
			System.out.println(item.toString());
		}
	}

	/**
	 * 动态实例化
	 */
	private static void dynamicInstance()
	{
		Class<?> c = null;
		try
		{
			c = Class.forName(User.class.getCanonicalName());
			Constructor<?> constructor = c.getConstructor(new Class[] { String.class, String.class, int.class });
			User u = (User) constructor.newInstance(new Object[] { "david.dai", "123456", 27 });
			System.err.println(u);

		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/**
	 * 构造方法
	 */
	private static void constructorDemo()
	{
		try
		{
			Class<?> c = Class.forName("com.david.reflect.User");

			// 获取所有公有构造方法
			System.out.println("所有公有构造方法：");
			Constructor[] constructors = c.getConstructors();
			for (Constructor<?> constructor : constructors)
			{
				System.out.println(constructor);
			}

			// 获取指定类型的构造方法
			Constructor<?> c2 = c.getConstructor(new Class[] { String.class, String.class, int.class });
			System.out.println("c2: " + c2);

			// 获取所有公有构造方法（不区分访问级别）
			Constructor[] constructors2 = c.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors2)
			{
				System.err.println(constructor);
			}

			// 获取指定类型的构造方法
			Constructor<?> c3 = c.getDeclaredConstructor(new Class[] { String.class, String.class });
			System.err.println("c3: " + c3);

		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 由反射生成类对象
	 */
	private static void generateObjWithReflect()
	{
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		Class<?> c4 = null;

		// 使用对象的getClass()
		User user = new User();
		c1 = user.getClass();
		System.err.println("c1: " + c1);

		// 可以利用静态方法Class.forName()
		try
		{
			c2 = Class.forName(User.class.getCanonicalName());
			System.err.println("c2: " + c2);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}

		// 利用XX.class语法
		c3 = User.class;
		System.err.println("c3: " + c3);

		// 如果是java封装类型则使用Type语法
		c4 = Long.TYPE;
		System.err.println("c4 Type: " + c4);
		System.err.println("c4 Class: " + Long.class);

		System.out.println("Name: " + c1.getName());
		System.out.println("CanonicalName: " + c1.getCanonicalName());
		System.out.println("Constructors[]");
		for (Constructor<?> cst : c1.getConstructors())
		{
			System.out.println(cst);
		}
	}
}
