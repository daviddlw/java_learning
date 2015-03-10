package com.david.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;
import java.util.Random;

import org.apache.log4j.Logger;

public class ChannelDemo
{
	private static final String LINE_SEPARATOR = "line.separator";
	private static String filepath = "F:" + File.separator + "target_lib";
	private static Logger logger = Logger.getLogger(ChannelDemo.class);
	private static Random rand = new Random();
	private static String[] col1 = new String[] { "www.baidu.com", "www.google.com", "www.sogou.com" };

	private static String[] col2 = new String[] { "david.dai", "peng.wang", "eric.dai" };
	private static String[] col3 = new String[] { "redis", "mongodb", "hbase", "log4j" };

	public static void main(String[] args) throws IOException
	{
		// runCopyBuffer();
		// runGatheringChannelDemo();
		runFileHole();
	}

	private static void runCopyBuffer() throws IOException
	{
		ReadableByteChannel readBc = Channels.newChannel(new FileInputStream(new File(filepath, "a.txt")));
		// ReadableByteChannel readBc = Channels.newChannel(System.in);
		WritableByteChannel writeBc = Channels.newChannel(System.out);
		// writeBc.close();
		logger.info("ReadChannel isOpen: " + readBc.isOpen());
		logger.info("WriteChannel isOpen: " + writeBc.isOpen());
		copyBuffer(readBc, writeBc);
	}

	public static void testFileChannel() throws IOException
	{
		FileInputStream fin = new FileInputStream(new File(filepath, "test.txt"));
		FileChannel fc = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
		fc.write(buffer);
		buffer.flip();
		fc.read(buffer);

		CharBuffer charBuffer = buffer.asCharBuffer();
		charBuffer.flip();
		char[] chars = new char[charBuffer.length()];
		while (charBuffer.hasRemaining())
		{
			charBuffer.put(chars, 0, charBuffer.remaining());
		}

		System.out.println(String.valueOf(chars));

		fin.close();
	}

	private static void copyBuffer(ReadableByteChannel src, WritableByteChannel dest) throws IOException
	{
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);

		while (src.read(buffer) != -1)
		{
			buffer.flip();
			while (buffer.hasRemaining())
			{
				dest.write(buffer);
			}
			buffer.clear();
		}
	}

	private static void runGatheringChannelDemo() throws IOException
	{
		FileOutputStream fout = new FileOutputStream(new File(filepath, "test.txt"));
		GatheringByteChannel gbc = fout.getChannel();
		ByteBuffer[] byteBuffers = getByteBuffers(5);

		while (gbc.write(byteBuffers) > 0)
		{
			logger.info("exeute gatheringByteChannel write...");
		}
		logger.info("finish write process...");
	}

	private static ByteBuffer[] getByteBuffers(int count) throws UnsupportedEncodingException
	{
		LinkedList<ByteBuffer> byteBufferLs = new LinkedList<ByteBuffer>();
		for (int i = 0; i < count; i++)
		{
			byteBufferLs.add(pickRandom(col1, " "));
			byteBufferLs.add(pickRandom(col2, " "));
			byteBufferLs.add(pickRandom(col3, System.getProperty(LINE_SEPARATOR)));
		}
		ByteBuffer[] byteBuffers = new ByteBuffer[byteBufferLs.size()];
		byteBufferLs.toArray(byteBuffers);
		return byteBuffers;
	}

	private static ByteBuffer pickRandom(String[] strings, String suffix) throws UnsupportedEncodingException
	{
		String str = strings[rand.nextInt(strings.length)];
		int total = str.length() + suffix.length();
		ByteBuffer buffer = ByteBuffer.allocate(total);
		buffer.put(str.getBytes("US-ASCII"));
		buffer.put(suffix.getBytes("US-ASCII"));
		buffer.flip();
		return buffer;
	}

	private static void runFileHole() throws IOException
	{
		File temp = File.createTempFile("holy", null);
		RandomAccessFile raf = new RandomAccessFile(temp, "rw");
		FileChannel fc = raf.getChannel();
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		putData(0, buffer, fc);
		putData(50000, buffer, fc);
		putData(5000, buffer, fc);
		logger.info("write temp file: " + temp.getPath() + ", size: " + fc.size());
		fc.close();
		raf.close();
	}

	private static void putData(int position, ByteBuffer buffer, FileChannel fc) throws IOException
	{
		String str = String.format("position: %d", position);
		buffer.clear();
		buffer.put(LINE_SEPARATOR.getBytes("US-ASCII"));
		buffer.flip();
		fc.position(position);
		fc.write(buffer);
	}
}
