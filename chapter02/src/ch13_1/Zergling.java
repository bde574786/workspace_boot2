package ch13_1;

public class Zergling extends Unit {

	public Zergling(String name, int power, int hp) {
		super(name);
		// super.name = name;
	}

	public void beAttacked(int power) {
		System.out.println("저글링이 공격당했습니다");
		hp -= power;
	}
//	public void attack(Marine marine) {
//		marine.beAttacked(power);
//	}
//    
//	// 강제 어택 
//	public void attack(Zergling zergling) {
//		zergling.beAttacked(power);
//	}
//	
//	public void attack(Zealot zealot) {
//		zealot.beAttacked(power);
//	}
	

 

}
