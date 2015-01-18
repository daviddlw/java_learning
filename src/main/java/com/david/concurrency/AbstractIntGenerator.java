package com.david.concurrency;

public abstract class AbstractIntGenerator
{
	private volatile boolean canceled = false;

	public abstract int next();

	public void cancel()
	{
		canceled = true;
	}

	public boolean isCanceled()
	{
		return canceled;
	}
}
