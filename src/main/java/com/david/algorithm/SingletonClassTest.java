package com.david.algorithm;

public class SingletonClassTest
{
	private static SingletonClass obj;
	private static Object lockObj = new Object();

	// 延迟加载，当然也可以直接new好实体直接返回就是非延迟加载
	public static SingletonClass getObject()
	{
		if (obj == null)
			obj = new SingletonClass();

		return obj;
	}

	//多线程情况下的单例
	public synchronized static SingletonClass getThreadObject()
	{
		if (obj == null)
		{
			synchronized (lockObj)
			{
				if(obj == null){
					obj = new SingletonClass();
				}
			}
		}
		
		return obj;
	}

}

class SingletonClass
{
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "SingletonClass" + hashCode();
	}
}
