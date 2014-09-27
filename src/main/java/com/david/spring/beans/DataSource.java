package com.david.spring.beans;

import java.util.Properties;

public class DataSource
{
	private Properties dsProperties;

	public DataSource()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public DataSource(Properties dsProperties)
	{
		super();
		this.dsProperties = dsProperties;
	}

	public Properties getDsProperties()
	{
		return dsProperties;
	}

	public void setDsProperties(Properties dsProperties)
	{
		this.dsProperties = dsProperties;
	}

	@Override
	public String toString()
	{
		return "DataSource [properties=" + dsProperties + "]";
	}

}
