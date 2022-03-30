package starcraft_game.zerg;


public class Chamber {

	public void upgradeAttack() {
		Zergling.attack++;
		Hydra.attack++;
		Ultra.attack++;
	}
	
	public void upgradeArmor() {
		Zergling.armor++;
		Hydra.armor++;
		Ultra.armor++;
	}
	
}
