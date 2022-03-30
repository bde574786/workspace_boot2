package ch04;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student1 = new Student("홍길동", 1, 3);
		System.out.println(student1.name);
		System.out.println(student1.number);
		System.out.println(student1.grade);
		
//		student1.name = "홍길동";
//		student1.number = 1;
//		student1.grade = 3;
	
		Student student2 = new Student("이순신", 2, 3);
		
		
		
	}

}
