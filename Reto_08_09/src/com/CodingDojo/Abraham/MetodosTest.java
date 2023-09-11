package com.CodingDojo.Abraham;

import java.util.ArrayList;

public class MetodosTest {

	public static void main(String[] args) {
		/*
		Metodos met = new Metodos();
		
		met.recordatorio("frase 1");
		met.recordatorio("frase 2", 3);
		met.recordatorio("frase 3", 2, true);
		
		System.out.println(Metodos.recordatorios);
	}
	*/
		ArrayList<String> actores = new ArrayList<>();
		actores.add("johnny depp");
		actores.add("otros");
		
		ArrayList<Resenas> review = new ArrayList<>();
		Resenas re1 = new Resenas("Buena Pelicula adhvuahdfuyasdufyaoludyfaousydgfas", 8);
		review.add(re1);
		
		
		Peliculas pelicula1 = new Peliculas("piratas del caribe","juanito",2006,actores, review);
		
		
		// ---------------------------------------------------
		ArrayList<String> actores2 = new ArrayList<>();
		actores2.add("Henry Cavil");
		actores2.add("Ben Afflecasd");
		actores2.add("otros");
		
		ArrayList<Resenas> review2 = new ArrayList<>();
		Resenas re2 = new Resenas("maoma Pelicula adhvuahdfuyasdufyaoludyfaousydgfas", 9);
		review2.add(re2);
		
		
		Peliculas pelicula2 = new Peliculas("superman","director2",2014,actores2, review2);
		
		pelicula1.mostrarPelicula();
		System.out.println();
		pelicula2.mostrarPelicula();
	}
}
