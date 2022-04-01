package ch03;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		ArrayList<User> userArray = new ArrayList<>();
		UserClient client = new UserClient();
		boolean flag = true;

		while (flag) {
			int choice;
			System.out.println("===================================================================");
			System.out.println("1. 회원정보 저장 2.회원정보 보기 3. 회원정보 수정 4. 회원정보 삭제 0. 프로그램 종료");
			System.out.println("===================================================================");
			choice = sc1.nextInt();
			if (choice == 1) {
				sc1.nextLine();
				System.out.println("아이디를 입력하세요\n>>> ");
				String id = sc1.nextLine();
				System.out.println("비밀번호를 입력하세요\n>>> ");
				String password = sc1.nextLine();
				userArray.add(client.inputUser(id, password));
				System.out.println("저장되었습니다.");

			} else if (choice == 2) {
				client.showUserInfo(userArray);
			} else if (choice == 3) {
				System.out.println("수정하고자 하는 아이디를 입력하세요\n>>>");
				String id = client.removeBlank(sc2.nextLine());
				for (int i = 0; i < userArray.size(); i++) {
					if ((userArray.get(i).getId()).equals(id)) {
						System.out.println("수정할 아이디를 입력하세요");
						String updateId = client.removeBlank(sc2.nextLine());
						System.out.println("아이디를 찾을 수 없습니다.");
						System.out.println("수정되었습니다.");
						break;
					} 
				}

			} else if (choice == 4) {
				System.out.println("삭제하려는 아이디를 입력하세요\n>>>");
				String deleteId = sc3.nextLine();
				for (int i = 0; i < userArray.size(); i++) {
					if (userArray.get(i).getId().equals(deleteId)) {
						userArray.remove(i);
						client.showUserInfo(userArray);
						System.out.println("삭제되었습니다");
						return;
						
					} 
				}

			} else if (choice == 0) {
				System.out.println("프로그램을 종료합니다.");
				flag = false;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

		}

	}
}
