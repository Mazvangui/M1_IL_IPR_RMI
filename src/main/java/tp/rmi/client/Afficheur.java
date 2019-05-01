package tp.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp.rmi.common.ReceiveCallback;

public class Afficheur extends UnicastRemoteObject implements ReceiveCallback{

	protected Afficheur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void newMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
