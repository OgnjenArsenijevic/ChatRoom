package tree;

import javax.swing.JTree;

public class Tree extends JTree
{

	public Tree()
	{
		addMouseListener(new TreeMouseController());
		setCellRenderer(new TreeCellRenderer());
		setEditable(false);
	}

}
