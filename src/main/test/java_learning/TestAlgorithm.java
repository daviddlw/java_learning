package java_learning;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import sun.net.www.content.text.plain;

import com.david.algorithm.CustomQueue;
import com.david.algorithm.CustomStack;
import com.david.algorithm.Node;
import com.david.algorithm.SingletonClassTest;
import com.david.algorithm.SortReview;

public class TestAlgorithm
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void test()
	{
		System.out.println(1);
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

	/**
	 * 新加入节点向上调整堆(堆插入节点)
	 * 
	 * @param a
	 */
	private void minHeapFixUp(int a[], int i)
	{
		int temp, j;
		temp = a[i];
		j = (i - 1) / 2; // 父节点

		while (j >= 0 && i != 0)
		{
			if (a[j] <= temp)
				break;

			a[i] = a[j];
			i = j;
			j = (i - 1) / 2;
		}

		a[i] = temp;
	}

	/**
	 * 堆中插入新数值
	 * 
	 * @param a
	 * @param n
	 * @param num
	 */
	private void minHeapAddNumber(int[] a, int n, int num)
	{
		a[n] = num;
		minHeapFixUp(a, n);
	}

	/**
	 * 从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
	 * 
	 * @param a
	 * @param i
	 * @param n
	 */
	private void minHeapFixDown(int[] a, int i, int n)
	{
		int j, temp;
		temp = a[i];
		j = 2 * i + 1;

		while (j < n)
		{
			// 如左右孩子中小的那个
			if (j + 1 < n && a[j + 1] < a[j])
			{
				j++;
			}

			if (a[j] > temp) // 如果父节点小于子节点不需要作交换
				break;

			a[i] = a[j];
			i = j;
			j = 2 * i + 1;
		}

		a[i] = temp;
	}

	public void minHeapDeleteNumber(int[] a, int num)
	{

	}

	private void swap(int a, int b)
	{
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}

	@Test
	public void testSwap()
	{
		int[] arr = new int[] { 1, 2 };
		swap(arr[0], arr[1]);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void testQuickSort()
	{
		int[] arr = new int[] { 2, 3, 5, 12, 51, 99, 62, 88, 3, 13, 66 };
		// SortReview.quickSort(arr, 0, arr.length - 1);
		SortReview.heapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
