package java_learning;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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

	@Test
	public void testSort()
	{
		int[] arr = new int[] { 2, 3, 5, 12, 51, 99, 62, 101, 88, 3, 13, 66 };
		// SortReview.quickSort(arr, 0, arr.length - 1);
		// SortReview.heapSort(arr, arr.length);
		quickSort(arr, 0, arr.length - 1);
		// heapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

		int index = binarySearch(arr, 0, arr.length - 1, 5);
		System.out.println("带搜索关键词索引：" + index);

	}

	public static int binarySearch(int[] arr, int low, int high, int key)
	{
		int middle;
		while (low <= high)
		{
			middle = low / 2 + (high - high / 2);// 防止low+high超出int长度溢出
			if (arr[middle] < key)
			{
				low = middle + 1;
			} else if (arr[middle] > key)
			{
				high = middle - 1;
			} else
			{
				return middle;
			}
		}

		return -1;
	}

	public static void quickSort(int[] arr, int low, int high)
	{
		if (low >= high)
			return;

		int start = low;
		int end = high;
		int key = arr[start];

		while (start < end)
		{
			while (start < end && arr[end] >= key)
			{
				end--;
			}

			arr[start] = arr[end];

			while (start < end && arr[start] <= key)
			{
				start++;
			}

			arr[end] = arr[start];
		}

		arr[start] = key;
		quickSort(arr, low, start - 1);
		quickSort(arr, start + 1, high);

	}

	public static void heapSort(int[] arr, int length)
	{
		int temp;
		// 从第一个非叶子节点开始向上调整
		for (int i = length / 2 - 1; i >= 0; i--)
		{
			heapAdjust(arr, i, length);
		}

		// 将堆顶元素丢到最后的有序列，然后倒数第二个一次类推调整
		for (int i = arr.length - 1; i > 0; i--)
		{
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapAdjust(arr, 0, i);
		}
	}

	private static void heapAdjust(int[] arr, int i, int length)
	{
		int temp, child;
		while (2 * i + 1 < length)
		{
			child = 2 * i + 1;
			// 选择子节点中交大的那个元素父亲节点作比较，构建大跟堆
			if (child < length - 1 && arr[child] < arr[child + 1])
			{
				child++;
			}

			if (arr[i] < arr[child])
			{
				temp = arr[i];
				arr[i] = arr[child];
				arr[child] = temp;

				i = child;
			} else
			{
				break;
			}
		}
	}

	@Test
	public void testReflection()
	{
		try
		{
			User user = new User();
			PropertyDescriptor pd = new PropertyDescriptor("id", User.class);
			Method setIdMethod = pd.getWriteMethod();
			setIdMethod.invoke(user, 1);
			Method getIdMethod = pd.getReadMethod();
			Object obj = getIdMethod.invoke(user, new Object[] {});
			System.out.println(obj);
			System.out.println(user);

		} catch (IntrospectionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BeanInfo beanInfo;
		try
		{
			beanInfo = Introspector.getBeanInfo(User.class);
			System.out.println("getBeanDescriptor: " + beanInfo.getBeanDescriptor());
			System.out.println("getMethodDescriptors: " + Arrays.toString(beanInfo.getMethodDescriptors()));
			System.out.println("getPropertyDescriptors: " + Arrays.toString(beanInfo.getPropertyDescriptors()));
		} catch (IntrospectionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class User
{
	private int id;
	private String name;

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + "]";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
