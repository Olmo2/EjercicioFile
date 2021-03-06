package com.olmo.ficheros;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* EJERCICIO 13*/
public class Ejercicio13_Binarios1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = null;
		DataOutputStream salida = null;
		int n;
		try {
			fos = new FileOutputStream("C:\\Users\\OLMO\\binarios.dat");
			salida = new DataOutputStream(fos);
			System.out.print("Introduce n�mero float. -1 para acabar: ");
			n = sc.nextInt();
			while (n != -1) {
				salida.writeFloat(n); // se escribe el n�mero entero en el fichero
				System.out.print("Introduce n�mero float. -1 para acabar: ");
				n = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
