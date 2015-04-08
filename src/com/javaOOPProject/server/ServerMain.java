package com.javaOOPProject.server;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.javaOOPProject.server.registeredClients.RegisteredClients;

public class ServerMain {

	public static void main(String[] args) {
		RegisteredClients reg;
		try {
			reg = XMLManager.loadData("data\\registeredClients.xml");
		} catch (JAXBException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
//		Server server = new Server();
//		System.out.println("starting server");
//		try {
//			server.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
