package java_learning;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Before;
import org.junit.Test;

import com.david.serializable.SerializableDemo;
import com.david.serializable.User;

public class TestSerializable
{
	private File file = new File("F:" + File.separator + "dest" + File.separator + "User.data");
	private File mFile = new File("F:" + File.separator + "dest" + File.separator + "MutipleUsers.data");
	private File parent = new File("F:" + File.separator + "dest" + File.separator);

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSerializeObject() throws ClassNotFoundException
	{
		SerializableDemo serializableObjDemo = new SerializableDemo(file);
		serializableObjDemo.serializeObjectDemo();
	}

	@Test
	public void testSerialzeMutipleObject() throws ClassNotFoundException
	{
		SerializableDemo serializableDemo = new SerializableDemo(mFile);
		serializableDemo.serializeMutipleObjectDemo();
	}
	
	@Test
	public void testSequeceInputStream()
	{
		SerializableDemo.serializeMergeDemo();
	}

	@Test
	public void testFileCharset()
	{
		File poemTxt = new File(parent, "poem.txt");		
		InputStream in = null;
		int length = 0;
		byte[] buffer = new byte[(int) poemTxt.length()];
		String s = "";

		try
		{
			in = new FileInputStream(poemTxt);
			while ((length = in.read(buffer)) != -1)
			{
				s += new String(buffer, "gbk");
			}

			System.out.println(s);
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

}
