package com.javaOOPProject.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private final String host = "localhost";
	private final int PORT = 12345;
	private Socket socket;
	private Scanner input;
	private PrintWriter out;
	
	public Client() throws UnknownHostException, IOException{
		initializeSocket();
	}
	
	private void initializeSocket() throws UnknownHostException, IOException{
		socket = new Socket(InetAddress.getByName(host), PORT);
	}
	
	private void sentMassageToServer(String massage) throws IOException{
		out = new PrintWriter(socket.getOutputStream());
		out.println(massage);
		out.flush();
		out.close();
	}

	public String recieveMassage() throws IOException{
		input = new Scanner(socket.getInputStream());
		return input.nextLine();
	}
	
	public void sendMassage(String massage) throws IOException {
		sentMassageToServer(massage);
	}
}
