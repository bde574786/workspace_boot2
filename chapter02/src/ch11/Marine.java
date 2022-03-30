package ch11;

public class Marine {

	private static int marinesid;
	private int id;
	private String name;
	private int power;
	private int hp;

	public Marine(String name) {
		this.name = name;
		marinesid++;
		this.id = marinesid;
		power = 5;
		hp = 20;
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

	public void powerUpgrade(Marine marine) {
		this.power += 5;
		System.out.println("마린의 공격력을 업그레이드 하는 중 입니다.");
	}

	public void hpUpgrade(Marine marine) {
		this.hp += 5;
		System.out.println("마린의 체력을 업그레이드 하는 중 입니다.");
	}

	// 질럿을 공격합니다.
	public void attackZealot(Zealot zealot) {
		System.out.println("\n마린이 질럿을 공격하였습니다.");
		zealot.beAttacked(power);
	}

	// 저글링을 공격합니다.
	public void attackZergling(Zergling zergling) {
		System.out.println("\n마린이 저글링을 공격하였습니다.");
		zergling.beAttacked(power);
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