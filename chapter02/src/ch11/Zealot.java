package ch11;

public class Zealot {

	private static int zealotsid;
	
	private int id;
	private String name;
	private int power;
	private int hp;
	
	public Zealot(String name) {
		this.name = name;
		zealotsid++;
		this.id = zealotsid;
		power = 5;
		hp = 30;
		
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
	// 객체와 객체를 상호 작용하게 코딩한다.


	public void powerUpgrade(Zealot zealot) {
		this.power += 5;
		System.out.println("질럿의 공격력을 업그레이드 하는 중 입니다.");
	}
	
	public void hpUpgrade(Zealot zealot) {
		this.hp += 5; 
		System.out.println("질럿의 체력을 업그레이드 하는 중 입니다.");
	}
	
	// 마린을 공격합니다.
	public void attackMarine(Marine marine) {
		// 질럿 공격력 10 <--
		System.out.println("\n질럿이 마린을 공격하였습니다.");
		marine.beAttacked(power);
	}
	// 저글링을 공격합니다.
	public void attackZergling(Zergling zergling) {
		System.out.println("\n질럿이 저글링을 공격하였습니다.");
		zergling.beAttacked(power);
	}
	// 내가 공격을 당합니다.
	public void beAttacked(int power) {
		this.hp -= power;
		if(this.hp <= 0) {
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