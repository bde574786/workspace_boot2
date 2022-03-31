package ch10;

import java.util.ArrayList;
import java.util.Scanner;

public class BookClient {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Book> books = new ArrayList<Book>();
	
	// 사용자한테 Book 객체를 생성하는 메서드 기능을 만든다.
	public Book createdBookObj() {
		
		System.out.println("북 객체를 생성해 주세요!");
		int bookId = scanner.nextInt();
		String bookTitle = scanner.nextLine();
		scanner.nextLine();
		String author = scanner.nextLine();
		
		Book book = new Book(bookId, bookTitle, author);
		books.add(book);
		return book;
	}

	
	
	// 매개변수 title로 받아도 됨
	// 책의 정보를 확인하는 기능
	public void showBookInfo(int index) {
		System.out.println(books.get(index));
	}
	
	// 저장 되어 있는 책을 삭제하는 기능
	public void deleteBook(int index) {
		books.remove(index);
	}
	
	// 수정하는 기능
	public void updateBook(int index, Book book) {
		books.set(index, book);
	}
	
}
