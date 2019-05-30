package tree;

import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import chat.Client;

public class TreeCellRenderer extends DefaultTreeCellRenderer
{

	public TreeCellRenderer()
	{
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus)
	{

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		if (value instanceof ClientNode)
		{
			ImageIcon img = null;
			File tmp = new File("src/resources/client_15x15.png");
			if (tmp.exists())
			{
				img = new ImageIcon("src/resources/client_15x15.png");
				setIcon(img);
			}
			else
				System.err.println("Resource not found: " + "src/resources/client_15x15.png");
		}
		else if (value instanceof ServerNode)
		{
			ImageIcon img = null;
			File tmp = new File("src/resources/server_15x15.png");
			if (tmp.exists())
			{
				img = new ImageIcon("src/resources/server_15x15.png");
				setIcon(img);
			}
			else
				System.err.println("Resource not found: " + "src/resources/server_15x15.png");
		}
		return this;
	}
}
