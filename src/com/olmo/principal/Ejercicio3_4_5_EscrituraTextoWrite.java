package com.olmo.principal;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3_4_5_EscrituraTextoWrite {
	public static void main(String[] args) {
//Creamos un String para almacenar el nombre del fichero en que escribir
//Utiliza una ruta en la que puedas crear ficheros en tu equipo 
		String fich = new String("C:\\olmo\\escritext.txt");
//Declaramos un objeto de tipo FileWriter
		FileWriter fw = null;
		try {
			// Creamos un nuevo objeto de tipo FileWriter
			fw = new FileWriter(fich);
			// Escribimos un número entero que indicará un carácter a escribir según el
			// código ASCII. En este caso el número 65 es la letra A mayúscula
			fw.write(65);
			// Escribimos una cadena
			fw.write("Esto es una prueba de escritura");
			// Escribimos un salto de línea en algunas Sistemas Operativos basta con poner
			// \n y en otros hay que poner \r\n
			fw.write("\r\n");
			// Escribimos en el fichero parte del String que guarda la ruta del fichero
			// En este ejemplo empezamos en la primera posición y escribimos 5 caracteres
			fw.write(fich, 0, 5);
			// En este ejemplo empezamos en la primera 3 y escribimos 4 caracteres
			fw.write(fich, 3, 4);
			fw.write("\r\n");
			
			
			//Ejercico 4
			//O
			fw.write(79);
			fw.write("\r\n");
			//l
			fw.write(108);
			fw.write("\r\n");
			//m
			fw.write(109);
			fw.write("\r\n");
			//o
			fw.write(111);
			fw.write("\r\n");
			
			//Ejercicio 5
			String texto = "Anita, la gorda lagartona, no traga la droga latina";
			
			//fw.write(texto.substring(0,6));
			fw.write(texto,0,6);
			fw.write("\r\n");
//			fw.write(texto.substring(7,9));
			fw.write(texto,7,2);
			fw.write("\r\n");
//			fw.write(texto.substring(10,15));
			fw.write(texto,10,5);
			fw.write("\r\n");
//			fw.write(texto.substring(16,26));
			fw.write(texto,16,10);
			fw.write("\r\n");
//			fw.write(texto.substring(27,29));
			fw.write(texto,27,2);
			fw.write("\r\n");
//			fw.write(texto.substring(30,35));
			fw.write(texto,30,5);
			fw.write("\r\n");
//			fw.write(texto.substring(36,38));
			fw.write(texto,36,2);
			fw.write("\r\n");
//			fw.write(texto.substring(39,44));
			fw.write(texto,39,5);
			fw.write("\r\n");
//			fw.write(texto.substring(45));
			fw.write(texto,45,6);
			fw.write("\r\n");
			
			for(int i=texto.length()-1; i>=0 ;i--) {
				char c= texto.charAt(i);
				fw.write(c);
				System.out.println(texto.charAt(i));
			}
			
			
		
				
				
		
			
			// Cerramos el fichero
			fw.close();
		}
		// Capturamos las excepciones de fichero no encontrado y de error de
		// entrada/salida
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
