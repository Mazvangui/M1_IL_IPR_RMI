package tp.rmi.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import tp.rmi.common.*;

public class ChatRemoteImpl extends UnicastRemoteObject implements ChatRemote{
	
	private List<ReceiveCallback> listCallback = new ArrayList<>(); 
	protected ChatRemoteImpl() throws RemoteException {
		super();
	}

	@Override
	public String echo(String name, String message) throws RemoteException{
		return name +">"+message;
	}

	@Override
	public void send(String name, String message) throws RemoteException {
		// TODO Auto-generated method stub
		for(ReceiveCallback rc : listCallback) {
			rc.newMessage(name+">"+message);
		}
		
	}

	@Override
	public void registerCallback(ReceiveCallback callback) throws RemoteException {
		listCallback.add(callback);		
	}

}
