package com.david.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.SequenceInputStream;
import java.util.Date;

import sun.launcher.resources.launcher;

public class SerializableDemo
{
	private File file;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private static File parent = new File("F:" + File.separator + "dest" + File.separator);

	public SerializableDemo(File file)
	{
		super();
		this.file = file;
	}

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public void serializeObjectDemo() throws ClassNotFoundException
	{
		try
		{
			out = new ObjectOutputStream(new FileOutputStream(file));
			in = new ObjectInputStream(new FileInputStream(file));
			User user = new User("测试用户", "abc123", 15000, new Date());

			out.writeObject(user);

			User result = (User) in.readObject();
			System.out.println(result);

			out.close();
			in.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void serializeMutipleObjectDemo() throws ClassNotFoundException
	{
		User[] users = new User[] { new User("测试用户1", "abc123", 15000, new Date()),
				new User("测试用户2", "111111", 15000, new Date()), new User("测试用户3", "444444", 16000, new Date()),
				new User("测试用户4", "222222", 18000, new Date()), new User("测试用户5", "333333", 17000, new Date()) };

		try
		{
			out = new ObjectOutputStream(new FileOutputStream(file));
			in = new ObjectInputStream(new FileInputStream(file));
			out.writeObject(users);

			User[] result = (User[]) in.readObject();
			for (User user : result)
			{
				System.out.println(user);
				System.out.println();
			}

			out.close();
			in.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static SequenceInputStream mergeFiles(SequenceInputStream sin, File file) throws FileNotFoundException
	{
		sin = new SequenceInputStream(sin, new FileInputStream(file));
		return sin;
	}

	@SuppressWarnings("resource")
	public static void serializeMergeDemo()
	{
		File aFile = new File(parent, "a.txt");
		File bFile = new File(parent, "b.txt");
		File cFile = new File(parent, "c.txt");
		File dFile = new File(parent, "d.txt");

		SequenceInputStream sin = null;
		try
		{
			FileOutputStream fout = new FileOutputStream(new File(parent, "abcd.txt"));
			sin = new SequenceInputStream(new FileInputStream(aFile), new FileInputStream(bFile));
			sin = mergeFiles(sin, cFile);
			sin = mergeFiles(sin, dFile);
			int temp = 0;
			while ((temp = sin.read()) != -1)
			{
				fout.write(temp);
			}

			fout.close();
			System.out.println("合并输入流成功...");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (sin != null)
			{
				try
				{
					sin.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
