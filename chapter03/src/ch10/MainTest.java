package ch10;

public class MainTest {

	public static void main(String[] args) {

		Book book = new Book();
		BookClient bookClient = new BookClient();
		// 기능이 완성 되었다면
		bookClient.createdBookObj();
		bookClient.deleteBook("홍길동전");
		
		BookDaoMySql bookDaoMySql = new BookDaoMySql();
		bookDaoMySql.addBook(book);
		
		//1. 조회 2. 생성, 3. 삭제, 4 수정
		
	}

}
