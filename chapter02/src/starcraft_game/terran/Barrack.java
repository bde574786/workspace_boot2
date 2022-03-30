package starcraft_game.terran;

import java.util.Scanner;

import starcraft_game.protoss.Protoss;

public class Barrack  {

	final int MARINE = 1;
	final int FIREBAT = 2;
	
	
	private Marine makeMarine() {
		System.out.println("마린을 생산함니다.");
		return new Marine();
	}
	
	private FireBat makeFireBat() {
		System.out.println("파이어 뱃을 생산함니다.");
		return new FireBat();
	}
	
	public Terran createTerranUnit() {
		System.out.println("  >>>  1. 마린 2. 파이어뱃  <<<  ");
		Scanner sc = new Scanner(System.in);
		int userinput = sc.nextInt();
		
		Terran terran;
		if(userinput == MARINE) {
			terran = makeMarine();
		}else {
			terran = makeFireBat();
		}
		sc.close();
		return terran;
	
	}
}
