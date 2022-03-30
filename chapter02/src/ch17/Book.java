package ch17;

public class Book {
	
	int id;
	String title;
	//포함관계
	Author author;
	
	public Book() {
			author = new Author("정민수", 1);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
//	@Override
//	public String toString() {
//		System.out.println("작가의 대한 정보도 출력");
//		System.out.println(author.name);
//		System.out.println(author.age);
//		
//		String str = "======================================";
//		System.out.println(">>>>>>\n");
//		System.out.println("Book [id=" + id + ", title=" + title + ", author=" + author + "]");
//		System.out.println(">>>>>>\n");
//		return str;
//	}
//		
	

	
	
}
