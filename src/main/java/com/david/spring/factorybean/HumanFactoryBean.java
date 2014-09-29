package com.david.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class HumanFactoryBean implements FactoryBean<AbstractHuman>
{

	public String type;

	public HumanFactoryBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public HumanFactoryBean(String type)
	{
		super();
		this.type = type;
	}

	@Override
	public AbstractHuman getObject() throws Exception
	{
		// TODO Auto-generated method stub
		AbstractHuman obj = type.equalsIgnoreCase("male") ? new Male() : new Female();
		return obj;
	}

	@Override
	public Class<?> getObjectType()
	{
		// TODO Auto-generated method stub
		AbstractHuman obj = type.equalsIgnoreCase("male") ? new Male() : new Female();
		return obj.getClass();
	}

	@Override
	public boolean isSingleton()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "HumanFactoryBean [type=" + type + ", getObjectType()=" + getObjectType()
				+ ", isSingleton()=" + isSingleton() + ", getType()=" + getType() + "]";
	}

}
