package com.david.concurrency;

public class EvenGenerator extends AbstractIntGenerator
{
	private int currentEvenValue = 0;

	@Override
	public int next()
	{
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

}
