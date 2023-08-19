package vergara_rodolfo_MoO_p2;

public class Samurai extends Human {
	private static int count = 0;
	public Samurai() {
		super();
		this.health = 200;
		this.count++;
	}
	
	public void deathBlow(Human objective) {
		objective.setHealth(objective.getHealth()-objective.getHealth());
		this.health /= 2;
	}
	
	public void meditate() {
		this.health += this.health/2;
	}
	
	public int howMany() {
		return this.count;
	}
	

}
