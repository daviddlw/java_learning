package com.david.spring.genericdi;

public class BaseRepository<T>
{
	public void execute()
	{
		System.out.println("repository execute...");
	}
}
