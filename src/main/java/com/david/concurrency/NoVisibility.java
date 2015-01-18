package com.david.concurrency;

public class NoVisibility
{
	private static boolean ready;
	private static int number;

	public static void main(String[] args)
	{
		new ThreadRead().start();
		number = 42;
		ready = true;
	}

	private static class ThreadRead extends Thread
	{
		@Override
		public void run()
		{
			while (!ready)
			{
				Thread.yield();
			}

			System.out.println(number);
		}
	}
}
