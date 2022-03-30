package ch10;

public class StudentTest {

	public static void main(String[] args) {
			
		Student student1 = Student.getInstance();
		Student student2 = Student.getInstance();
		System.out.println(System.identityHashCode(student1));
		System.out.println(System.identityHashCode(student2));
	}

}
