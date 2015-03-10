package java_learning;

import static org.junit.Assert.*;

import java.nio.CharBuffer;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.david.nio.BufferDemo;

public class TestNio
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testBufferDemo()
	{
		BufferDemo.executeCharBuffer();
	}
	
	@Test
	public void testBufferDemoForStrArray()
	{
		BufferDemo.executeCharBufferForStrArray();
	}
	
	@Test
	public void testBufferOperation()
	{
		BufferDemo.executeBufferOperation();
	}
	
	@Test
	public void testExecuteBatchGet()
	{
		BufferDemo.executeBatchGet();
	}
	
	@Test
	public void testExecuteBatchPut()
	{
		BufferDemo.executeBatchPut();
	}
	
	@Test
	public void testWrapOperation()
	{
		String s = "hello world";
		CharBuffer cbf = CharBuffer.wrap(s);
		char[] result = new char[s.length()];
		cbf.get(result, 0, cbf.remaining());
		System.out.println(String.valueOf(result));
		System.out.println("测试成功...");
	}

}
