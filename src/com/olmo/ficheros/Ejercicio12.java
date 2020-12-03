package com.olmo.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner sc =null;
		StringTokenizer st;
		File file = new File("c:/olmo/enteros.txt") ;
		int i =0;
		int suma=0;
		String str;
		int num;
		
		try {
			 sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sc.hasNextLine()) {
			str= sc.nextLine();
			st=new StringTokenizer(str);
			 while (st.hasMoreTokens()) {
				 num=Integer.parseInt(st.nextToken());
		         System.out.println(num);
		         suma+=num;
		         i++;
		     }
		}
		sc.close();
		System.out.println("Números Leídos: " + i);
		System.out.println("Suma: " + suma);
		
		
	}
}
