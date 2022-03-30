package ch03;

public class StudentMainTest {

	public static void main(String[] args) {
		
		Student studentKim = new Student(); // 생성과 동시에 초기화, 힙 영역
		studentKim.studentId = 1;
		studentKim.studentName = "김길동";
		studentKim.address = "부산시 진구";
		
		studentKim.study();
		studentKim.breakTime();
		studentKim.showStudentInfo();
		studentKim.cleanUp();
		studentKim.takeTest();
		
		///////////////////////////////////////////////////////
		
		Student studentLee = new Student();
		studentLee.studentId = 2;
		studentLee.studentName = "홍길동";
		studentLee.address = "부산시 해운대구";
		
		studentLee.study();
		studentLee.breakTime();
		studentLee.showStudentInfo();
		
		System.out.println("------------------------");
		// 메모리에 2개의 객체가 올라가 있다
		String name1  = studentKim.getStudentName();
		int sId1 = studentKim.getStudentid();
		System.out.println(name1);
		System.out.println(sId1);
		
		String name2 = studentLee.getStudentName();
		int sId2 = studentLee.getStudentid();
		System.out.println(name2);
		System.out.println(sId2);
		
		
		
	}

}
