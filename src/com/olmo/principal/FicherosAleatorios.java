package com.olmo.principal;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class FicherosAleatorios {

	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile fichero = null;

	public static void main(String[] args) {
		int numero;
		int numAux;
		int numEnteros;
		try {
			//se abre el fichero para lectura y escritura
			fichero = new RandomAccessFile("c:/olmo/enteros.dat", "rw");
			
			 // muestra el contenido original del fichero
			
//			fichero.seek(12);
//			System.out.println(fichero.readInt());
//			System.out.println(fichero.getFilePointer());
//			fichero.write(9);
			mostrarFichero();
			System.out.print("Introduce un número entero para añadir al principio del fichero: ");
			// se lee el entero a añadir en el fichero
			numero = sc.nextInt(); 
			numEnteros=(int) fichero.length()/4;
			// nos situamos al final del fichero, vamos 4 bytes para atras para enfocar el último numero
			fichero.seek(fichero.length()-4); 
			
			
			//Lectura y escritura del número en la nueva posicion 
			numAux=fichero.readInt();
			fichero.writeInt(numAux);/*ahora está en la posicion 20*/
			System.out.println(numAux);
			fichero.seek(8); 
			
			numAux=fichero.readInt();
			fichero.writeInt(numAux);/*ahora está en la posicion 16*/
			
			fichero.seek(4); 
			
			numAux=fichero.readInt();
			fichero.writeInt(numAux);/*ahora está en la posicion 12*/
			
			fichero.seek(0); 
			
			numAux=fichero.readInt();
			fichero.writeInt(numAux);/*ahora está en la posicion 8*/
			
			
			fichero.seek(0); 
			fichero.writeInt(numero); // se escribe el entero
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
