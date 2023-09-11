package com.CodingDojo.Abraham;

public class Resenas {
	
	private String contenido;
	private int calificacion;
	
	public Resenas (String text) {
		this.contenido = text;
	}
	

	public Resenas(String contenido, int calificacion) {
		this.contenido = contenido;
		this.calificacion = calificacion;
	}


	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
}
