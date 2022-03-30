package ch13;

public class Unit {
	
	protected String name;
	protected int power;
	protected int hp;
	
	// 부모 클래스에 사용자 정의 생성자가 있을 경우 
	public Unit(String name) {
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + name );
		System.out.println("공격력 : " + power );
		System.out.println("체력 : " + hp );
	}
	
}
