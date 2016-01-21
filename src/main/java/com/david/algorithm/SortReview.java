package com.david.algorithm;

import java.util.Arrays;

/**
 * sort
 * 
 * @author pc
 * 
 */
public class SortReview
{
	public static void main(String[] args)
	{
		// int[] arr = new int[] { 3, 1, 4, 1, 7, 3 };
		int[] arr = new int[] { 32, 15, 18, 8, 13, 20, 5 };
//		 quickSort(arr, 0, arr.length - 1);
		heapSort(arr, arr.length);
		System.err.println(Arrays.toString(arr));
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 *            代排序数组
	 * @param low
	 *            最低索引
	 * @param high
	 *            最高索引
	 */
	public static void quickSort(int[] a, int low, int high)
	{
		if (low >= high)
			return;

		int first = low;
		int last = high;
		int key = a[first];

		while (first < last)
		{
			// 找出右边找出中枢值小的丢过去
			while (first < last && a[last] >= key)
				last--;
			a[first] = a[last];

			// 找出左边找出中枢值大的丢过去
			while (first < last && a[first] <= key)
				first++;

			a[last] = a[first];
		}

		a[first] = key;

		quickSort(a, low, first - 1);
		quickSort(a, first + 1, high);
	}

	/**
	 * 调整堆
	 * 
	 * @param a
	 *            待排序数组
	 * @param i
	 *            i是待调整的数组元素的位置
	 * @param length
	 *            length是数组的长度
	 */
	private static void heapAjust(int a[], int i, int length)
	{
		int temp, child;
		while (2 * i + 1 < length)
		{
			child = 2 * i + 1;
			// 得到子节点中较大的那个和父节点作比较
			if (child < length - 1 && a[child] < a[child + 1]) // 大根变小根，这里边大于号
				child++;

			if (a[i] < a[child])
			{
				temp = a[i];
				a[i] = a[child];
				a[child] = temp;
			} else
			{
				break;
			}

			i = child;
		}
	}

	public static void heapSort(int a[], int length)
	{
		int temp;
		// length/2 - 1第一个非叶子节点开始调整（构建成大根堆）
		for (int i = length / 2 - 1; i >= 0; i--)
		{
			heapAjust(a, i, length);
		}

		// 交换第一个元素
		for (int i = length - 1; i > 0; i--)
		{
			temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			heapAjust(a, 0, i);
		}
	}
}
