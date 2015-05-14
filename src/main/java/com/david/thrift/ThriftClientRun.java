package com.david.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClientRun
{

	public static void main(String[] args)
	{
		TTransport transport = null;
		try
		{
			transport = new TSocket("localhost", 1234);
			TProtocol tProtocol = new TBinaryProtocol(transport);
			ThriftService.Client client = new ThriftService.Client(tProtocol);
			transport.open();
			
			client.ping("daviddai");
			
			transport.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
