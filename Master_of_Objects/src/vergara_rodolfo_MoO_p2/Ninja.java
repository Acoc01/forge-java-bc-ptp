package vergara_rodolfo_MoO_p2;

public class Ninja extends Human{
	
	public Ninja() {
		super();
		this.stealth = 10;
	}
	
	public void steal(Human objective) {
		objective.setHealth(objective.getHealth()-this.stealth);
		this.health += this.stealth;
	}
	
	public void runAway() {
		this.health -= 10;
	}
}
