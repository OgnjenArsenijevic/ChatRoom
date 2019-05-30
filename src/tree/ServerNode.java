package tree;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class ServerNode implements TreeNode
{

	private ArrayList<TreeNode> children;
	private String name;

	public ServerNode(String name)
	{
		children = new ArrayList<>();
		this.name = name;
	}

	public void addChild(TreeNode node)
	{
		children.add(node);
	}

	public void removeChild(TreeNode node)
	{
		children.remove(node);
	}

	public TreeNode getChildByString(String nodeName)
	{
		for (int i = 0; i < children.size(); i++)
		{
			if (((ClientNode) children.get(i)).getName().equals(nodeName))
			{
				return children.get(i);
			}
		}
		return null;
	}

	@Override
	public Enumeration children()
	{
		return null;
	}

	@Override
	public boolean getAllowsChildren()
	{
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex)
	{
		return children.get(childIndex);
	}

	@Override
	public int getChildCount()
	{
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node)
	{
		for (int i = 0; i < children.size(); i++)
		{
			if (children.get(i).equals(node))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public TreeNode getParent()
	{
		return null;
	}

	@Override
	public boolean isLeaf()
	{
		if (children.size() == 0)
			return true;
		return false;
	}

	@Override
	public String toString()
	{
		return name;
	}

}
