package com.olmo.xml.ejercicio24;

import java.io.*;

import com.olmo.xml.Libro;
import com.thoughtworks.xstream.XStream;

public class EscribirLibros {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File fichero = new File("FichLibro.dat");
		 // flujo de entrada
		// conecta el flujo de bytes al flujo de datos
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		System.out.println("Comienza el proceso de creación del fichero a XML ...");

		// Creamos un objeto Lista de Libros
		ListaLibros listaLib = new ListaLibros();

		try {
			while (true) { // lectura del fichero
				// leer un Libro
				Libro libro = (Libro) dataIS.readObject();
				listaLib.add(libro); // añadir libro a la lista
			}
		} catch (EOFException eo) {
		}
		dataIS.close(); // cerrar stream de entrada

		try {
			XStream xstream = new XStream();
			// cambiar de nombre a las etiquetas XML
			xstream.alias("ListaLibrosMunicipio", ListaLibros.class);
			xstream.alias("DatosLibro", Libro.class);

			
			// quitar etiqueta lista (atributo de la claseListaPersonas)
			xstream.addImplicitCollection(ListaLibros.class, "lista");
			// Insertar los objetos en el XML
			xstream.toXML(listaLib, new FileOutputStream("Libros.xml"));
			System.out.println("Creado fichero XML....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // fin main
} // fin EscribirPersonas
