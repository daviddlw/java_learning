package com.david.spring.factorybean;

public abstract class AbstractHuman
{
	public String name;

	protected abstract String getGender();

	public AbstractHuman()
	{
		// TODO Auto-generated constructor stub
		System.err.println(getGender());
	}

	public AbstractHuman(String name)
	{
		super();
		this.name = name;
		System.err.println(getGender());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}

class Male extends AbstractHuman
{

	@Override
	protected String getGender()
	{
		// TODO Auto-generated method stub
		return "male";
	}

}

class Female extends AbstractHuman
{

	@Override
	protected String getGender()
	{
		// TODO Auto-generated method stub
		return "female";
	}
}
