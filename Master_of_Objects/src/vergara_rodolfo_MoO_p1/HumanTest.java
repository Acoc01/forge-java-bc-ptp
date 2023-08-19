package vergara_rodolfo_MoO_p1;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human Jeff = new Human();
		Human Ninja = new Human();
		
		System.out.println("Jeff health: "+Jeff.getHealth());
		
		System.out.println("Ninja health: "+Ninja.getHealth());
		
		Ninja.attack(Jeff);
		System.out.println("Jeff health: "+Jeff.getHealth());
	}

}
