package ch10;

import java.util.ArrayList;

public class BookDaoMySql implements BookDao {

	ArrayList<Book> books = new ArrayList<Book>();
	
	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public void updateBook(int index, Book book) {
		books.set(index, book);
	}

	@Override
	public void deleteBook(int index) {
		books.remove(index);
	}

	@Override
	public void selectBook(int index) {
		System.out.println(books.get(index));
	}

	@Override
	public void selectBookAll() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
