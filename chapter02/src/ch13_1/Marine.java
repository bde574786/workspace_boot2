package ch13_1;

public class Marine extends Unit {

	public Marine(String name, int power, int hp) {
		super(name);
		// super.name = name;
	}

	public void beAttacked(int power) {
		System.out.println("마린이 공격당했습니다");
		hp -= power;
	}
	
	// 메서드 오버로딩
	// ( 메세드 이름이 같은 녀셕이라도 매개변수, 리턴타입 다를 경우
	// 컴파일러는 구분이 가능 하다.
	// 강제 어택
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
