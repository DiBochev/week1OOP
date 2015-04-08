package com.javaOOPProject.server;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.javaOOPProject.server.registeredClients.RegisteredClients;


public class XMLManager {

	public static String createResponse(){
		  try {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		 
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("response");
				doc.appendChild(rootElement);
		 
				// firstname elements
				Element loginSuccess = doc.createElement("loginSuccess");
				loginSuccess.appendChild(doc.createTextNode("true"));
				rootElement.appendChild(loginSuccess);
		 
				// lastname elements
				Element serverMessage = doc.createElement("serverMessage");
				serverMessage.appendChild(doc.createTextNode("error0"));
				rootElement.appendChild(serverMessage);
		 
				// nickname elements
				Element permissionForCrypt = doc.createElement("permissionForCrypt");
				permissionForCrypt.appendChild(doc.createTextNode("true"));
				rootElement.appendChild(permissionForCrypt);
		 
				// write the content into xml String
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StringWriter writer = new StringWriter();
				transformer.transform(new DOMSource(doc), new StreamResult(writer));
				System.out.println(writer.getBuffer().toString());
				
				
				return writer.getBuffer().toString();
		 
			  } catch (ParserConfigurationException e) {
				e.printStackTrace();
			  } catch (TransformerException e) {
				e.printStackTrace();
			  }
		return null;
	}

	public static RegisteredClients loadData(String path) throws JAXBException, IOException{
		String xmlData = readFile(path);
		
		JAXBContext context = JAXBContext.newInstance(RegisteredClients.class);
		Unmarshaller un = context.createUnmarshaller();
		StringReader sReader = new StringReader(xmlData);
		RegisteredClients reg = (RegisteredClients) un.unmarshal(sReader);
		return reg;
		
	}
	
	private static String readFile(String path) throws IOException, JAXBException {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				line = bufferedReader.readLine();
			}
		}
		return stringBuilder.toString();
	}
}
