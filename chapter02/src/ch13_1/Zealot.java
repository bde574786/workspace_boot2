package ch13_1;

public class Zealot extends Unit {

	// 부모에 있는 생성자를 먼저 호출 해야 한다.
	public Zealot(String name) {
		super(name);
		// super.name = name;
		// this();
	}
	public void beAttacked(int power) {
		System.out.println("질럿이 공격당했습니다");
		hp -= power;
	}

//	public void attack(Zergling zergling) {
//		zergling.beAttacked(power);
//	}
//
//	public void attack(Marine marine) {
//		marine.beAttacked(power);
//	}
//
//	public void attack(Zealot zealot) {
//		zealot.beAttacked(power);
//	}



}
