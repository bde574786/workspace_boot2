package ch05;

import java.util.Scanner;

public class InputUserInfoScanner {

	
	// 상태 ---> 멤버 변수
	Scanner scanner;

	// 생성자 --> 기본생성자 (메모리에 올라갈 때 처음 실행 됩니다.)
	public InputUserInfoScanner() {
		scanner = new Scanner(System.in);
	}
	
	public UserInfo inputData() {
		System.out.println("사용자의 이름을 입력하세요.");
		String name =  scanner.nextLine();
		System.out.println("사용자의 아이디를 입력하세요.");
		String id = scanner.nextLine();
		printA();
		
		UserInfo user = new UserInfo();
		user.name = name;
		user.id = id;
		return user;
	}
	
	
	
	// 행위
	// 메서드를 만들어주세요
	public void  printA() {
		System.out.println("========사용자 입력========");
	}
}
