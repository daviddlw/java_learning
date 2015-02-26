package com.david.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderWriterStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		runPipedStreamDemo();
	}
	
	public static void runPipedStreamDemo() throws IOException
	{
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader(out);
		
		Thread th_r = new Thread(new MyReader2(in));
		Thread th_w = new Thread(new MyWriter2(out));
		
		th_w.start();
		th_r.start();

	}
}

class MyReader2 implements Runnable
{

	private PipedReader pin;

	public MyReader2()
	{
		super();
	}

	public MyReader2(PipedReader pin)
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

class MyWriter2 implements Runnable
{
	private PipedWriter pout;

	public MyWriter2(PipedWriter pout)
	{
		super();
		this.pout = pout;
	}

	public MyWriter2()
	{
		super();
	}

	@Override
	public void run()
	{		
		String s = "你好，中国";
		try
		{
			System.out.println("等待3秒写入......");
			Thread.sleep(3000);
			pout.write(s);
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
