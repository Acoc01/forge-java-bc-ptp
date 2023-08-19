package vergara_rodolfo_MoO_p2;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Samurai Kishimoto = new Samurai();
		Samurai Yagamatsu = new Samurai();
		Wizard Rudeus = new Wizard();
		Rudeus.attack(Kishimoto);
		System.out.println("Hay "+Yagamatsu.howMany()+" Samurais");
	}

}
