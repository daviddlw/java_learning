package com.david.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking
{
	private ReentrantLock lock = new ReentrantLock();

	public void timed()
	{
		boolean isCaptured = lock.tryLock();
		try
		{
			System.out.println("isCaptured: " + isCaptured);

		} finally
		{
			if (isCaptured)
			{
				lock.unlock();
			}
		}
	}

	public void untimed()
	{
		boolean isCaptured = false;
		try
		{
			isCaptured = lock.tryLock(1, TimeUnit.SECONDS);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		} 
		
		try
		{
			System.out.println("tryLock(2, TimeUnit.SECONDS) exception. isCaptured: " + isCaptured);
		} finally
		{
			if (isCaptured)
				lock.unlock();
		}
	}
	
	public static void main(String[] args)
	{
		final AttemptLocking al = new AttemptLocking();
		al.untimed();
		al.timed();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				al.lock.lock();
				System.out.println("acquired...");
			}
		});
		t.setDaemon(true);
		t.start();
		Thread.yield();
		al.untimed();
		al.timed();
	}
}
