package com.david.zookeeper;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;

public class MyClient implements Watcher
{
	private static Logger logger = Logger.getLogger(MyClient.class);
	private static final String URL = "192.168.8.117:2181";
	public String rootNode = "/myConf";
	public String urlNode = rootNode + "/url";
	public String usernameNode = rootNode + "/username";
	public String passwordNode = rootNode + "/passwd";
	private ZooKeeper zk = null;

	private static final String AUTH_TYPE = "digest";
	private static final String AUTH_PASSWORD = "password";

	private String url;
	private String username;
	private String password;

	public MyClient()
	{
		zk = getZk();
		initValue();
	}

	private void initValue()
	{
		try
		{
			url = new String(zk.getData(urlNode, false, null));
			username = new String(zk.getData(usernameNode, true, null));
			password = new String(zk.getData(passwordNode, true, null));

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ZooKeeper getZk()
	{
		try
		{
			if (zk == null)
			{
				zk = new ZooKeeper(URL, 3000, this);
				zk.addAuthInfo(AUTH_TYPE, AUTH_PASSWORD.getBytes());
				while (zk.getState() != States.CONNECTING)
				{
					Thread.sleep(3000);
				}
				logger.info("连接服务器成功...");
			}
			return zk;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return zk;

	}

	public MyClient(String url, String username, String password)
	{
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public void process(WatchedEvent event)
	{
		if (event.getType() == EventType.NodeCreated)
		{
			System.out.println("节点被创建...");
		} else if (event.getType() == EventType.NodeDataChanged)
		{
			System.out.println(event.getPath() + "节点被改变...");
			initValue();
		} else if (event.getType() == EventType.NodeDeleted)
		{
			System.out.println(event.getPath() + "节点被删除...");
			initValue();
		} else if (event.getType() == EventType.NodeChildrenChanged)
		{
			System.out.println(event.getPath() + "子节点被创建...");
			initValue();
		}
	}

}
