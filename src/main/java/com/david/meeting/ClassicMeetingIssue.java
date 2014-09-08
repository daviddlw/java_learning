package com.david.meeting;

/**
 * 10道java经典面试题
 * 
 * @author pc
 * 
 */
public class ClassicMeetingIssue
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// question2();
		// quesion4();
		// quesion5();
		runInConcurrency();
	}

	/*
	 * Q1: int与Integer的区别 int基本数据类型，Integer引用数据类型（是个对象）
	 * num没有属性，i有属性与方法i为num的封装类（即Integer是int的封装类）
	 */
	private static void question1()
	{
		int num = 100;
		Integer i = 100;

		/*
		 * 
		 */
		i = num; // 装箱
		num = i; // 拆箱
	}

	/*
	 * Q2：==与equals有什么区别 Answer: ==如果两边是数值，比较的是值是否相等，如果两边是对象比较的是引用是否相等
	 * equals比较的是两个对象的内容是否相同
	 */
	private static void question2()
	{
		int a = 100;
		int b = 100;
		System.err.println("a==b: " + (a == b));

		Integer c = 200;
		Integer d = 200;
		System.err.println("c==d: " + (c == d));
		System.err.println("c.equals: " + c.equals(d));

		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");

		System.err.println("s1==s2: " + (s1 == s2));
		System.err.println("s2==s3: " + (s2 == s3));

		System.err.println("s1.equals(s2): " + s1.equals(s2));
		System.err.println("s2.equals(s3): " + s2.equals(s3));
	}

	/*
	 * Q3: 面向对象的三大特征 封装：一个类就是一个封装体 继承：java属于单根继承，好处是提高了代码的复用性
	 * 多态：同一种行为在不同的对象上有不同的表现形式 1. 有继承 2.重写 3.父类的引用指向子类对象
	 */

	private static void quesion4()
	{
		try
		{
			int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			for (int i = 0; i < testArray.length; i++)
			{
				System.out.println(testArray[i]);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/*
	 * Q4：Java中的引用与C语言的指针有什么不同 引用是更加安全的之指针
	 * 例如C语言写个数组越界的程序编译也能通过，但是它能访问到越界后面内存只想的任意地址内的东西
	 * 但是arr里面的引用不能++或者--,不允许对java引用地址进行运算，否则编译不会通过
	 * 而hashcode只是jvm对内存单元的映射值，并不代表真是的内存地址
	 */

	public static void quesion5()
	{
		try
		{
			StringBuilder sb = new StringBuilder();
			// StringBuffer sb = new StringBuffer();
			int count = 2000;
			for (int i = 0; i < count; i++)
			{
				sb.append(String.valueOf(i));
			}
			System.out.println(sb.toString());
		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void runInConcurrency()
	{
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				quesion5();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				quesion5();
			}
		});

		try
		{
			t1.start();
			t2.start();
		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	/*
	 * Q5：String与StringBuffer，StringBuilder的区别
	 * String是不可变，StringBuffer是线程安全，StringBuilder线程不安全
	 */
	
	/*
	 * Q6：final/finalize/finally的区别
	 * 1. final修饰类或者修饰变量，如果修饰类，表示该类不能被继承
	 * 如果修饰变量，（基本数据类型，值不能改变，如果修饰引用类型，表示对象不能改变）
	 * 2. finalize：Object类中的基本方法，销毁对象的时候自动调用
	 * 3. finally：结合try-catch-finally使用，通常用来完成资源释放等功能。
	 */
	
	/*
	 * Q7：抽象类和接口的区别
	 * 抽象类侧重于描述is-a关系，接口侧重于表示功能性has-a关系
	 * 抽象类-本质，接口-功能，讨论方位不一样
	 * 例如：智能手机类设计
	 * 智能手机是手机，手机是抽象类
	 * 智能手机有哪些功能，设计智能手机的接口
	 * 上网，拍照，安装操作系统等等
	 * 抽象类-单继承，接口-多继承
	 */
	
	/*
	 * Q8：Overload与Override有什么区别，
	 * Overload（方法重载）-方法名称相同，参数个数，类型与次序不同，一般在同一个类中没有继承没有重写
	 * Override（方法重写）-子类重写了从父类继承过来的方法，一般有继承有重写
	 */
	
	/*
	 * Q9：sleep()与wait()的区别
	 * sleep()交出CPU的时间片，在休眠指定时间后，重新进入可运行状态，wait()释放CPU资源，进入等待队列后几级等待被唤醒
	 * sleep()不会释放对象的锁，wait()释放对象的锁
	 * sleep()属于Thread类的静态方法，wait()释放对象的锁
	 * sleep()属于Thread类的静态方法，wait()属于Object类的成员方法
	 * sleep()可以再任何地方调用，wait只能在同步块中调用，wait一般与notify一般同事出现
	 */
	
	/*
	 * HashMap与HashTable的区别
	 * HashMap是Dictionary子类，HashMap是Map接口的一个实现类，
	 * HashTable是同步的，HashMap在缺省情况下是非同步的但是效率比HashTable高
	 * HashMap去掉了contains方法增加了containsKey与containsValue方法
	 * HashMap允许空键值，而hashTable不允许
	 */
}
