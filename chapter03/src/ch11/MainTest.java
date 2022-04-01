package ch11;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		
		// 스캐너
		BookClient bookClient = new BookClient();
		// 다형성
		BookService bookArrayList = new BookArrayList();
		BookService bookArray = new BookArray();
		
		Scanner scanner = new Scanner(System.in);

		// do while
		// ""은 객체가 생성된 상태 new String("")
		// null은 아무것도 없는 상태 new라는 키워드를쓰지 않음
//		String selectedMenu = "";
//		// 1 2 3 4
//		do {
//			System.out.println("---------------------------------------------------------------");
//			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4 책 전체 조회 5. 책 수정 0. 프로그램 종료");
//			System.out.println("---------------------------------------------------------------");
//			selectedMenu = scanner.nextLine();
//
//			if (selectedMenu.equals("0")) {
//				System.out.println("프로그램을 종료합니다.");
//				scanner.close();
//			} else if (selectedMenu.equals("1")) {
//				bookClient.printTitle();
//				String title = scanner.nextLine();
//				System.out.println("작가의 이름을 입력하세요");
//				String author = scanner.nextLine();
//				Book book = bookClient.createBook(title, author);
//				bookArrayList.addBook(book);
//				
//			} else if(selectedMenu.equals("2")) {
//				System.out.println("책 제목을 입력해주세요");
//				String title = scanner.nextLine();
//				bookArrayList.selectedByTitleBook(title);
//				
//			} else if(selectedMenu.equals("3")) {
//				System.out.println("삭제하려는 책 제목을 입력해 주세요");
//				String title = scanner.nextLine();
//				bookArrayList.deleteBook(title);
//				
//			} else if(selectedMenu.equals("4")) {
//				System.out.println("저장되어 있는 책 목록 조회");
//				bookArrayList.showAllBook();
//				
//			} else if(selectedMenu.equals("5")) {
//				System.out.println("수정 하려는 책 제목을 입력해주세요");
//				String savedTitle = scanner.nextLine();
//				System.out.println("새로운 책 제목을 입력하세요");
//				String title = scanner.nextLine();
//				System.out.println("새로운 작가 이름을 입력하세요");
//				String author = scanner.nextLine();
//				Book book = bookClient.createBook(title, author);
//				
//				bookArrayList.updateBook(savedTitle, book);
//			} else {
//				System.out.println("잘못된 입력입니다.");
//			}
//
//		} while (!selectedMenu.equals("0"));

		
		String selectedMenu = "";
		// 1 2 3 4
		do {
			System.out.println("---------------------------------------------------------------");
			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4 책 전체 조회 5. 책 수정 0. 프로그램 종료");
			System.out.println("---------------------------------------------------------------");
			selectedMenu = scanner.nextLine();

			if (selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
			} else if (selectedMenu.equals("1")) {
				bookClient.printTitle();
				String title = scanner.nextLine();
				System.out.println("작가의 이름을 입력하세요");
				String author = scanner.nextLine();
				Book book = bookClient.createBook(title, author);
				bookArray.addBook(book);
				
			} else if(selectedMenu.equals("2")) {
				System.out.println("책 제목을 입력해주세요");
				String title = scanner.nextLine();
				bookArray.selectedByTitleBook(title);
				
			} else if(selectedMenu.equals("3")) {
				System.out.println("삭제하려는 책 제목을 입력해 주세요");
				String title = scanner.nextLine();
				bookArray.deleteBook(title);
				
			} else if(selectedMenu.equals("4")) {
				System.out.println("저장되어 있는 책 목록 조회");
				bookArray.showAllBook();
				
			} else if(selectedMenu.equals("5")) {
				System.out.println("수정 하려는 책 제목을 입력해주세요");
				String savedTitle = scanner.nextLine();
				System.out.println("새로운 책 제목을 입력하세요");
				String title = scanner.nextLine();
				System.out.println("새로운 작가 이름을 입력하세요");
				String author = scanner.nextLine();
				Book book = bookClient.createBook(title, author);
				
				bookArray.updateBook(savedTitle, book);
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		} while (!selectedMenu.equals("0"));

		
		
		
		
		
		
		
		
	} // end of main

	
	
	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ","");
		return result2;
	}
	
	
	
	
} // end of class











