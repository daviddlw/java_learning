package com.david.spring.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository
{
	@Override
	public void save()
	{
		System.out.println("UserRepository save...");
	}

}
