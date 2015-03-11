package com.david.zookeeper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;

public class SetConfig
{
	private static Logger logger = Logger.getLogger(SetConfig.class);
	private static final String URL = "192.168.8.117:2181";
	private static String rootNode = "/myConf";
	private static String urlNode = rootNode + "/url";
	private static String usernameNode = rootNode + "/username";
	private static String passwordNode = rootNode + "/passwd";

	private static final String AUTH_TYPE = "digest";
	private static final String AUTH_PASSWORD = "password";

	private final static String URL_STR = "www.baidu.com";
	private final static String USERNAME_STR = "hupu";
	private final static String PASSWORD_STR = "hupu123";

	public static void executeZookeeper() throws IOException, InterruptedException, KeeperException
	{
		ZooKeeper zk = new ZooKeeper(URL, 3000, new Watcher() {

			@Override
			public void process(WatchedEvent event)
			{
				String info = String.format("触发了回调的Watcher=> path:%s, type: %s, state: %s", event.getPath(), event.getType(),
						event.getState());
				logger.info(info);
			}
		});

		while (zk.getState() != States.CONNECTING)
		{
			Thread.sleep(3000);
		}
		zk.addAuthInfo(AUTH_TYPE, AUTH_PASSWORD.getBytes());

		if (zk.exists(rootNode, true) == null)
		{
			zk.create(rootNode, "root".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}

		if (zk.exists(urlNode, true) == null)
		{
			zk.create(urlNode, URL_STR.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}

		if (zk.exists(usernameNode, true) == null)
		{
			zk.create(usernameNode, USERNAME_STR.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}

		if (zk.exists(passwordNode, true) == null)
		{
			zk.create(passwordNode, PASSWORD_STR.getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}

		zk.close();
	}
}
