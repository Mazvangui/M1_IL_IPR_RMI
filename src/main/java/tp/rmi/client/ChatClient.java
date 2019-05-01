package tp.rmi.client;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.charset.MalformedInputException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import tp.rmi.common.ChatRemote;
import tp.rmi.common.ReceiveCallback;

public class ChatClient {

	public static void main(String[] args ) throws RemoteException, NotBoundException, MalformedURLException, UnknownHostException{
		
		try {
			Registry registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(), Registry.REGISTRY_PORT);
			System.out.println(registry);
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/chat";
			ChatRemote chat = (ChatRemote) registry.lookup(url);
			ReceiveCallback callback = new Afficheur();
			chat.registerCallback(callback);
			
			Scanner sc = new Scanner(System.in); 
			String num = sc.nextLine(); 
	        // Check if an int value is available 
	        while (num!="stop") 
	        { 
	        	chat.send("bobo", num);
	            // Read an int value 
	            num = sc.nextLine();
	        } 
			} catch (RemoteException e) {
			e.printStackTrace();
			}
			System.out.println("Fin du client");
		
	}
}