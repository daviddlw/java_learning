package com.david.spring.genericdi;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T>
{
	@Autowired
	private BaseRepository<T> repository;

	public void execute()
	{
		System.out.println("service execute start...");
		repository.execute();
		repository.add();
		System.out.println("service execute end...");
	}
}
