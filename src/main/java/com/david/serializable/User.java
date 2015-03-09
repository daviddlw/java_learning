package com.david.serializable;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.text.StrBuilder;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	transient private double salary;
	private Date registerDate;

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, double salary, Date registerDate)
	{
		super();
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.registerDate = registerDate;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public Date getRegisterDate()
	{
		return registerDate;
	}

	public void setRegisterDate(Date registerDate)
	{
		this.registerDate = registerDate;
	}

	@Override
	public String toString()
	{
		StrBuilder sb = new StrBuilder();
		sb.appendln("username: " + username);
		sb.appendln("password: " + password);
		sb.appendln("salary: " + salary);
		sb.appendln("registerDate: " + registerDate);
		return sb.toString();
	}

}
