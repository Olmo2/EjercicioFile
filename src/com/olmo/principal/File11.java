package com.olmo.principal;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File11 {
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:/olmo/datos.txt", true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		PrintWriter salida = new PrintWriter(fw);
		
		
			
		//se crea el fichero     
		String cadena;          
		System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
		cadena = sc.nextLine();
		//se introduce por teclado una cadena de texto
		while (!cadena.equalsIgnoreCase("FIN")) { 
			salida.println(cadena); 
			//se escribe la cadena en el fichero
			cadena = sc.nextLine(); 
			//se introduce por teclado una cadena de texto 
			}
		salida.flush();
		salida.close();
		} 
}  
		