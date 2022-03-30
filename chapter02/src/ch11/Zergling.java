package ch11;

public class Zergling {

	private static int marinesid;
	private int id;
	private String name;
	private int power;
	private int hp;

	public Zergling(String name) {
		this.name = name;
		marinesid++;
		this.id = marinesid;
		power = 5;
		hp = 10;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}

	
	public void powerUpgrade(Zergling zergling) {
		this.power += 5;
		System.out.println("저글링의 공격력을 업그레이드 하는 중 입니다.");
	}
	
	public void hpUpgrade(Zergling zergling) {
		this.hp += 5; 
		System.out.println("저글링의 체력을 업그레이드 하는 중 입니다.");
	}
	
	
	// 마린을 공격합니다.
	public void attackMarine(Marine marine) {
		System.out.println("\n저글링이 마린을 공격하였습니다.");
		marine.beAttacked(power);
	}

	// 질럿을 공격합니다.
	public void attackZealot(Zealot zealot) {
		System.out.println("\n저글링이 질럿을 공격하였습니다.");
		zealot.beAttacked(power);
	}

	// 내가 공격을 당합니다.
	public void beAttacked(int power) {
		this.hp -= power;
		if (this.hp <= 0) {
			this.hp = 0;
			System.out.println("\n------------------------");
			System.out.println(this.name + "은 사망했습니다.");
			System.out.println("------------------------");
		}

	}

	public void showInfo() {
		System.out.println("========정보창=========");
		System.out.println("이름 :" + name);
		System.out.println("아이디 : " + id);
		System.out.println("공격력 : " + power);
		System.out.println("체력 : " + hp);
		System.out.println("=====================");

	}
}