package com.david.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends AbstractIntGenerator
{
	private int currentEvenValue = 0;
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public int next()
	{
		// TODO Auto-generated method stub
		try
		{
			lock.lock();
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally
		{
			lock.unlock();
		}
	}

}
