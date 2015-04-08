package com.javaOOPProject.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {

	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public RequestHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			recieveMassage();
			processRequest();
			sendClientMassage("hello ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String recieveMassage() throws IOException {
		ois = new ObjectInputStream(socket.getInputStream());
		String message = null;
		try {
			message = (String) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("client send: " + message);
		return message;
	}

	private void sendClientMassage(String massage) throws IOException {
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(massage);
		oos.close();
		socket.close();
		System.out.println("sended massage: " + massage);
	}

	private void processRequest(){
		
	}
}
