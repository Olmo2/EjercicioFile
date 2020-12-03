package com.olmo.xml.ejercicio24;

import java.util.ArrayList;
import java.util.List;

import com.olmo.xml.Libro;
public class ListaLibros {
	
    private List<Libro> lista = new ArrayList<Libro>();
    
    public ListaLibros(){    	
    }

    public void add(Libro lib) {
            lista.add(lib);
    }
   
   public List<Libro> getListaLibros() {
            return lista;
    }
}

