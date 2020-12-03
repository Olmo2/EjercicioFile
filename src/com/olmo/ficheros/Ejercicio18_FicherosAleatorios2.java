package com.olmo.ficheros;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/*ejercicio 17*/
public class Ejercicio18_FicherosAleatorios2 {

	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile fichero = null;

	
	public static void llenarFichero() throws IOException {
	fichero.writeInt(1);
	fichero.writeInt(2);
	fichero.writeInt(3);
	fichero.writeInt(4);
}
	public static void main(String[] args) {
		int pos;
		int num;
		int numAux;
		int numEnteros;
		try {
			//se abre el fichero para lectura y escritura
			fichero = new RandomAccessFile("c:/test/enteros.dat", "rw");
			
			 // muestra el contenido original del fichero
			

			if(fichero.length()==0) {
				llenarFichero();
			}
			mostrarFichero();
		
			System.out.print("Introduce la posicion del número a editar: ");
			// se lee la posicion del entero a editar en el fichero
			pos = sc.nextInt(); 
			
			System.out.print("Introduce el entero que quieres escribir: ");
			// se lee el entero a añadir en el fichero
			num = sc.nextInt(); 
			numEnteros=(int) fichero.length()/4;
			
			// nos situamos en la posicion indiicada * 4(final del número) y le restamos 4 para estar al principio
			fichero.seek((pos*4)-4); 
			System.out.println("Número actual: " + fichero.readInt());
			fichero.seek(fichero.getFilePointer()-4);
			fichero.writeInt(num); // se escribe el entero

			
			mostrarFichero();// muestra el contenido del fichero después de añadir el número
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void mostrarFichero() {
		int n;
		try {
			fichero.seek(0); // nos situamos al principio
			while (true) {
				n = fichero.readInt(); // se lee un entero del fichero
				System.out.println(n); // se muestra en pantalla
			}
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
