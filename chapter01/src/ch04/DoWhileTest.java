package ch04;

public class DoWhileTest {

	public static void main(String[] args) {
		
		/* <-- 여러 줄 주석
		while(조건식) {
			// 증감식
		}
		*/
		
		/*
		do {
			// 수행식
		} while(조건식) {
		*/

		int num = 1;
		int sum = 0;
	
		
		// do ~ while
//		do {
//			System.out.println("현재 값: " +  num);
//			// sum = num + sum;
//			sum += num;
//			num++;
//		} while(num <= 10);
//		
//		System.out.println("연산에 대한 결과 값 : " + sum);
		
		
		// 문제 1.
		// input = 10, inputSum
		// 변수 2개를 선언해서 10, 9, 8, 7
		
		int input  = 10;
		int inputSum = 0;
		
		do {
			System.out.println("현재 값: " + input);
			// sum = num + sum;
			inputSum += input;
			input--;
		} while(input != 0);
		
		System.out.println("결과 값 : " + inputSum);
		
		
		
		
		
	}
		
	
	
}

