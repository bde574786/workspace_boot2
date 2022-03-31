package ch10;

public class MainTest {

	public static void main(String[] args) {

		Book book = new Book(1, "홍길동전", "홍길동전");
		BookClient bookClient = new BookClient();
		// 기능이 완성 되었다면
		bookClient.createdBookObj();
		bookClient.showBookInfo(0);
//		bookClient.deleteBook("홍길동전");
		
		BookDaoMySql bookDaoMySql = new BookDaoMySql();
		bookDaoMySql.addBook(book);
		
		//1. 조회 2. 생성, 3. 삭제, 4 수정
		
	}

}
