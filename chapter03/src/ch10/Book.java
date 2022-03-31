package ch10;

public class Book {

	private int bookId;
	private String bookTitle;
	private String author;
	
	
	public Book(int bookId, String bookTitle, String author) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	 
	
	
	
	
	 
}
