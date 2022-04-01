package ch11;

public class BookArray implements BookService {

	Book[] books = new Book[10];
	private int index = 0;

	@Override
	public void addBook(Book book) {
		books[index] = book;
		index++;
		System.out.println("저장되었습니다");
		selectedByTitleBook(book.getTitle());
		System.out.println(index);
	}

	@Override
	public void updateBook(String title, Book book) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				continue;
			} else if (books[i].getTitle().equals(title)) {
				books[i] = book;
				return;
			} 
		}
		System.out.println(title + " 책의 이름이 존재하지 않습니다.");
	}

	@Override
	public void deleteBook(String title) {
		for (int i = 0; i < books.length; i++) {
			if (books[i].getTitle().equals(title)) {
				books[i] = null;
				break;
			}
		}
		swapValue(index);
		System.out.println("삭제되었습니다.");
		showAllBook();

	}

	@Override
	public void selectedByTitleBook(String title) {
		for (int i = 0; i < books.length; i++) {
			if (books[i].getTitle().equals(title)) {
				System.out.println(books[i]);
				return;
			}
		}
	}

	@Override
	public void showAllBook() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public void swapValue(int n) {
		for (int i = 0; i < n; i++) {
			if (books[i] == null) {
				books[i] = books[i + 1];
				books[i + 1] = null;
			}

		}

	}
}