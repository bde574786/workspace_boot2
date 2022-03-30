package ch04;

import java.util.Scanner;

public class WhileMainTest3 {

	public static void main(String[] args) {
		
		 // 사용자가 0을 입력하면 프로그램을 종료시켜라 (스캐너)
		// 사용자가 입력한 값을 계속 덧셈하는 프로그램으로 만들어라
		
		Scanner scanner = new Scanner(System.in);
		
		int num;
		int sum = 0;
		
		// do ~ while
		
		// 실행결과 모습
		// 값을 입력하세요
		// 10 + 70 + 10
		//0 이라는 값을 입력하면 프로그램을 종료시키고 (화면에 연산에 대한 결과값을 출력하세요)
		
		
		
		System.out.println("값을 입력하세요");
		do {
			num = scanner.nextInt();
			sum += num;
		} while(num != 0); 
		System.out.println("결과값: " + sum);
		scanner.close();
	}

}
