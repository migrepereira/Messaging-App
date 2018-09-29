package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatServerInterface;

public class ChatClient extends UnicastRemoteObject implements ChatClientInterface, Runnable {
	private static final long serialVersionUID = 1L;
	private ChatServerInterface chatServer;
	private String name = null;
	
	protected ChatClient(String name, ChatServerInterface chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.chatClientRegister(this);
	}
	
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message;
		
		while(true) {
			message = scanner.nextLine();
			try {
				chatServer.sendMessage(name + " : " + message);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
