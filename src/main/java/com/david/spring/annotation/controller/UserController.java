package com.david.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.david.spring.annotation.TestObject;
import com.david.spring.annotation.service.UserService;

@Controller
public class UserController
{
	@Autowired
	private UserService service;

	@Autowired(required = false)
	private TestObject testObject;

	public void display()
	{
		System.out.println("UserController display...");
		service.execute();
		System.out.println("testObj=>" + testObject);
	}
}
