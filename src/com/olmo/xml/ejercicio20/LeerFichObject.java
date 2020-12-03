package com.olmo.xml.ejercicio20;

import java.io.*;

import com.olmo.xml.Libro;

public class LeerFichObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Libro libro; // defino la variable libro
		File fichero = new File("FichLibro.dat");
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

		int i = 1;
		try {
			while (true) { // lectura del fichero
				libro = (Libro) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Título: %s, Año: %d %n",
						libro.getTitulo(),libro.getAnio());

			}
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
		}

		dataIS.close(); // cerrar stream de entrada
	}
}