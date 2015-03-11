package java_learning;

import java.io.IOException;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import com.david.zookeeper.MyClient;
import com.david.zookeeper.SetConfig;

public class TestZookeeper
{
	private static final String URL = "192.168.8.117:2181";

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testZk() throws IOException, InterruptedException, KeeperException
	{
		SetConfig.executeZookeeper();
	}

	@Test
	public void testMyClient() throws Exception
	{
		MyClient myClient = new MyClient();
		ZooKeeper zk = myClient.getZk();
		int i = 0;
		while (true)
		{
			System.out.println("url: " + myClient.getUrl());
			System.out.println("username: " + myClient.getUsername());
			System.out.println("password: " + myClient.getPassword());

			System.out.println("-----------------------------------");
			Thread.sleep(2000);
			i++;

			if (i == 5)
			{
				// 对url没有设置监听，所以监听没有效果，但是更新操作有效果
				String tempUrl = myClient.getUrl().equalsIgnoreCase("www.baidu.com") ? "www.google.com" : "www.baidu.com";
				String tempPassword = myClient.getPassword().equalsIgnoreCase("hupu123456") ? "hupu123" : "hupu123456";

				zk.setData(myClient.urlNode, tempUrl.getBytes(), -1);
				// 对password设置了监听
				zk.setData(myClient.passwordNode, tempPassword.getBytes(), -1);
			}

			if (i == 10)
				break;
		}

		zk.close();
	}

}
