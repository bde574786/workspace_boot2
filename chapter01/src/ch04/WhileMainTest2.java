package ch04;

import java.util.Scanner;

public class WhileMainTest2 {

	public static void main(String[] args) {

		// 상수에 담는 값을 스캐너를 사용해서 코드를 만들어 봅시다.
		System.out.println("덧셈 값을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		final int LIMIT_VALUE = sc.nextInt();

		// while 1 ~ 10 덧셈 변수 : 2개
		int num = 1;
		int sum = 0;

		while (num <= LIMIT_VALUE) {
			// sum = sum + num;
			// 복합 대입 연산자로 변경 해 보세요
			sum += num;
			num++;
		}
		System.out.println("결과값 : " + sum);
	}

}
