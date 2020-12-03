package com.olmo.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio16_Binarios4 {
	
	Ejercicio14_Binarios2 ej= new Ejercicio14_Binarios2();
	
	Double[][] m = ej.matriz();
	
	int row = m.length;
	int col= m[0].length;
	Double num;
	Scanner sc = new Scanner(System.in);
	File file = new File("C:/test/ejercicio14.dat");
	FileInputStream fis = null;

	
	DataInputStream dis=null;
	FileOutputStream fos = null;
	DataOutputStream dos = null;
	
	
	
	public void leer() throws FileNotFoundException {
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
		
	for(int i =0;i<row;i++) {
		for(int j=0;j<col;j++) {
			try {
				System.out.println(dis.readDouble());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
	public static void main(String[] args) throws FileNotFoundException {
		Ejercicio16_Binarios4 ej = new Ejercicio16_Binarios4();
		ej.leer();
	}
	
	
}

