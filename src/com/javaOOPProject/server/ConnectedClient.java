package com.javaOOPProject.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectedClient implements Runnable{

	private Socket socket;
	private Scanner input;
	private PrintWriter out;
	
	public ConnectedClient(Socket connection) throws IOException{
		this.setSocket(connection);
	}

	@Override
	public void run() {
		try {
			getClientSream();
			sendCLientMassage("hello");
			System.out.println(recieveMassage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String recieveMassage() throws IOException {
		input = new Scanner(socket.getInputStream());
		return input.nextLine();
		
	}

	private void getClientSream() throws IOException {
		input = new Scanner(getSocket().getInputStream());
//		input.close();
	}
	private void sendCLientMassage(String massage) throws IOException {
		out = new PrintWriter(getSocket().getOutputStream());
		out.println(massage);
		out.flush();
//		out.close();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
