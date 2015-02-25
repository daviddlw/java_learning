package com.david.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		runPipedStreamDemo();
	}
	
	public static void runPipedStreamDemo() throws IOException
	{
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream(out);
		
		Thread th_r = new Thread(new MyReader(in));
		Thread th_w = new Thread(new MyWriter(out));
		
		th_w.start();
		th_r.start();

	}
}

class MyReader implements Runnable
{

	private PipedInputStream pin;

	public MyReader()
	{
		super();
	}

	public MyReader(PipedInputStream pin)
	{
		super();
		this.pin = pin;
	}

	@Override
	public void run()
	{
		try
		{
			StringBuilder sb = new StringBuilder();
			int temp = 0;
			while ((temp = pin.read()) != -1)
			{
				sb.append((char) temp);
			}
			System.out.println(sb.toString());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			if (pin != null)
			{
				try
				{
					pin.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

class MyWriter implements Runnable
{
	private PipedOutputStream pout;

	public MyWriter(PipedOutputStream pout)
	{
		super();
		this.pout = pout;
	}

	public MyWriter()
	{
		super();
	}

	@Override
	public void run()
	{
		String s = "Hello World!";
		try
		{
			System.out.println("等待3秒写入......");
			Thread.sleep(3000);
			pout.write(s.getBytes());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			if (pout != null)
			{
				try
				{
					pout.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
