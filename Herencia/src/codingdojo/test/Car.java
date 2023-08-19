package codingdojo.test;

public class Car extends Vehicle {
	
	private String licensePlate;

	public Car(int year, String brand, String model, int wheels, String licensePlate) {
		super(year, brand, model, wheels);
		this.licensePlate = licensePlate;
		this.speed = 0;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return super.toString()+"Car [licensePlate=" + licensePlate + ", speed=" + speed + "]";
	}
	
	public void accelerate() {
		System.out.println("Let's accelerate");
		this.speed += 2;
		System.out.println("My speed: "+this.speed);
	}
	
	public void decelerate() {
		System.out.println("Let's decelerate");
		this.speed -= 2;
		System.out.println("My speed: "+this.speed);
	}
	
}
