package com.david.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable
{
	private AbstractIntGenerator generator;
	private final int id;

	public EvenChecker(AbstractIntGenerator generator, int id)
	{
		// TODO Auto-generated constructor stub
		this.generator = generator;
		this.id = id;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while (!generator.isCanceled())
		{
			int val = generator.next();
			if (val % 2 != 0)
			{
				System.out.println(val + " is not even!");
				generator.cancel();
			}

		}
	}

	public static void test(AbstractIntGenerator generator, int count)
	{
		System.out.println("Press Contrl-c to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++)
		{
			exec.execute(new EvenChecker(generator, i));
		}
		exec.shutdown();
	}

	public static void test(AbstractIntGenerator generator)
	{
		test(generator, 10);
	}

}
