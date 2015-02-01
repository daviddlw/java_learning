package com.david.spring.genericdi;

public class BaseRepository<T>
{
	public void execute()
	{
		System.out.println("repository execute...");
	}
	
	public void add()
	{
		System.out.println("add operations...");
	}
}
