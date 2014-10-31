package com.david.spring.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepositoryImpl implements IUserRepository
{

	@Override
	public void save()
	{
		// TODO Auto-generated method stub
		System.out.println("UserJdbcRepository execute...");
	}

}
