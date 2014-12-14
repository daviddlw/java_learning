package com.david.meeting;

import java.lang.reflect.Array;

public class CustomStack<T>
{
	private T[] stackArr;
	private int index;
	private int arrLength;
	private int count;

	public CustomStack()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public CustomStack(int length, Class<T> type)
	{
		super();
		this.arrLength = length;
		this.index = length - 1;
		stackArr = (T[]) Array.newInstance(type, length);
	}

	public T pop()
	{
		T removeObj = null;
		if (count > 0 && count < arrLength)
		{
			removeObj = stackArr[index + 1];
			for (int i = 1; i < stackArr.length; i++)
			{
				stackArr[i - 1] = stackArr[i];
			}
			count--;
		} else
		{
			System.out.println("栈已空");
		}
		return removeObj;
	}

	public void push(T obj)
	{
		if (index > 0)
		{
			stackArr[index] = obj;
			index--;
			count++;
		} else
		{
			System.err.println("栈空间已满");
		}
	}

	public boolean empty()
	{
		return count == 0;
	}

	public T peek()
	{
		T obj = null;
		if (count > 0 && count < arrLength)
		{
			obj = stackArr[index + 1];
		}
		return obj;
	}

	public int search(T obj)
	{
		int index = 0;
		for (int i = 0; i < stackArr.length; i++)
		{
			if (stackArr[i].equals(obj) && stackArr[i].hashCode() == obj.hashCode())
			{
				index = i;
			}
		}
		return index;
	}

	public int getCount()
	{
		return count;
	}

}
