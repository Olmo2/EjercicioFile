package com.olmo.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;



/*Ejercicio 14*/

/*
    Escribe un programa Java que cree una matriz de elementos de tipo double y lea por
	teclado el valor de sus elementos. 
	
	El número de filas y de columnas se le pedirán al
	usuario que las introduzca mediante el teclado.

	A continuación debe escribir el contenido de la matriz en un fichero.
	Al principio del fichero (antes de escribir los datos de la matriz) se escriben dos enteros
	con los valores del número de filas y columnas de la matriz. */
public class Ejercicio14_Binarios2 {
	
	
	public Double[][] matriz() {
	int row;
	int col;
	Double num;
	Scanner sc = new Scanner(System.in);
	File file = new File("C:/test/ejercicio14.dat");
	FileInputStream fis = null;
	DataInputStream dis=null;
	FileOutputStream fos = null;
	DataOutputStream dos = null;
	
	
	try {
		fos = new FileOutputStream(file, true);
		dos = new DataOutputStream(fos);
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Introduce el número de filas: ");
	row= sc.nextInt();
	
	System.out.println("Introduce el número de columnas: ");
	col= sc.nextInt();
	
	
	try {
		dos.writeInt(row);
		dos.writeInt(col);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Double[][] m = new Double[row][col] ;
	
	for(int i =0;i<row;i++) {
		for(int j=0;j<col;j++) {
			System.out.println("numero para la matriz: ");
			num=sc.nextDouble();
			m[i][j]=num; 
			
			try {
				dos.writeDouble(num);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	try {
		fos.close();
		dos.close();
		fis.close();
		dis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return m;

	}
	
	
}
