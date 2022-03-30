package ch13;

public class Marine extends Unit {

	public Marine(String name) {
		super(name);
		//super.name = name;
	}

	// 강제어택
	public void attack(Marine marine) {
		marine.beAttacked(power);
	}
	
	public void attack(Zergling zergling) {
		zergling.beAttacked(power);
	}
	
	public void attack(Zealot zealot) {
		zealot.beAttacked(power);
	}
	
	public void beAttacked(int power) {
		super.hp -= power;
	}
	
	
}
