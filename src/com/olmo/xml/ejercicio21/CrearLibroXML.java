package com.olmo.xml.ejercicio21;

import org.w3c.dom.*;

import com.olmo.xml.Libro;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearLibroXML {
	public static void main(String args[]) throws IOException {
		File fichero = new File("FichLibro.dat");
		
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		Libro libro;
		System.out.println(fichero.length());
		int i = 0;
		int anio, posicion = 0; // para situarnos al principio del fichero
		String titulo;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Libros", null);
			document.setXmlVersion("1.0");
			

			while (i<100) { // lectura del fichero
				
				libro = (Libro) dataIS.readObject();
				i++;
				titulo = libro.getTitulo();
				anio = libro.getAnio();

				Element raiz = document.createElement("libro"); // nodo libro
				document.getDocumentElement().appendChild(raiz);

				CrearElemento("titulo", titulo, raiz, document);
				// añadir ID
				CrearElemento("anio", Integer.toString(anio), raiz, document);
				// Apellido

				
		
				

			} // fin del for que recorre el fichero

			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Libros.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);

		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataIS.close(); // cerrar fichero
	}// fin de main

	// Inserción de los datos del empleado
	static void CrearElemento(String datoLibro, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoLibro);
		Text text = document.createTextNode(valor); // damos valor
		raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}
}// fin de la clase
