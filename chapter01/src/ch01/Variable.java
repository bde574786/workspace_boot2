package ch01;

public class Variable {

	public static void main(String[] args) {
		// 변수를 사용하는 방법
		int age; // 변수를 선언
		int count;
		
		age = 1; // 초기화 한다.(값을 넣다)
		count = 100;
		
		System.out.println(age);
		System.out.println(count);
		System.out.println("=============");
		age = 500;
		count = 1000;
		System.out.println(age);
		System.out.println(count);
		
		// 변수는 변하는 수 입니다.
		
		// 변수에 선언과 동시에 초기화
		int level = 10;
		
		// Tip
		// 변수 -> 2가지
		// 1. 기본 데이터 타입 (값)
		// 2. 참조 타입(주소값)
		
		
	} // end of main

} // end of class
