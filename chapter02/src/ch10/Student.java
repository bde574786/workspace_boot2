package ch10;

public class Student {

	private static Student instance = new Student();
	
	private Student() {
	}
	
	// 생성자의 접근 지시 제어자가 private이면 메인에서 객체 생성을 못하고
	// 객체 생성을 못하면 객체를 참조해서 메소드를 가지고 오지 못함
	// 클래스명으로 가지고 오는 수 밖에 없음....
	// 클래스명으로 참조하려면 가장 먼저 메모리 영역에 올라가는 스태틱 메소드여야 함
	//  스태틱 메소드 안에서는 객체의 유무를 보장 할 수가 없어 자바 문법 상 오류가 생김
	// 따라서 변수에도 스태틱 키워드 붙여줌
	
	public  static Student getInstance() {
		if( instance == null) {
			instance = new Student();
		}
		return instance;


	}
	
	
	
	
}
