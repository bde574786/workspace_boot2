package ch16;

import ch13_1.Zealot;

public class GateWay {

	
	private int id;
	private String name;
	
	// 질럿 생산하는 메서드 만들기
	public Zealot makeZealot() {
		System.out.println("질럿을 생산합니다.");
		return new Zealot("질럿1");
	}
	
	
}
