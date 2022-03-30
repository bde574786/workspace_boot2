package ch05_1;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
			
//		Scanner scanner = new Scanner(System.in);
		UserInfoScanner sc = new UserInfoScanner();
		UserInfo info = sc.inputUserData();
		
		
		System.out.println("메인쪽 : " + info.id);
		System.out.println("메인쪽 : " + info.name);
		
		
	}

}
