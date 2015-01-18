package com.david.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender
{
	private final static String QUEUE_NAME = "helloworld";

	public static void main(String[] args) throws IOException
	{
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost("localhost");
		Connection conn = cf.newConnection();
		Channel channel = conn.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "hello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" Sender sent: " + message);
	}
}
