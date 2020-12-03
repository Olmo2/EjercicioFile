package com.olmo.xml;

import java.io.Serializable;

public class Libro implements Serializable {
	private String titulo;
	private int anio;

	public Libro(String titulo, int anio) {
		super();
		this.titulo = titulo;
		this.anio = anio;
	}

	public Libro() {
		super();
		this.titulo = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

}
