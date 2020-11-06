package com.olmo.principal;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*Ejercicio 15*/
public class Ejercicio15_Binarios3 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		DataInputStream entrada = null;
		float n;
		try {
			fis = new FileInputStream("c:/olmo/datos.dat");
			entrada = new DataInputStream(fis);
			while (true) {
				// se lee un entero del fichero
				n = entrada.readFloat(); 
				// se muestra en pantalla
				System.out.println(n); 
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
