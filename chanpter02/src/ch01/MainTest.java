package ch01;

public class MainTest {

	// 코드의 시작점
	public static void main(String[] args) {
		
		System.out.println("프로그램을 시작합니다");

		int num1 = 10; // 변수의 선언과 초기화 ( 기본값 )
		int num2; // 변수의 선언
		
		Student s1; // Student 타입으로 변수를 선언(s1) (Student 클래스 타입) --> 주소값 --> 참조변수, 레퍼런스 타입이다.
		Student s2; // Student 타입으로 변수를 선언(s2)
		
		// s1 초기화 하기
		s1 = new Student(); // s1 을 초기화 했다 (값을 넣다) (주소값)
		s2 = new Student(); // s2 를 초기화 했다 (값을 넣다) (주소값)
		
//		System.out.println(num1);
//		System.out.println(s1);
//		System.out.println(s2);
		
		// s1이라는 name 이라는 변수에 접근해서 홍길동이라는 값을 넣겠다
		s1.name = "홍길동";
		s1.height = 170;
		s1.weight = 90.5;
		
		// s2에 접근해서 값을 여러분이 원하는대로 넣기 !!!
		s2.name = "이순신";
		s2.height = 190;
		s2.weight = 80.0;
		
		// s1의 height 값을 화면에 출력
		System.out.println(s1);
		System.out.println(s1.name);
		System.out.println(s1.height);
		System.out.println(s1.weight);
		System.out.println("==================");
		// s2 출력해주세요
		System.out.println(s2);
		System.out.println(s2.name);
		System.out.println(s2.height);
		System.out.println(s2.weight);
		
		
		// 클래스, 객체, 인스턴스 이해
		

		//		Student s1 = new Student();
//		
//		s1.name = "정민수"; // 문자열
//		s1.height = 180;
//		s1.weight = 75.5;
//		
//		Student s2 = new Student();
//		s2.name = "홍길동";
//		s2.height = 190;
//		s2.weight = 90.3;
	}

}
