package com.david.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;

public class ThriftServerRun
{
	public static void main(String[] args)
	{
		try
		{
			TServerSocket tSocket = new TServerSocket(1234);
			ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor<ThriftServiceImpl>(new ThriftServiceImpl());
			Factory portFactory = new TBinaryProtocol.Factory(true, true);
			
			Args tArgs = new Args(tSocket);
			tArgs.processor(processor);
			tArgs.protocolFactory(portFactory);
			
			TServer tServer = new TThreadPoolServer(tArgs);
			tServer.serve();
			System.out.println("Thrift server is runnning...");

		} catch (TTransportException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
