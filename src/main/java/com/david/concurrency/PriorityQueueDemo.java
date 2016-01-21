package com.david.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueDemo
{
	private static PriorityQueue<Integer> pq;
	private static List<Integer> list;

	static
	{
		list = Arrays.asList(new Integer[] { 32, 15, 18, 8, 13, 20, 5 });
		pq = new PriorityQueue<>(list.size(), new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2)
			{
				if (o1 < o2)
				{
					return 1;
				} else if (o1 > o2)
				{
					return -1;
				} else
				{
					return 0;
				}
			}
		});
	}

	public static void main(String[] args)
	{
		List<Integer> resultList = new ArrayList<>();
		pq.addAll(list);
		while (!pq.isEmpty())
		{
			resultList.add(pq.poll());
		}
		System.err.println(resultList);
	}
}
