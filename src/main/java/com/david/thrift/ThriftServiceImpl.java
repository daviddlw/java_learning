package com.david.thrift;

import org.apache.thrift.TException;

public class ThriftServiceImpl implements ThriftService.Iface
{

	@Override
	public void ping(String message) throws TException
	{
		System.out.println("hello world, " + message);
	}

}
