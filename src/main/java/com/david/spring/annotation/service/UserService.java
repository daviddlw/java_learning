package com.david.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.david.spring.annotation.repository.IUserRepository;

@Service
public class UserService
{
	@Autowired
	@Qualifier("userJdbcRepositoryImpl")
	private IUserRepository userRepository;

	public void setUserRepository(IUserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public void execute()
	{
		System.out.println("UserService execute..." + userRepository);
		userRepository.save();
	}
}
