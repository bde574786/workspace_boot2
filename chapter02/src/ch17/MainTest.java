package ch17;

public class MainTest {

	public static void main(String[] args) {

		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book();
		//System.out.println(book1);
		
		// 배열에 담아 봅시다.
		Book[] books = new Book[5];
		// 인덱스의 크기 n - 1  = 4
		// 배열의 크기 5
		
		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		books[3] = book4;
		books[4] = book5;
		
		// 수정
		books[0] = book1;
		books[1] = book1;
		books[2] = book1;
		books[3] = book1;
		books[4] = book1;
		
		// 삭제
		books[4] = null;
		
		// 출력
		for(int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}
		
		
	}

}
