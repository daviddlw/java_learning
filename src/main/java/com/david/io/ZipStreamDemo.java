package com.david.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class ZipStreamDemo
{
	private static Logger logger = Logger.getLogger(ZipStreamDemo.class);
	private static String parentPath = "E:" + File.separator + "io_test";

	/**
	 * 压缩文件
	 */
	public static void zipFile()
	{
		File zipFile = new File(parentPath, "abcd.zip");
		File dir = new File(parentPath);
		ZipOutputStream zout = null;
		InputStream in = null;
		try
		{
			zout = new ZipOutputStream(new FileOutputStream(zipFile));
			zout.setComment("David's zip file.");
			File[] files = dir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name)
				{
					return name.endsWith(".txt");
				}
			});

			for (File file : files)
			{
				in = new FileInputStream(file);
				zout.putNextEntry(new ZipEntry(file.getName()));
				int temp = 0;
				while ((temp = in.read()) != -1)
				{
					zout.write(temp);
				}
			}

			logger.info("压缩成功...");

		} catch (FileNotFoundException e)
		{
			logger.error(e.getMessage(), e);
		} catch (IOException e)
		{
			logger.error(e.getMessage(), e);
		} finally
		{
			try
			{
				if (zout != null)
					zout.close();

				if (in != null)
					in.close();

			} catch (IOException e)
			{
				logger.error(e.getMessage(), e);
			}
		}

	}

	/**
	 * 解压缩文件
	 */
	public static void unZipFile()
	{
		File result = new File(parentPath, "unZipDir");
		if (!result.exists())
		{
			result.mkdir();
		}

		File unZipFile = new File(parentPath, "abcd.zip");
		OutputStream out = null;
		ZipInputStream zin = null;

		try
		{
			zin = new ZipInputStream(new FileInputStream(unZipFile));
			ZipEntry zipEntry = null;
			while ((zipEntry = zin.getNextEntry()) != null)
			{
				out = new FileOutputStream(new File(result.getPath(), zipEntry.getName()));
				int temp = 0;
				while ((temp = zin.read()) != -1)
				{
					out.write(temp);
				}
			}

			logger.info("解压成功...");

		} catch (IOException e)
		{
			logger.error(e.getMessage(), e);
		} finally
		{
			try
			{
				if (out != null)
					out.close();

				if (zin != null)
					zin.close();

			} catch (IOException e)
			{
				logger.error(e.getMessage(), e);
			}
		}
	}
}
