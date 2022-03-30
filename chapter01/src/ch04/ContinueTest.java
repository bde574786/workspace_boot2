package ch04;

import java.util.Scanner;

public class ContinueTest {

	public static void main(String[] args) {

		// 예약어 continue
		// 무시하고 진행하는 continue
		// 스캐너를 사용해서 사용자의 입력값을 받아서 배수의 갯수를 출력하는 프로그램을 만들어보세요
		// 배수 -->
		// 1 ~ 몇까지(정수)

		Scanner sc = new Scanner(System.in);
		
		System.out.println("배수 -->");		
		final int MULTIPLE = sc.nextInt();

		System.out.println("1 ~ 몇까지(정수)");
		final int MAX = sc.nextInt();
		
		final int FIRST_VALUE = 1;
		
		int num;
		int count = 0;

		for (num = FIRST_VALUE; num <= MAX; num++) {

			// 3에 배수이면 화면에 출력하지 마세요 !!!

			if (num % MULTIPLE == 0) {
				// 1
				count++;
				// count = count + 1;
				continue; // <-- 무시하고 진행하라 !!
				// 2
			}
			// System.out.println("num : " + num);

		}
		
		System.out.println( MULTIPLE + "의 배수는 " + count + "개 입니다. ");
	}

}
