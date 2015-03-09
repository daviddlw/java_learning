package java_learning;

import static org.junit.Assert.*;

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

}
