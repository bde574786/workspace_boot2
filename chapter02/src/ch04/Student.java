package ch04;

public class Student {

	// 생성자 - constructor
	// 객체를 생성할 때 다음과 같은 모양으로 객체를 만들어라고 지시하는 것
	// 강제성 부여 하는거와 같다.
	
	int number;
	String name;
	int grade;
	
	// 기본 생성자 <-- 컴파일 시점에 자동으로 만들어줍니다.
//	public Student() {
//		
//	}
	
	
	// 사용자 정의 생성자 --> 강제성이 부여
	// 사용자 정의 생성자를 만들면 컴파일러가 기본 생성자를 만들어주지 않는다.
//	public Student(String name) {
//		
//	}
	
//	public Student(String name, int number, int grade) {
//		this.name = name;
//		this.number = number;
//		this.grade = grade;
//	}
	
	public Student(String name, int number, int grade) {
		this.name = name;
		this.number = number;
		this.grade = grade;
	}
	
	
}
