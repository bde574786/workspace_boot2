package ch09;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

			BookClient client = new BookClient();
			System.out.println();
			
			// 저장
			System.out.println("저자를 입력해주세요");
			client.setAuthor(sc1.nextLine());
			System.out.println("제목을 입력해주세요");
			client.setTitle(sc1.nextLine());
			System.out.println("책이 저장되었습니다");
			client.printUserInfo(client);
			
			
			
			// 수정
			System.out.println("수정할 아이디를 입력하세요");
			if(sc1.nextLine().equals(client.getAuthor())) {
				System.out.println("수정 옵션을 선택하세요\n1. 아이디\t2. 비밀번호");
				if(sc1.nextInt() == 1) {
					System.out.println("아이디를 수정합니다");
					System.out.println("수정할 저자를 입력하세요 : ");
					client.setAuthor(sc2.nextLine());
					System.out.println("변경되었습니다");
					client.printUserInfo(client);
					
				}else if(sc2.nextInt() == 2) {
					System.out.println("제목을 수정합니다");
					System.out.println("수정할 제목을 입력하세요 : ");
					client.setTitle(sc2.nextLine());
					System.out.println("변경되었습니다");
					client.printUserInfo(client);
				}else {
					System.out.println("잘못 입력하셨습니다.");
					
				}
				
			}else {
				System.out.println("잘못 입력하셨습니다");
			}
			
		
			// 삭제
			client.deleteUserInfo(client.getAuthor());
			
		
		
	
		
		
	}

	
	
}