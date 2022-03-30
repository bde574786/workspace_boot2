package ch14;

public class Warrior extends Hero {
	
	public Warrior(String name, int hp, int power) {
		super(name, hp, power);
		super.setName("전사");
		super.setHp(10);
		super.setPower(10);
	}
	
	public void comboAttack() {
		System.out.println("이단 공격");
	}
	
	public void attack(Warrior warrior) {
		System.out.println( "자살 중");
	}
	
	public void attack(Archer archer) {
		System.out.println("궁수 공격 중");
	}
	
	public void attack(Wizard wizard) {
		System.out.println("마법사 공격 중");
	}
	
	@Override
	public void beAttacked(int power) {
		super.beAttacked(power);
		System.out.println(super.getName() + "가 공격 당했습니다.");
	}
	
	public void showInfo(Warrior warrior) {
		System.out.println("========정보창=========");
		System.out.println("이름 :" + getName());
		System.out.println("체력 : " + getHp());
		System.out.println("공격력 : " + getPower());
		System.out.println("=====================");
	}
	
	
	
	
}
