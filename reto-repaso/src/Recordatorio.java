import java.util.ArrayList;
import java.util.List;

public class Recordatorio {
	//Atributo, como es privado va a ser visible solo por esta clase
	private List<String> cajita;
	
	//Para poder guardar objetos en la lista debemos inicializarla en el constructor.
	public Recordatorio() {
		this.cajita = new ArrayList<String>();
	}

	//Metodos, son publicos asi que pueden ser usados por cualquiera a travéz de esta clase.
	public void recordar(String texto) {
		this.cajita.add(texto);
		System.out.println(texto);
	}
	
	//Overload de metodo recordar, maneja el caso en el que se quiera repetir la frase cant veces.
	public void recordar(String texto, Integer cant) {
		//Bucle cant veces
		this.cajita.add(texto);
		for(Integer i = 0; i < cant; ++i) {
			System.out.println(texto);
		}
	}
	
	//Overload de metodo recordar, maneja el caso de urgencia en la peticion.
	public void recordar(String texto, Integer cant, Boolean flag) {
		//No sabe aun, si flag es verdadero o falso.
		//¿Es flag == 1? (Es verdadero?) Es urgente
		//True => 1, False => 0
		if(flag) { //Recien aqui verifica si flag es verdadero o falso.
			//Mayusculas
			//En caso de querer guardar la frase original solo debemos
			//usar this.cajita.add(texto.toUpperCase()); y sout(texto.toUpperCase());
			texto = texto.toUpperCase();
			this.cajita.add(texto);
			for(Integer i = 0; i < cant; ++i) {
				System.out.println(texto);
			}
		//Si no es verdadero, quiere decir que es falso, entonces no es urgente
		} else {
			//Normalito
			this.cajita.add(texto);
			for(Integer i = 0; i < cant; ++i) {
				System.out.println(texto);
			}
		}
	}
	
	public void getFrases() {
		//Hacemos un for "corto" para iterar sobre la lista,
		//esto es identico a lo que seria un forEach en jsp.
		for(String item : this.cajita) {
			System.out.println(item);
		}
	}
}
