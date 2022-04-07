package tenco.com.test_01.ch01;

public class Powder extends Material {

	@Override
	public String toString() {
		
		return "재료는 Powder입니다";
				
	}

	@Override
	public void doPrinting() {
		System.out.println("파우더로 출력합니다");
	}
	
}
