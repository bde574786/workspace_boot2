package chapter_03_boot;

public class ShortCircuitTest {

	public static void main(String[] args) {
		int num1 = 10;
		int i = -1;
		// 15 < 10 --> false이므로 논리곱 연산에서 이미 결과값은 정해졌기 때문에 뒤 항은 평가하지 않음
		boolean value = ((num1 = num1 + 1) > 100) && ((i = i + 2) < 10); // i의 값이 변경되지 않음
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);  // -1출력

		System.out.println("=================");
		//15 < 10 --> false || i(2) 2 + 2 < 10 --> true
		value = ( (num1 = num1  +101) < 10) || ( (i = i + 2) < 10 ); //  i의 값이 변경되었음
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i); // 1출력
		
	}

}
