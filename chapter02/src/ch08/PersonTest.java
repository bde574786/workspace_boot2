package ch08;

public class PersonTest {

	public static void main(String[] args) {

		Person person = new Person();
		person.showInfo();

		Person person2 = new Person("홍길동", 30);
		person2.showInfo();
		
		System.out.println(person2.getPerson());
		
	}

}
