package ch04;

import java.util.Scanner;

public class IfMainTest2 {

	public static void main(String[] args) {
		
		System.out.println("성적을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int point = sc.nextInt();
		char result = 'Z';
		
		// 1.  100 ~ 90 까지 A학점 입니다.  // 논리곱 연산을 활용해주세요 !!!
		// 2.  90 ~ 80 까지 B학점 입니다.
		// 1.  80 ~ 70 까지 C학점 입니다.
		// 1.  F학점 입니다.
		
		if( point <=100 && point >= 90 ) {
				result = 'A';
		} else if( point < 90 && point >= 80 ) {
				result = 'B';
		} else if( point < 80 && point >= 70 ) {
				result = 'C';
		} else if(point < 70 && point >= 0){
				result = 'F';
		}
		
		// 방어적 코드
		 if(result != 'Z') {
			 System.out.println("당신의 학점은 " + result +"입니다");
		 } else {
			 System.out.println("잘못된 값을 입력했습니다");
		 }
		 
		sc.close();
		 
	} // end of main

} // end of cdlass
