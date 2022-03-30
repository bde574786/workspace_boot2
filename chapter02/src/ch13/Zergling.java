package ch13;

public class Zergling extends Unit {

	public Zergling(String name) {
		super(name);
		//super.name = name;
	}

	public void attack(Zergling zergling) {
		zergling.beAttacked(power);
	}
	
	public void attack(Zealot zealot) {
		zealot.beAttacked(power);
	}

	public void attack(Marine marine) {
		marine.beAttacked(power);
	}
	
	public void beAttacked(int power) {
		super.hp -= power;
	}
	
}
