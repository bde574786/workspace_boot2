package ch02;

public class ConstantTest {

	public static void main(String[] args) {
		// 변수 != 상수 (상수는 변하지 않는 수)
		// 원주율 3.14, 1년 12개월

		// 예약어(미리 선정해 놓은 단어)
		final int MAX_NUM = 10;
		//MAX_NUM = 200; // 한 번 초기화 된 값은 변경할 수 없다. : 상수
		final int MIN_NUM;
		MIN_NUM = 1; // 선언 후에 단 한 번만 초기화 할 수 있다.
		
		// MIN_NUM = -1; // 사용안됨
		
		// 리터럴(literal)
		System.out.println(MAX_NUM);
		
		// MAX_NUM = 12;
		
	}

}
