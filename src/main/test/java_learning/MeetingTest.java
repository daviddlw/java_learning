package java_learning;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.david.meeting.CurrentConditionDisplay;
import com.david.meeting.CustomStack;
import com.david.meeting.ForecastDisplay;
import com.david.meeting.ICustomObserver;
import com.david.meeting.NewObserver;
import com.david.meeting.StatisticsDisplay;
import com.david.meeting.WeatherData;

public class MeetingTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testCustomStack() throws InterruptedException
	{
		CustomStack<Integer> customStack = new CustomStack<Integer>(10, Integer.class);
		customStack.push(1);
		customStack.push(2);
		customStack.push(3);
		customStack.push(4);
		customStack.push(5);
		customStack.push(6);
		customStack.push(7);
		customStack.push(8);
		customStack.push(9);
		customStack.push(10);
		customStack.push(11);
		System.err.println(customStack.getCount());
		Thread.sleep(500);
		System.out.println(customStack.pop());
		Thread.sleep(500);
		System.err.println(customStack.getCount());
		Thread.sleep(500);
		System.out.println(customStack.pop());
		Thread.sleep(500);
		System.out.println(customStack.pop());
		Thread.sleep(500);
		System.err.println(customStack.getCount());
		Thread.sleep(500);
		System.out.println(customStack.pop());
		Thread.sleep(500);
		System.out.println("customStack is empty: " + customStack.empty());
		Thread.sleep(500);
	}

	@Test
	public void testObserverPattern() throws InterruptedException
	{
		WeatherData data = new WeatherData(100, 200, 300);
		System.out.println("初始温度：" + data);
		List<ICustomObserver> ls = Arrays.asList(new ICustomObserver[] { new CurrentConditionDisplay("CurrentConditionDisplay"),
				new StatisticsDisplay("StatisticsDisplay"), new ForecastDisplay("ForecastDisplay") });
		for (ICustomObserver item : ls)
		{
			data.registerObserver(item);
		}
		Thread.currentThread();
		Thread.sleep(500);
		data.updateWeatherData(888, 999, 1000);
		Thread.sleep(500);
		data.registerObserver(new NewObserver("NewObserver"));
		data.updateWeatherData(1, 2, 3);
		Thread.sleep(500);
		data.removeObserver("NewObserver");
		data.updateWeatherData(5, 6, 7);
	}

	@Test
	public void showJavaBasicDataType()
	{
		System.out.println("Java的基础数据类型是：byte,short,int,long,float,double,boolean,char");
	}

	@Test
	public void stringReverse()
	{
		String str = "abc";
		StringBuilder sb = new StringBuilder();
		char[] charArr = str.toCharArray();
		for (int i = charArr.length - 1; i >= 0; i--)
		{
			sb.append(charArr[i]);
		}
		String result = sb.toString();
		System.out.println(result.toString());
	}

	@Test
	public void numbericStringConvert()
	{
		String str = "888";
		String str1 = "888.943";
		Integer i = Integer.parseInt(str);
		System.out.println("integer: " + i);
		Double d = Double.parseDouble(str1);
		System.out.println("double: " + d);

		BigDecimal bg = new BigDecimal(str1).setScale(1, BigDecimal.ROUND_HALF_UP);
		double value = bg.doubleValue();
		System.out.println("value: " + value);
	}

	@Test
	public void dateTest()
	{
		System.out.println(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
	}

	@Test
	public void fileIO()
	{
		String path = "C:\\Users\\pc\\Desktop\\Java学习资料";
		File file = new File(path);
		System.out.println("是否为目录：" + file.isDirectory());
		File[] files = file.listFiles();
		System.out.println("共有文件" + file.length() + "个");
		for (File item : files)
		{
			System.out.println("IsDirectory: " + item.isDirectory());
			System.out.println(item.toString());
		}
	}

	@Test
	public void encodingConvert()
	{
		String str = "你好";
		System.out.println(Charset.defaultCharset());
		byte[] bytes = str.getBytes(Charset.defaultCharset());
		String newStr;
		try
		{
			newStr = new String(bytes, "ISO-8859-1");
			System.out.println("newStr: " + newStr);
			System.out.println(Charset.defaultCharset());
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSort()
	{
		int[] testArr = new int[] { 27, 4, 18, 88, 66, 35, 13, 88, 101, 68 };
		// quickSort(testArr, 0, testArr.length - 1);
		heapSort(testArr, testArr.length);
		System.out.println(Arrays.toString(testArr));
	}

	private void heapAdjust(int[] arr, int i, int length)
	{
		int temp, child;
		while (i * 2 + 1 < length)
		{
			child = i * 2 + 1;
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

	private void heapSort(int[] arr, int length)
	{
		int temp = 0;
		for (int i = length / 2 - 1; i >= 0; i--)
		{
			heapAdjust(arr, i, length);
		}

		for (int i = length - 1; i > 0; i--)
		{
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapAdjust(arr, 0, i);
		}
	}

	private void quickSort(int[] arr, int low, int high)
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
}
