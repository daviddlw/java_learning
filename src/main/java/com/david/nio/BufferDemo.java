package com.david.nio;

import java.nio.CharBuffer;
import java.util.Arrays;

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

	public static void executeBufferOperation()
	{
		String s = "abcdefg";
		CharBuffer cbf = CharBuffer.allocate(s.length());
		cbf.append(s);
		cbf.flip();
		logger.info("original str: " + s);
		cbf.position(2).mark().position(4);
		logger.info("before reset operation...");
		showResult(cbf);
		logger.info("after rest operation...");
		cbf.reset();
		showResult(cbf);
		logger.info("after flip operation...");
		cbf.flip();
		showResult(cbf);
		logger.info("after rewind operation...");
		cbf.rewind();
		showResult(cbf);
		logger.info("after clear operation...");
		showResult(cbf);
	}

	private static void showResult(CharBuffer buffer)
	{
		StringBuilder sb = new StringBuilder();
		while (buffer.hasRemaining())
		{
			sb.append(buffer.get());
		}
		System.err.println(sb.toString());
	}

	public static void executeBatchGet()
	{
		String s = "abcdefg";
		char[] charArr = new char[10];
		CharBuffer cbf = CharBuffer.allocate(s.length());
		cbf.append(s);
		cbf.flip();

		int length = 0;
		while (cbf.hasRemaining())
		{
			length = Math.min(cbf.remaining(), charArr.length);
			cbf.get(charArr, 0, length);
		}

		System.out.println(Arrays.toString(charArr));
	}

	public static void executeBatchPut()
	{
		String s = "abcdefg";
		CharBuffer cbf = CharBuffer.allocate(3);
		int length = Math.min(3, s.length());
		cbf.put(s, 0, length);
		System.out.println(cbf);
		System.out.println(cbf.position());
		cbf.flip();
		char[] result = new char[length];
		cbf.get(result);
		System.out.println(Arrays.toString(result));
	}
}
