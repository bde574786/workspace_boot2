package ch13_1;

public class Unit {

	protected String name;
	protected int power;
	protected int hp;

	// 부모 클래스에 사용자 정의 생성자가 있을 경우
	public Unit(String name) {
		this.name = name;
	}

	
	
	public void showInfo() {
		System.out.println("=====정보창====");
		System.out.println("이름 : " + name);
		System.out.println("공격력 : " + power);
		System.out.println("생명력 : " + hp);
		System.out.println("==============");
	}

	// 다형성이라는 개념을 배움
	public void attack(Unit unit) {
		if(unit instanceof Zealot) {
			System.out.println(name + "이 질럿을 공격합니다.");
			beAttacked(this.power);
		} else if(unit instanceof Marine) {
			System.out.println(name + "이 마린을 공격합니다.");
			beAttacked(this.power);
		} else if(unit instanceof Zergling) {
			System.out.println(name + "이 저글링을 공격합니다.");
			beAttacked(this.power);
		}
		
	}

	public void beAttacked(int power) {
		hp -= power;
	}

}
