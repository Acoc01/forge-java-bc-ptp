package com.CodingDojo.Abraham;

import java.util.ArrayList;

public class Peliculas {

	private String titulo;
	private String director;
	private int year;
	private ArrayList<String> actores;
	
	private ArrayList<Resenas> review;
	
	public Peliculas(){}


	public Peliculas(String titulo, String director, int year, ArrayList<String> actores) {
		this.titulo = titulo;
		this.director = director;
		this.year = year;
		this.actores = actores;
	}
	
	public void mostrarPelicula() {
		System.out.println(this.titulo+" "+this.director+" "+this.year);
		for(String actor:this.actores) {
			System.out.println(actor);
		}
		for(Resenas rev:this.review) {
			System.out.println(rev.getContenido() +" " +rev.getCalificacion());
		}
	}
	
	


	public Peliculas(String titulo, String director, int year, ArrayList<String> actores, ArrayList<Resenas> review) {
		this.titulo = titulo;
		this.director = director;
		this.year = year;
		this.actores = actores;
		this.review = review;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<String> getActores() {
		return actores;
	}

	public void setActores(ArrayList<String> actores) {
		this.actores = actores;
	}


	public ArrayList<Resenas> getReview() {
		return review;
	}


	public void setReview(ArrayList<Resenas> review) {
		this.review = review;
	}
	
}
