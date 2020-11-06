package com.olmo.principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* EJERCICIOS 10 */
public class Ejercicio10_FileScanner {
	public static void main(String[] args) {
		File f = new File("c:/olmo/datos.txt");
		String cadena;
		Scanner entrada = null;
		try {
			// se crea un Scanner asociado al fichero
			entrada = new Scanner(f);
			// mientras no se alcance el final del fichero
			while (entrada.hasNext()) {
				// se lee una línea del fichero
				cadena = entrada.nextLine();
				// se muestra por pantalla
				System.out.println(cadena);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			entrada.close();
		}
	}
}