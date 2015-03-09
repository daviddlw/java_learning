package java_learning;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Before;
import org.junit.Test;

import com.david.io.PipedStreamDemo;
import com.david.io.ZipStreamDemo;

public class TestIO
{

	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void zipFile()
	{
		ZipStreamDemo.zipFile();	
	}
	
	@Test
	public void unZipFile()
	{
		ZipStreamDemo.unZipFile();
	}
	
	@Test
	public void testLoadClass() throws ClassNotFoundException, IOException
	{
		String path ="file://F:"+File.separator+"dubboservice.jar";
		System.out.println(path);
		URL url = new URL(path);
		ClassLoader cLoader = new URLClassLoader(new URL[]{url}, Thread.currentThread().getContextClassLoader());
		Class<?> type = cLoader.loadClass("com.hupu.service.DubboService");
		
	}

	private String getTxt()
	{
		String txtStr = "窗前明月光\r\n疑是地上霜\r\n举头望明月\r\n低头思故乡";
		return txtStr;
	}

	@Test
	public void testWriterAndReader() throws IOException
	{
		String txt = getTxt();
		String dest = "D:" + File.separator + "IOTest" + File.separator + "readAndWriter.txt";
		FileWriter fw = new FileWriter(new File(dest));
		fw.write(txt);
//		fw.flush();
		fw.close();
		
		FileReader fr = new FileReader(new File(dest));
		char[] buffers = new char[txt.length()];
		fr.read(buffers);
		fr.close();
		
		String txtStr = String.valueOf(buffers, 0, buffers.length);
		System.out.println(txtStr);
	}

	@Test
	public void testPipedStreamDemo() throws IOException
	{
		PipedStreamDemo.runPipedStreamDemo();
	}

	@Test
	public void testBufferdDataStreamDemo() throws IOException
	{
		String srcPath = "D:" + File.separator + "IOTest" + File.separator + "newDir" + File.separator + "0123.jpg";
		String destPath = "D:" + File.separator + "IOTest" + File.separator + "newDir" + File.separator
				+ "0123_copy.jpg";
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try
		{
			in = new BufferedInputStream(new FileInputStream(srcFile));
			out = new BufferedOutputStream(new FileOutputStream(destFile));
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = in.read(buffer)) != -1)
			{
				out.write(buffer);
			}
			System.err.println("缓冲拷贝成功...");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (out != null)
			{
				try
				{
					out.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (in != null)
			{
				try
				{
					in.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testDataStreamDemo() throws IOException
	{
		File txtFile = new File("D:" + File.separator + "IOTest", "静夜思2.txt");
		DataInputStream in = new DataInputStream(new FileInputStream(txtFile));
		DataOutputStream out = new DataOutputStream(new FileOutputStream(txtFile));
		out.writeInt(123);
		out.writeDouble(88.88);
		out.writeChar(65);
		out.writeBoolean(true);
		out.close();

		System.out.println(in.readInt());
		System.out.println(in.readDouble());
		System.out.println(in.readChar());
		System.out.println(in.readBoolean());
		in.close();
	}

	@Test
	public void testFileCopyDemo()
	{
		String srcPath = "D:" + File.separator + "IOTest" + File.separator + "newDir" + File.separator + "0123.jpg";
		String destPath = "D:" + File.separator + "IOTest" + File.separator + "newDir" + File.separator
				+ "0123_copy.jpg";
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		InputStream in = null;
		OutputStream out = null;

		try
		{
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = in.read(buffer)) != -1)
			{
				out.write(buffer);
			}
			System.err.println("拷贝成功...");

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (out != null)
			{
				try
				{
					out.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (in != null)
			{
				try
				{
					in.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileOutputStreamToFile() throws IOException
	{
		String txtStr = getTxt();
		String filepath = "D:" + File.separator + "IOTest";
		File dir = new File(filepath);
		if (!dir.exists())
		{
			dir.mkdir();
		}
		File txtFile = new File(filepath, "静夜思2.txt");
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(txtFile));
		out.write(txtStr.getBytes());
		out.close();
		System.out.println("写入成功！");

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(txtFile));
		byte[] buffer = new byte[(int) txtFile.length()];
		in.read(buffer);
		in.close();
		String s = new String(buffer);
		System.out.println(s);
	}

	@Test
	public void testFileWriterToFile() throws IOException
	{
		String txtStr = getTxt();
		String filepath = "D:" + File.separator + "IOTest";
		File dir = new File(filepath);
		if (!dir.exists())
		{
			dir.mkdir();
		}

		File txtFile = new File(filepath, "静夜思.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));
		bw.write(txtStr);
		bw.close();
		System.out.println("写入成功！");

		BufferedReader reader = new BufferedReader(new FileReader(txtFile));
		String s = null;
		while ((s = reader.readLine()) != null)
		{
			System.err.println(s);
		}
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
		System.out.println("URI：" + newFile.toURI());

		newFile.delete();
	}
}
