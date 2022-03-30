package ch20;

public class MainTest {

	public static void main(String[] args) {
		
		DeskTop desktop = new DeskTop();
		MyNoteBook myNoteBook = new MyNoteBook();

		desktop.display();
		desktop.typing();
		
		myNoteBook.display();
		myNoteBook.typing();
		myNoteBook.turnOn();
		myNoteBook.turnOff();
		
		
		
	}

}
