package com.david.jdbcTemplate;

public class Employee
{
	private int id;
	private String name;
	private String email;
	private Department department;

	public Employee()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String email, Department department)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + "]";
	}

}
