package codingdojo.test;

public class Bike extends Vehicle {
	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bike(int year, String brand, String model, int wheels) {
		super(year, brand, model, wheels);
		// TODO Auto-generated constructor stub
	}

	public void accelerate() {
		System.out.println("Let's pedal");
		this.speed += 1;
		System.out.println("My speed: "+this.speed);
	}
	
	public void decelerate() {
		System.out.println("Feet down!");
		this.speed -= 1;
		System.out.println("My speed: "+this.speed);
	}
}
