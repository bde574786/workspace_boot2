package ch12;

class Cal {

	public int sum(int n1, int n2) {
		return n1 + n2;
	}

	public int multiply(int n1, int n2) {
		System.out.println("부모 입장에서 메서드가 호출");
//		if(n1 == 0 || n2 == 0) {
//			System.out.println("0을 입력하시 마세요");
//		}
		return n1 * n2;
	}

}

class Cal2 extends Cal {

	public int minus(int n1, int n2) {
		return n1 - n2;
	}

	// 사용자한테 0을 입력하면 화면에 0을 입력하지 마시오 !!!
	// 메서드 오버라이드 (자바 언어의 특징)
//	@Override // <--어노테이션 (주석과 같은 기능)
//	public int multiply(int n1, int n2) {
//		System.out.println("자식 입장에서 메서드가 호출");
//		if (n1 == 0 || n2 == 0) {
//			System.out.println("0을 입력하지 마시오");
//		}
//		return n1 * n2;
//	}

}

public class MainTest2 {

	public static void main(String[] args) {

		Cal2 cal2 = new Cal2();
		System.out.println(cal2.sum(5, 3));
		System.out.println(cal2.minus(10, 5));
		System.out.println(cal2.multiply(10, 0));
		// 자식에서 가지고 있는 메서드가 호출이 먼저 호출되고
		// 자식 입장에서 호출하는 메서드가 없으면 부모에서 호출한다.

	}

}
