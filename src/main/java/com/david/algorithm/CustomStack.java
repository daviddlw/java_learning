package com.david.algorithm;

public class CustomStack
{
	private Node top;

	public Node peek()
	{
		if (top != null)
		{
			return top;
		}

		return null;
	}

	public void push(Node node)
	{
		if (node != null)
		{
			node.setNext(top);
			top = node;
		}
	}

	public Node pop()
	{
		if (top == null)
		{
			return null;
		} else
		{
			Node tempNode = new Node(top.getVal());
			top = top.getNext();
			return tempNode;
		}
	}
}
