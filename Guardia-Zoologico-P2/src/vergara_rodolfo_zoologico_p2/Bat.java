package vergara_rodolfo_zoologico_p2;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("I'm the Dark Knight!");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Well i don't care. Justice.");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("This is not funny. Joker.");
		this.energyLevel -= 100;
	}
}
