package vergara_rodolfo_MoO_p2;

public class Wizard extends Human{
	public Wizard() {
		super();
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal(Human objective) {
		objective.setHealth(objective.getHealth()+(this.intelligence*3));
	}
	
	public void fireball(Human objective) {
		objective.setHealth(objective.getHealth()-(this.intelligence*3));
	}
}
