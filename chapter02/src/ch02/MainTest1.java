package ch02;

public class MainTest1 {

	public static void main(String[] args) {

		Student s1 = new Student(); // 힙에 생성
		System.out.println(s1.height);
		System.out.println(s1.weight);
		System.out.println(s1.name);
		System.out.println(s1.a);
		System.out.println(s1.b);
	}

	public static int temp1() {
		int result = 0; //지역변수 --> 반드시 초기화 처리 해야 한다.
		return result;
	}
	
}
