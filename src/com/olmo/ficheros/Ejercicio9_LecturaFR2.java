package com.olmo.ficheros;

/*EJERCICICO 9*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio9_LecturaFR2 {
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
			// se lee el primer carácter del fichero
			int car = entrada.read(); 
			// mientras no se llegue al final del fichero
			while (car != -1) { 
				// se nuestra por pantalla
				System.out.print((char) car); 
				fw.write(car);
				 // se lee el siguiente carácter del fichero
				car = entrada.read();
			}
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