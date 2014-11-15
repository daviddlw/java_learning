package com.david.algorithm;

public class CustomQueue
{
	private Node top;
	private Node tail;

	/**
	 * 入列
	 * 
	 * @param node
	 */
	public void enqueue(Node node)
	{
		if (top == null)
		{
			top = node;
			tail = top;
		} else
		{
			tail.setNext(node);
			tail = node;
		}
	}

	/**
	 * 出列
	 */
	public Node dequeue()
	{
		Node newNode = new Node(top.getVal());
		top = top.getNext();
		if (tail == newNode)
			tail = top;
		return newNode;
	}
}
