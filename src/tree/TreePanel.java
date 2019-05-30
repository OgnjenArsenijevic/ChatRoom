package tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import chat.ServerFrame;

public class TreePanel extends JPanel
{

	public TreePanel()
	{
		setLayout(new BorderLayout(5, 5));
		setPreferredSize(new Dimension(230, 100));
		setBackground(Color.LIGHT_GRAY);

		JScrollPane scrollPane = new JScrollPane(ServerFrame.getInstance().getTree());

		add(scrollPane);
	}
}
