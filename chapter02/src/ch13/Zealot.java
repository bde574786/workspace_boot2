package ch13;

public class Zealot extends Unit{

	public Zealot(String name) {
		// 부모에 있는 생성자를 먼저 호출해야 한다.
		super(name);
		//super.name = name;
		//this()
		// 부모 클래스에 사용자 정의 생성자가 있으면 반드시 부모 클래스의 생성자를 먼저 호출
	}

	// 공격 메서드
	
	// 공격합니다. 질럿 --> 마린을
	public void attackMarine(Marine marine) {
		System.out.println(name + "이 공격합니다");
		marine.beAttacked(power);
		// this.power, super.power 둘 다 허용
	}

	// 메서드 오버로딩
	// 메서드 이름이 같더라도 매개변수, 리턴 타입이 다를 경우
	// 컴파일러는 구분이 가능하다.
	
	// 강제 어택
	public void attack(Zealot zealot) {
		zealot.beAttacked(power);
	}
	
	public void attack(Marine marine) {
		marine.beAttacked(power);
	}
	
	public void attack(Zergling zergling) {
		zergling.beAttacked(power);
	}
	
	public void beAttacked(int power) {
		super.hp -= power;
	}
	
	
	
}
