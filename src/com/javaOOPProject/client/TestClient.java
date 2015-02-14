package com.javaOOPProject.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		ArrayList<Client> array = new ArrayList<Client>();
		for (int i = 0; i < 10; i++) {
			array.add(new Client());
			System.out.println(array.get(i).recieveMassage());
		}
		
		for (int i = 0; i < array.size(); i++) {
			array.get(i).sendMassage("hello i am  " + i);
		}
	}	
}
