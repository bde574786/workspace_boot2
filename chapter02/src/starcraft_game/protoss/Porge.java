package starcraft_game.protoss;

// 프로토스의 공격력 또는 방어력을 업그레이드 하는 클래스입니다.
public class Porge {
	
	// 공격력 업그레이드
	public void upgradeAttack() {
		Protoss.attack++;
	}
	
	// 방어력을 업그레이드
	public void upgradeArmor() {
		Zealot.armor ++;
		Dragoon.armor++;
		DarkTempler.armor++;
	}
	
	
}
