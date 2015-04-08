package com.javaOOPProject.server.registeredClients;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisteredClients {
	
	@XmlElement(name = "client")
	private ArrayList<Client> array;
	
	private RegisteredClients(){
	}
	
	public ArrayList<Client> getArray() {
		return array;
	}

	public void setArray(ArrayList<Client> array) {
		this.array = array;
	}

	
	
	
	
	//client starts

	@XmlRootElement(name = "client")
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Client{
		
		@XmlElement(name = "username")
		private
		String username;
		@XmlElement(name = "password")
		private
		String password;
		@XmlElement(name = "permissionForCrypt")
		private boolean permissionForCrypt;
		
		@XmlElement(name = "cryptedCard")
		private ArrayList<String> cards;
		
		private Client(){
		}
//		public String getUsername() {
//			return username;
//		}
//		public void setUsername(String username) {
//			this.username = username;
//		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		public boolean isPermissionForCrypt() {
//			return permissionForCrypt;
//		}
//		public void setPermissionForCrypt(boolean permissionForCrypt) {
//			this.permissionForCrypt = permissionForCrypt;
//		}
	}
}

