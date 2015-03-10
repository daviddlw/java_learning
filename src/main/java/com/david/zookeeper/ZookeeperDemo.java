package com.david.zookeeper;

import org.apache.log4j.Logger;

/**
 * Zookeeper应用
 * @author dailiwei
 *
 */
public class ZookeeperDemo
{
	private Logger logger = Logger.getLogger(ZookeeperDemo.class);
	
	/*
	 * 不超过板书Server挂掉不影响zk提供服务，Master/Slave主流服务
	 * Server端具有fast fail特性（健壮性）
	 */
}
