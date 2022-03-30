package ch03;

import java.util.Scanner;

public class UserInfo {

	// 변수
	// 메서드
	// 함수
	Scanner scanner = new Scanner(System.in);
	// 클래스 설계 도면
	
	int  id = scanner.nextInt();
	String pw = getPwd();;
	String name;
	String gender;
	String email;
	String phoneNumber;

	public void userSignUp() {
		System.out.println("회원가입하기");
	}
	
	
	public String getPwd() {
		System.out.println("아이디");
		return "1234";
	}

	
	
}
