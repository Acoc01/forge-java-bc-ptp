package com.CodingDojo.Abraham;

import java.util.ArrayList;

public class Metodos {
	public static ArrayList<String> recordatorios = new ArrayList<>();
	
	
	public void recordatorio(String frase) {
		System.out.println(frase);
		recordatorios.add(frase);
	}
	
	public void recordatorio(String frase, int numero) {
		
		for(int i = 0; i<numero; i++) {
			System.out.println(frase);	
			recordatorios.add(frase);
		}
	}
	public void recordatorio(String frase, int numero, boolean urgente) {
		
		for(int i = 0; i<numero; i++) {
			if(urgente == true) {
				String fraseFinal = frase.toUpperCase();
				System.out.println(fraseFinal);	
				recordatorios.add(fraseFinal);
			}else {
				String fraseFinal2 = frase.toLowerCase();
				System.out.println(fraseFinal2);	
				recordatorios.add(fraseFinal2);
			}
		}
	
	}
}
