package vergara_rodolfo_zoologico_p1;

public class Gorilla extends Mammal {
	
	public Gorilla(){
		super();
	}

	public void throwSomething() {
		System.out.println("Be careful! This Gorilla thinks that you want to rescue a Princess!");
		System.out.println("He is throwing barrels at you!");
		this.energyLevel-=5;
	}
	public void eatBananas() {
		System.out.println("It seems that you've been hit by one of those barrels...");
		System.out.println("Don't worry, you will revive using one of your lives, but be careful... The Gorilla DK is restoring energy");
		this.energyLevel+=10;
		
	}
	public void climb() {
		System.out.println("It seems that you've made it! You rescue the prince...");
		System.out.println("Oh no! The DK Gorilla kidnapped the princess again just in time and is climbing to the next level!");
		System.out.println("Hurry Up!");
		this.energyLevel-=10;
	}
}
