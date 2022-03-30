package ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDaoMySql implements BookDao {
	
	
	ArrayList<Book> books = new ArrayList<Book>();
	
	
	@Override
	public void insertUserInfo(Book book) {
		books.add(book);
	}

	@Override
	public void updateUserInfo(Book book) {
		Scanner sc = new Scanner(System.in);
		book = books.get(sc.nextInt());
		book.setAuthor(sc.nextLine()); 
		book.setTitle(sc.nextLine());
	}

	@Override
	public void deleteUserInfo(Book book) {
		Scanner sc = new Scanner(System.in);
		System.out.println("MYSQL 저자 삭제" + book.getAuthor());
	}

	@Override
	public void printUserInfo(Book book) {
		// TODO Auto-generated method stub
		
	}


	// 인터페이스를 활용해서 기능을 구현해주세요



	// ArrayList 사용
}
