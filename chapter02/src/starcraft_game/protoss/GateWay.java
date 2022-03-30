package starcraft_game.protoss;

import java.util.Scanner;

import starcraft_game.Unit;

public class GateWay {
	
	private final int ZEALOT = 1;
	private final int DRAGOON = 2;
	
	
	
	// 1. 질럿을 생산하는 메서드
	private Zealot makeZealot() {
		System.out.println("질럿을 생산합니다.");
		return new Zealot();
	}
	// 2. 드라군을 생산하는 메서드
	private Dragoon makeDragoon() {
		System.out.println("드라군을 생산합니다.");
		return new Dragoon();
	}
	// 3. 다크 템플러를 생산하는 메서드
	private DarkTempler makeDarkTempler() {
		System.out.println("다크 템플러를 생산합니다.");
		return new DarkTempler();
	}
	
	// 단, 1,2,3, 캡슐화 (private)
	//4. 외부에서 접근할 수 있는 메서드 만들기
	// (메서드에 대한 이름을 고민)
	// 1,2,3 메서드를 활용해서 만들기
	// 단 스캐너를 1. 질럿, 2.드라군, 3.다크 템플러 생산
	// 그리고 생산한 유닛을 반드시 리턴 시키기 !!!

	public Protoss createProtossUnit() {
		System.out.println("  >>>  1. 질럿 2. 드라군 3. 다크템플러  <<<  ");
		Scanner sc = new Scanner(System.in);
		int userinput = sc.nextInt();
		Protoss protoss;
		if(userinput == ZEALOT) {
			protoss = makeZealot();
		}else if(userinput == DRAGOON) {
			protoss = makeDragoon();
		} else {
			protoss = makeDarkTempler();
		}
		sc.close();
		return protoss;
		
	}
	
	
	
}	

