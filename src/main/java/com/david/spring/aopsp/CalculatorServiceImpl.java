package com.david.spring.aopsp;

import org.springframework.stereotype.Component;

@Component
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
		int result = i / j;
		return result;
	}

}
