package com.olmo.xml.ejercicio20;

import java.io.*;

import com.olmo.xml.Libro;

public class EscribirFichObject {
  public static void main(String[] args) throws IOException {   
   
   Libro libro;//defino variable persona
   
   File fichero = new File("FichLibro.dat");//declara el fichero
   FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
    //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
   
   String titulos[] = {"Quijote","Harry Potter","La guía del autoestopista intergaláctico","Los juegos del hambre",
		   "El señor de los anillos","La biblia","El corán","Mortadelo y Filemón","Asterix y Obelix"};
					   
   int anios[] = {1605,1998,1973,2005,1940,0001,0002,1986,1965};
   System.out.println("GRABO LOS DATOS DE LIBRO.");      
   for (int i=0;i<titulos.length; i++){ //recorro los arrays    
      libro= new Libro(titulos[i],anios[i]); //creo el libro  
	  dataOS.writeObject(libro); //escribo el libro en el fichero
	  System.out.println("GRABO LOS DATOS DE LIBRO.");  
   }     
   dataOS.close();  //cerrar stream de salida    
   }
}