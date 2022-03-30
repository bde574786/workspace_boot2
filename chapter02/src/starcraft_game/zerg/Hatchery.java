package starcraft_game.zerg;

import java.util.Scanner;

import starcraft_game.protoss.Protoss;

public class Hatchery {

	final int ZERGLING = 1;
	final int HYDRA = 2;
	final int ULTRA = 3;
	
	private Zergling makeZergling() {
		System.out.println("저글링을 생산합니다.");
		return new Zergling();
	}
	
	private Hydra makeHydra() {
		System.out.println("히드라를 생산합니다.");
		return new Hydra();
	}
	
	private Ultra makeUltra() {
		System.out.println("울트라를 생산합니다.");
		return new Ultra();
	}
	
	public Zerg createZergUnit() {
		System.out.println("  >>>  1. 저글링 2. 히드라 3. 울트라  <<<  ");
		Scanner sc = new Scanner(System.in);
		int userinput = sc.nextInt();
		
		Zerg zerg;
		if(userinput == ZERGLING) {
			zerg = makeZergling();
		}else if(userinput == HYDRA) {
			zerg = makeHydra();
		} else {
			zerg = makeUltra();
		}
		sc.close();
		return zerg;
		
	}
	
}
