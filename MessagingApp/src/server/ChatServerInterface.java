package server;

import java.rmi.RemoteException;
import java.rmi.Remote;


public interface ChatServerInterface extends Remote {
	void chatClientRegister(ChatClientInterface chatClient) throws RemoteException;
	void sendMessage(String message) throws RemoteException;
}
