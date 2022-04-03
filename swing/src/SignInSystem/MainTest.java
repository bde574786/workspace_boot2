package SignInSystem;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		// 다형성
		UserService user = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);
		String choice;

		while (true) {
			System.out.println("1. 회원가입 2. 로그인 3. 프로그램 종료");
			choice = sc.nextLine();
			if (choice.equals("1")) {
				user.createUser();
			} else if (choice.equals("2")) {
				user.loginUser();
			} else if(choice.equals("3")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 시도하세요");
			}
		}
	}

}
