package com.olmo.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner sc =null;
		File file = new File("c:/olmo/enteros.txt") ;
		int i =0;
		int suma=0;
		int num;
		
		try {
			 sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sc.hasNextInt()) {
			num= sc.nextInt();
		System.out.println(num);
		i++;
		suma+=num;
		}
		sc.close();
		System.out.println("Números Leídos: " + i);
		System.out.println("Suma: " + suma);
		
		
	}

}
