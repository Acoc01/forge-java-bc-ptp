package codingdojo.test;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle boat = new Vehicle(2015, "B123", "ModelBoat", 0);
		
		System.out.println(boat.getModel());
		
		ArrayList<Integer> x = new ArrayList<Integer>();
		
		Car car1 = new Car(2020, "Mazda", "CX-3", 4, "ABC");
		
		System.out.println(car1);
		car1.accelerate();
		car1.accelerate();
		car1.decelerate();
		
		Bike bike1 = new Bike(2023, "BikeBrand", "BikeModel", 2);
		
		bike1.accelerate();
		bike1.accelerate();
		bike1.decelerate();
	}

}
