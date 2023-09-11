
public class MainClass {
	public static void main(String[] args) {
		String texto = "Frase";
		Recordatorio test = new Recordatorio();
		test.recordar(texto);
		texto = "Repite 3 veces";
		test.recordar(texto, 3);
		texto = "Urgente";
		test.recordar(texto, 2, true);
		texto = "No Urgente";
		test.recordar(texto, 2, false);
		System.out.println("Dame todas las frases que te he dado.");
		test.getFrases();
	}
}
