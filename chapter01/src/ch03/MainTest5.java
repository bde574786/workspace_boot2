package ch03;

public class MainTest5 {

	public static void main(String[] args) {
		// 관계 연산자
		// 관찰의 결과가 참, 거짓으로 판별할 때 사용
		// 결과는 오직 true, false 반환된다.

		int num1 = 5;
		int num2 = 3;
		
		// 5 > 3 --> 반환 데이터 타입
		boolean value1 = 5 > 3;
		System.out.println(value1);
		boolean value2 = 5 < 3;
		System.out.println(value2);
		boolean value3 = (num1 == num2);
		System.out.println(value3);
		boolean value4 = 5 >= 3;
		System.out.println(value4);
		boolean value5 = 5 <= 3;
		System.out.println(value5);
		boolean value6 = 5 != 3;
		System.out.println(value6);
		
		
	}

}
