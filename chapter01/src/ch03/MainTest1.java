package ch03;

public class MainTest1 {

	// 메인작업자 (쓰레드)
	// 코드의 시작점
	public static void main(String[] args) {

		// 대입 연산자 ( = ), 연산의 방향은 오른쪽에서 왼쪽으로 연산이 됩니다.
		int number = 10;
		// 변수에 변수를 대입할 수도 있다.
		int number2 = number;

		System.out.println(number);
		System.out.println(number2);
		System.out.println("===================");

		// 부호 연산자( +, - )
		System.out.println(-number);
		System.out.println(number); // 10
		// 부호 연산자는 부호를 변경하는 연산입니다.
		// 단, 변수에 있는 실제 값을 변경한 상태는 아닙니다.
		
		// 문제 number라는 변수에 실제값을 -10으로 변경하려면 아래에 코드를 작성해 보세요.
		number = -number;
		System.out.println(number);
		
		
	} // end of main

} // end of class
