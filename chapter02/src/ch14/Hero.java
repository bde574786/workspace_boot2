package ch14;

public class Hero {

	private String name;
	private int hp;
	private int power;
	
	Hero(String name, int hp, int power){
		this.name = name;
		this.hp = hp;
		this.power = power;
	}
	
	public void attack() {
		System.out.println(this.name + "이 공격 중");
	}

	public String getName() {
		System.out.println(this.name + "를 선택하셨습니다.");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public void beAttacked(int power) {
		this.hp -= power;
	}
	
	
	public void showInfo() {
		System.out.println("========정보창=========");
		System.out.println("이름 :" + name);
		System.out.println("체력 : " + hp);
		System.out.println("공격력 : " + power);
		System.out.println("=====================");
	}
	
	
}
