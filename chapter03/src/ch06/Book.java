package ch06;

public class Book {

	private int bookId;
	private String title;
	
	public Book(int bookId, String title) {
		this.bookId = bookId;
		this.title =title;
	}

	// Object 클래스에 있는 toString을 재정의
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}
	
	 //북이라는 클래스에 타이틀이 같다면 같은 객체라고 재정의 했음
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			// 북이라는 클래스 타입 들어오면 안에 접근해서 title을 확인
			// 북에 있는 멤버변수를 확인하려고 다운캐스팅
			Book tempBook = (Book)obj;
			String title = tempBook.title;
			if(this.title == title) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	
}
