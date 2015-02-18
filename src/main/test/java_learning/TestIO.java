package java_learning;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestIO
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testCreateDir() throws IOException
	{
		File dir = new File("D:" + File.separator + "IOTest" + File.separator + "newDir");
		dir.mkdir();

		File dir2 = new File("D:\\IOTest\\哈哈哈");
		dir2.mkdir();

		File file = new File("D:\\IOTest\\newTxt1.txt");
		file.createNewFile();

		System.out.println("系统目录默认分隔符：" + File.pathSeparator);
		System.out.println("系统文件默认分隔符：" + File.separator);
	}

	@Test
	public void testCreateFile()
	{
		String path1 = "D:" + File.separator + "IOTest" + File.separator + "parentdir";
		String path2 = "D:" + File.separator + "IOTest" + File.separator + "parentdir" + File.separator
				+ "subparentdir";

		File parent = new File(path2);
		if (!parent.exists())
		{
			// parent.mkdir();
			parent.mkdirs();
		}

		File newFile = new File(parent, "child.txt");
		try
		{
			newFile.createNewFile();
			System.out.println("测试创建文件夹成功");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < 5; i++)
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String parentpath = "D:" + File.separator + "IOTest";
		File tempFile = new File(parentpath);
		System.out.println("共有" + tempFile.listFiles().length + "个文件");
		for (File item : tempFile.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname)
			{
				return pathname.getName().contains(".txt");
			}
		}))
		{
			System.out.println(item);
		}

		System.out.println("文件绝对路径：" + newFile.getAbsolutePath());
		System.out.println("文件名：" + newFile.getName());
		System.out.println("文件目录的路径：" + newFile.getParent());

		System.out.println("是否是目录：" + newFile.isDirectory());
		System.out.println("是否是文件：" + newFile.isFile());
		System.out.println("文件长度：" + newFile.length());

		newFile.delete();
	}
}
