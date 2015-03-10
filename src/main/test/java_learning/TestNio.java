package java_learning;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.david.nio.BufferDemo;
import com.david.nio.ChannelDemo;

public class TestNio
{
	private String s = "hello world";

	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void testChannelDemo() throws IOException
	{
		ChannelDemo.testFileChannel();
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
		CharBuffer cbf = CharBuffer.wrap(s);
		char[] result = new char[s.length()];
		cbf.get(result, 0, cbf.remaining());
		System.out.println(String.valueOf(result));
		System.out.println("测试成功...");
	}

	@Test
	public void testReadOnlyBuffer()
	{
		CharBuffer cbf = CharBuffer.allocate(s.length());
		cbf.append(s);
		cbf.position(2).limit(6).mark().position(4);
		/*
		 * cbf.reset(); char[] result = new char[s.length()]; cbf.get(result, 0,
		 * cbf.remaining()); System.out.println(String.valueOf(result));
		 */

		CharBuffer dcbf = cbf.duplicate();
		dcbf.reset();
		char[] result = new char[s.length()];
		dcbf.get(result, 0, dcbf.remaining());
		System.out.println(String.valueOf(result));

		dcbf.rewind();
		dcbf.put("newstr");
		dcbf.flip();

		char[] dcbfRs = new char[s.length()];
		dcbf.get(dcbfRs, 0, dcbf.remaining());
		System.out.println(String.valueOf(dcbfRs));

		char[] cbfRs = new char[s.length()];
		cbf.flip();
		cbf.get(cbfRs, 0, cbf.remaining());

		System.out.println(String.valueOf(cbfRs));
	}

	@Test
	public void testByteBuffer()
	{
		ByteBuffer buffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
		char[] chars = new char[] { 0, 'H', 0, 'i', 0, '!', '0' };
		for (int i = 0; i < chars.length; i++)
		{
			buffer.put(i, (byte) chars[i]);
		}
		showBuffer(buffer);
		CharBuffer charBuffer = buffer.asCharBuffer();
		showBuffer(charBuffer);
		IntBuffer intBuffer = buffer.asIntBuffer();
		showBuffer(intBuffer);
		
		
	}

	private void showBuffer(Buffer buffer)
	{
		String result = String.format("pos=%d, limit=%d, capacity=%d, %s", buffer.position(), buffer.limit(), buffer.capacity(),
				buffer.toString());
		System.out.println(result);
		
	}

}
