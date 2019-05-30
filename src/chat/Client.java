package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import observer.Observable;
import observer.Observer;

public class Client implements Runnable, Observable
{

	private ArrayList<Observer> observers = new ArrayList<>();
	private Socket socket;
	private String nickname;
	private BufferedReader inSocket;
	private PrintWriter outSocket;

	public Client(String nickname) throws Exception
	{
		String ip = getIPv4Address();
		socket = new Socket(ip, 2020);
		this.nickname = nickname;
		inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		// Sends clients nickname to ServerThread.
		outSocket.println(nickname);

		// Starts new Thread which will be listening to all Server broadcasts.
		Thread thread = new Thread(this);
		thread.start();
	}

	public Socket getSocket()
	{
		return socket;
	}

	public String getNickname()
	{
		return nickname;
	}

	public BufferedReader getInSocket()
	{
		return inSocket;
	}

	public PrintWriter getOutSocket()
	{
		return outSocket;
	}

	private String getIPv4Address() throws Exception
	{
		String ip = "";
		ip = InetAddress.getLocalHost().toString();
		if (ip.contains("/"))
		{
			String[] split = ip.split("/");
			ip = split[split.length - 1];
		}
		return ip;
	}

	@Override
	public String toString()
	{
		return nickname;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				String msg = inSocket.readLine();
				// Notifies ClientFrame with message that client has received.
				notify(msg);
				if (msg == null || msg.equals("Client: " + nickname + " has left the chat."))
					break;
			}
			System.out.println("Close Client.");
			socket.close();
			inSocket.close();
			outSocket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

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
