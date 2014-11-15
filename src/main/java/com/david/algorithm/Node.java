package com.david.algorithm;

/**
 * 链表节点
 * 
 * @author pc
 * 
 */
public class Node
{
	private int val;
	private Node next;

	public Node()
	{
		super();
	}

	public Node(int val)
	{
		super();
		this.val = val;
		this.next = null;
	}

	public int getVal()
	{
		return val;
	}

	public void setVal(int val)
	{
		this.val = val;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	@Override
	public String toString()
	{
		return "Node [val=" + val + ", next=" + next + "]";
	}

}
