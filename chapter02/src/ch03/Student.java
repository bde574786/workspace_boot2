package ch03;

public class Student {

	int studentId;
	String studentName;
	String address;

	// 메서드를 정의
	public void study() {
		System.out.println(studentName + "이(가) 학생이 공부를 합니다.");
	}

	public void breakTime() {
		System.out.println(studentName + " 학생이 휴식을 합니다.");
	}

	public void showStudentInfo() {
		System.out.println("=========상태 창===========");
		System.out.println("학생의 ID : " + studentId);
		System.out.println("학생의 이름 : " + studentName);
		System.out.println("학생의 주소 : " + address);
		System.out.println("=========================");
	}

	// 함수와 메서드의 차이점
	// 메서드란
	// 자바에서 메서드란 객체의 기능을 구현하기 위해서 클래스 내부에 구현되는 메서드
	// 멤버 함수(member function)
	// 결론 : 메서드를 구현함으로써 객체의 기능이 구현됩니다.

	// 1. 시험을 친다.
	public void takeTest() {
		System.out.println(studentName + " 학생이 시험을 칩니다.");
	}

	// 2. 청소를 한다.
	public void cleanUp() {
		System.out.println(studentName + " 학생이 청소를 합니다.");
	}
		// 리턴값 있는 메서드 만들기
	public String getStudentName() {
		return studentName;
		}
		
	public int getStudentid() {
		 return studentId;
	}
}
