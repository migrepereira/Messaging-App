package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import client.ChatClientInterface;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientInterface> chatClients;
	
	protected ChatServer() throws RemoteException {
		super();
	}
	
	public synchronized void chatClientRegister(ChatClientInterface chatClient)
		throws RemoteException {
		this.chatClients.add(chatClient);
		
	}
	
	public void sendMessage(String message) throws RemoteException {
		int i = 0;
		while(i < chatClients.size()) {
			chatClients.get(i++).getMessage(message);
		}
	}
}
