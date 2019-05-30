package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooserFrame extends JFrame
{
	JButton btnClient;

	public ChooserFrame()
	{
		setSize(450, 250);
		JLabel lblClient = new JLabel("Create new Client : ");
		JLabel lblServer = new JLabel("Create new Server : ");
		btnClient = new JButton("Client");
		btnClient.setEnabled(false);
		JButton btnServer = new JButton("Server");
		JPanel panel = new JPanel(new GridBagLayout());

		btnClient.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				OpeningClientFrame.open();
			}
		});

		btnServer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (!Server.isStarted())
				{
					ServerFrame.getInstance();
					ServerFrame.getInstance().initTree();
					ServerFrame.getInstance().initFrame();
				}
				btnClient.setEnabled(true);
			}
		});

		GridBagConstraints c = getConstraints(0, 0);

		panel.add(lblClient, c);
		c = getConstraints(1, 0);
		btnClient.setPreferredSize(new Dimension(200, 35));
		panel.add(btnClient, c);

		c = getConstraints(0, 1);
		panel.add(lblServer, c);
		c = getConstraints(1, 1);
		btnServer.setPreferredSize(new Dimension(200, 35));
		panel.add(btnServer, c);

		this.add(BorderLayout.CENTER, panel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Choose");
	}

	public static void open()
	{
		ChooserFrame chooserFrame = new ChooserFrame();
		chooserFrame.setVisible(true);
		chooserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private GridBagConstraints getConstraints(int x, int y)
	{
		GridBagConstraints constrain = new GridBagConstraints();
		constrain.gridx = x;
		constrain.gridy = y;
		constrain.insets = new Insets(20, 20, 0, 0);
		constrain.anchor = GridBagConstraints.WEST;
		return constrain;
	}
}
