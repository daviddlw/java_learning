package java_learning;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.david.algorithm.CustomQueue;
import com.david.algorithm.CustomStack;
import com.david.algorithm.Node;
import com.david.algorithm.SingletonClassTest;

public class TestAlgorithm
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testBackUp()
	{
		String sourceFile = "F://start/招聘要求.txt";
		String destFile = "F://dest/招聘要求backup.txt";
		backupFile(sourceFile, destFile);
	}

	private void backupFile(String sourceFile, String destFile)
	{
		File file = new File(sourceFile);
		ByteArrayOutputStream baos = new ByteArrayOutputStream((int) file.length());
		BufferedInputStream bis = null;

		BufferedOutputStream bos = null;

		try
		{
			int size = 2048;
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[size];
			int bytesRead = 0;

			while ((bytesRead = bis.read(buffer)) != -1)
			{
				baos.write(buffer, 0, bytesRead);
			}

			bos = new BufferedOutputStream(new FileOutputStream(new File(destFile)));
			bos.write(baos.toByteArray(), 0, baos.toByteArray().length);
			bos.flush();

		} catch (Exception e)
		{
			e.printStackTrace();
			// TODO: handle exception
		} finally
		{
			try
			{
				baos.close();
				bis.close();
				bos.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Test
	public void testSingletonClass()
	{
		Thread t = null;

		for (int i = 0; i < 5; i++)
		{
			t = new Thread(new Runnable() {

				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					System.out.println(SingletonClassTest.getObject());
				}
			});
			t.start();
		}

	}

	@Test
	public void testCustomStack()
	{
		Node firstNode = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);

		CustomStack stack = new CustomStack();
		stack.push(firstNode);
		stack.push(secondNode);
		stack.push(thirdNode);

		Node tempNode = null;
		while ((tempNode = stack.pop()) != null)
		{
			System.out.println(tempNode);
		}
	}

	@Test
	public void testCustomQueue()
	{
		Node firstNode = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);

		CustomQueue queue = new CustomQueue();
		queue.enqueue(firstNode);
		queue.enqueue(secondNode);
		queue.enqueue(thirdNode);

		Node tempNode = null;
		while ((tempNode = queue.dequeue()) != null)
		{
			System.out.println(tempNode);
		}
	}

}
