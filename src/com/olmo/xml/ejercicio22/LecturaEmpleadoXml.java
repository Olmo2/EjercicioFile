package com.olmo.xml.ejercicio22;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXml {
	 public static void main(String[] args) {

	  DocumentBuilderFactory factory =
	                         DocumentBuilderFactory.newInstance();

	  try {	 
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new File("Libros.xml"));
	    document.getDocumentElement().normalize();

	    System.out.printf("Elemento raiz: %s %n", 
				   document.getDocumentElement().getNodeName());
	    //crea una lista con todos los nodos empleado  
	    NodeList libros = document.getElementsByTagName("libro");      
	    System.out.printf("Nodos libro a recorrer: %d %n", 
	                                              libros.getLength());

	    //recorrer la lista  
	    for (int i = 0; i < libros.getLength(); i ++) {
		Node lib = libros.item(i); //obtener un nodo empleado
		if (lib.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
	        //obtener los elementos del nodo           
	        Element elemento = (Element) lib;	
	        System.out.printf("Titulo = %s %n",	
	 	     elemento.getElementsByTagName("titulo").
	                                     item(0).getTextContent());
	        System.out.printf(" * Anio = %s %n",
		     elemento.getElementsByTagName("anio").
	                                     item(0).getTextContent());
		}
	    }
	  } catch (Exception e) 
	    {e.printStackTrace();}

	 }//fin de main 
	}//fin de la clase

