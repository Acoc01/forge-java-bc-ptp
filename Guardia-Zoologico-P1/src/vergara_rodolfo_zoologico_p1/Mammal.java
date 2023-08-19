package vergara_rodolfo_zoologico_p1;

public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energia: "+this.energyLevel);
		return this.energyLevel;
	}
}
