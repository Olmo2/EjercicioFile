package com.olmo.principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaFR {
/*Ejercicio 8*/
	public static void main(String[] args) {
		FileReader fr = null;
		File file =new File("c:/olmo/datos_copia.txt");
		FileWriter fw = null;
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 fw = new FileWriter(file,true);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			fr = new FileReader("c:/olmo/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			// se lee la primera línea del fichero
			String cadena = entrada.readLine(); 
			// mientras no se llegue al final del fichero
			while (cadena != null) { 
				// se nuestra por pantalla
				System.out.println(cadena); 
				fw.write(cadena + "\n");
				// se lee la siguiente línea del fichero
				cadena = entrada.readLine(); 
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
					fw.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}