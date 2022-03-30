package ch09;

public interface BookDao {

	// 저장하는 메서드
	void insertUserInfo(Book book);
	// 수정하는 메서드
	void updateUserInfo(Book book);
	// 삭제하는 메서드
	void deleteUserInfo(Book book);
	// 출력하는 메서드
	void printUserInfo(Book book);
	
	
}
