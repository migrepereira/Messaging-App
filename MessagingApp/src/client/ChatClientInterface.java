package client;

import java.rmi.Remote;

public interface ChatClientInterface extends Remote {
	void getMessage(String message) throws RemoteException;
}
