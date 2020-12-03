package com.olmo.xml.ejercicio23;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.olmo.xml.Libro;

public class SaxLibros {		
	
	
	public static void main(String[] args)
              throws FileNotFoundException, IOException, SAXException{		
	 XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido gestor= new GestionContenido();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("Libros.xml");	    
       procesadorXML.parse(fileXML);   
       
	}
	
}//fin PruebaSax1

class GestionContenido extends DefaultHandler {	 
	
	Libro libro;
	ArrayList<Libro> libros = new ArrayList<Libro>();
	int lib;
	    public GestionContenido() {
	        super();
	    }	    
	    public void startDocument() {
	        System.out.println("Comienzo del Documento XML");
	    }	    
	    public void endDocument() {
	        System.out.println("Final del Documento XML");
	        for(int i=0;i<libros.size();i++) {
		    	   System.out.println(libros.get(i).toString());
		       }
	    }	 	    
	    public void startElement(String uri, String nombre,
	              String nombreC, Attributes atts) {
	    	System.out.printf("\t Principio Elemento: %s %n",nombre);
	    	
	    	
	    	if(nombre=="titulo") {
	    		libro=new Libro();
	        	lib=1;
	        }else if(nombre=="anio") {
	        	lib=2;
	        	//p.libro.setAnio(Integer.parseInt(atts.getValue(0)));
	        }else {
	        	lib=3;
	        }
	    } 	
	    public void endElement(String uri, String nombre, 
                          String nombreC) {
	    	lib=3;
	    	if(nombre=="libro") {
	    		
	    		libros.add(libro);
	    	}
	        System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    public void characters(char[] ch, int inicio, int longitud) 
                                            throws SAXException {
		   String car=new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   System.out.printf ("\t Caracteres: %s %n", car);	
		   if(lib==1) {
			  
			   libro.setTitulo(car);
		   }else if(lib==2){
			   libro.setAnio(Integer.parseInt(car));
		   }
		  
	    }	
	    
	   

}//fin GestionContenido
