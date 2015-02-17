package com.javaOOPProject.server;

import java.io.IOException;

public class ServerMain {

	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("starting server");
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
