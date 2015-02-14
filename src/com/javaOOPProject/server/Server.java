package com.javaOOPProject.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	private final int PORT = 12345;
	private ServerSocket server;
	private ArrayList<ConnectedClient> connectedClients;
	private ExecutorService clientPool;
	
	public Server(){
		initializeServer();
		clientPool = Executors.newCachedThreadPool();
		connectedClients = new ArrayList<ConnectedClient>(10);
	}
	
	private void initializeServer(){
		try {
			server = new ServerSocket(this.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException{
		while (true) {
			waitForConnection();
			executeClient(connectedClients.get(connectedClients.size() - 1));
		}
	}
	
	private void waitForConnection() throws IOException{
		addConnectedCliend((server.accept()));
		System.out.println("client connect: " + connectedClients.get(connectedClients.size() - 1).getSocket());
	}
	
	private void addConnectedCliend(Socket connection) throws IOException{
		this.connectedClients.add(new ConnectedClient(connection));
	}
	
	private void executeClient(ConnectedClient cc){
		clientPool.execute(cc);
	}
}
