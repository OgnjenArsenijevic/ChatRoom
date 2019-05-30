package tree;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import observer.Observable;
import observer.Observer;

public class ClientNode implements TreeNode, Observable
{

	private TreeNode parent;
	private String name;
	private String text;
	private ArrayList<Observer> observers;

	public ClientNode(String name, TreeNode parent)
	{
		this.name = name;
		this.parent = parent;
		this.text = "";
		this.observers = new ArrayList<>();
	}

	public String getName()
	{
		return name;
	}

	public String getText()
	{
		return text;
	}

	// This function is called when ever user sends a message in chat.
	// It notifies all observers which in this case is only ServerFrame
	public void appendText(String userMessage)
	{
		text += userMessage + "\n";
		notify("Edited: " + text);
	}

	@Override
	public Enumeration children()
	{
		return null;
	}

	@Override
	public boolean getAllowsChildren()
	{
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex)
	{
		return null;
	}

	@Override
	public int getChildCount()
	{
		return 0;
	}

	@Override
	public int getIndex(TreeNode node)
	{
		return -1;
	}

	@Override
	public TreeNode getParent()
	{
		return parent;
	}

	@Override
	public boolean isLeaf()
	{
		return true;
	}

	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}

	@Override
	public void notify(Object o)
	{
		for (Observer ob : observers)
		{
			ob.update(o);
		}
	}
}
