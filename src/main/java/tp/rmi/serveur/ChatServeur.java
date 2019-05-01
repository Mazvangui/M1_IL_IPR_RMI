package tp.rmi.serveur;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tp.rmi.common.ChatRemote;

public class ChatServeur {

	public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException{
		    System.setProperty("java.rmi.server.codebase", Paths.get("target/classes").toUri().toURL().toString());

		    System.setProperty("java.rmi.server.hostname",InetAddress.getLocalHost().getHostAddress());

		    String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/chat";

		    

			ChatRemote objetDistant = new ChatRemoteImpl();
			Registry registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(), Registry.REGISTRY_PORT);
			registry.rebind(url, objetDistant);
			System.out.println(objetDistant + " has been registred");
	}
}
