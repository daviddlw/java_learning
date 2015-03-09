package com.david.nio;

import java.nio.CharBuffer;

import org.apache.log4j.Logger;

public class BufferDemo
{
	private static Logger logger = Logger.getLogger(BufferDemo.class);

	public static void executeCharBuffer()
	{
		String s = "hello world, david.dai";
		CharBuffer cbf = CharBuffer.allocate(s.length());
		cbf.append(s);
		cbf.flip(); // 反转到起始点，读取

		StringBuilder sb = new StringBuilder();
		while (cbf.hasRemaining())
		{
			sb.append(cbf.get());
		}

		System.err.println(sb.toString());
	}

	public static void executeCharBufferForStrArray()
	{
		String[] strArr = new String[] { "www.baidu.com", "www.google.com", "www.360.com" };
		int length = 0;
		for (String str : strArr)
		{
			length += str.length();
		}

		CharBuffer cbf = CharBuffer.allocate(length + strArr.length);

		for (String str : strArr)
		{
			cbf.append(str + "\n");
		}

		cbf.flip(); // 反转到起始点，读取

		StringBuilder sb = new StringBuilder();
		while (cbf.hasRemaining())
		{
			sb.append(cbf.get());
		}

		System.err.println(sb.toString());
	}
}
