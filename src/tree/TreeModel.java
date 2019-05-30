package tree;

import javax.swing.tree.DefaultTreeModel;

public class TreeModel extends DefaultTreeModel
{

	public TreeModel()
	{
		super(new ServerNode("Client list"));
	}

}
