package com.david.spring.genericdi;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T>
{
	@Autowired
	private BaseRepository<T> repository;

	public void execte()
	{
		System.out.println("service execute start...");
		repository.execute();
		System.out.println("service execute end...");
	}
}
