package com.olmo.principal;

import java.io.File;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		File file2 = new File("C:\\olmo" + "nombre");
		 
		if(args.length>0) {
			for(int i =0;i<args.length;i++) {
				File file = new File("C:\\olmo" , args[i]);
				System.out.println("Nombre: " + file.getName());
				System.out.println("Ruta: " + file.getPath());
				if(file.exists()) {
					System.out.println("Fichero existente");
					System.out.println( (file.canRead() ? " y se puede Leer" : "" ));
					System.out.println(  (file.canWrite() ? " y se puede Escribir" : "" ));
					System.out.println(" . ");
					System.out.println("La longitud del fichero son " + file.length() + " Bytes");
					
					System.out.println("Ruta absoluta" + file.getAbsolutePath());
					System.out.println("Directorio padre: " + file.getParent());
					Date date = new Date(file.lastModified());
					System.out.println("Feca de última modificación: " + date);
					file.renameTo(file2);
					System.out.println(file.getName());
					
				}else {
					System.out.println("Fichero no existente");
				}
			}
		}else {
			System.out.println("indique un fichero");
		}

	}

}
