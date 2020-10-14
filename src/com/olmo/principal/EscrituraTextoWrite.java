package com.olmo.principal;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraTextoWrite {
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
			
			fw.write(texto.substring(0,6));
			fw.write("\r\n");
			fw.write(texto.substring(7,8));
			fw.write("\r\n");
			fw.write(texto.substring(10,14));
			fw.write("\r\n");
			fw.write(texto.substring(16,25));
			fw.write("\r\n");
			fw.write(texto.substring(27,28));
			fw.write("\r\n");
			fw.write(texto.substring(30,34));
			fw.write("\r\n");
			fw.write(texto.substring(36,37));
			fw.write("\r\n");
			fw.write(texto.substring(39,43));
			fw.write("\r\n");
			fw.write(texto.substring(45,50));
			
			
			for(int i=0;i<texto.length();i++) {
				fw.write(texto.charAt(i));
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
