package com.david.spring.aop;

public class CalculatorServiceImpl implements CalculatorService
{

	@Override
	public int add(int i, int j)
	{
		// TODO Auto-generated method stub
		int result = i + j;
		return result;
	}

	@Override
	public int minus(int i, int j)
	{
		// TODO Auto-generated method stub
		int result = i - j;
		return result;
	}

	@Override
	public int mutiply(int i, int j)
	{
		// TODO Auto-generated method stub
		int result = i * j;
		return result;
	}

	@Override
	public int divide(int i, int j)
	{
		// TODO Auto-generated method stub
		int result = j == 0 ? 0 : i / j;
		return result;
	}

}
