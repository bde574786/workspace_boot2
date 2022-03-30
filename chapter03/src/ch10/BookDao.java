package ch10;

public interface BookDao {

	// 생성
	void addBook(Book book);
	
	// 수정 set(0, book)
	void updateBook(int index, Book book);
	
	// 삭제 remove(0)
	void deleteBook(int index);
	
	// 출력
	void selectBook(int index);
	
	// 전부 정보를 출력
	void selectBookAll();
	
	
	
}
