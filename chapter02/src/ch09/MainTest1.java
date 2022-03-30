 package ch09;

public class MainTest1 {

	// static 메서드 (함수)
	public static void main(String[] args) {

		// StringBuilder, StringBuffer 개념을 이해해 보자.

		// heap 메모리에 인스턴스로 생성
		String a = new String("a");

		// 상수풀 메모리에 생성
		String b = "b";

		String str0 = "abc";
		System.out.println(System.identityHashCode(str0));
		String str1 = "abc";
		String str2 = "abc";

		str0 += "_0";
		System.out.println(System.identityHashCode(str0));
		// str1 += "-1";

		// 상수풀에 있는 생성된 메모리들은 immutable 성질은 가진다. 불변
		// 즉 한 번 생성된 문자열은 수정할 수 없다.
		
		// 상수풀에서는 같은 문자열이 있는지 확인을 거치고
		// 있다면 생성하지 않고 그대로 담아준다.
		// 결국 주소값을 공유하게 되는 것
		// new로 새로운 객체를 계속 생성하기 보다
		// 같은 문자열이 있다면 상수풀에 담는 것이 메모리 절약에 효율적
		
		// new String("abc"); <-- immutable
		// 같은 문자열이 들어가도 새로운 객체가 생성된다는 점에서 상수풀과 차이
		
		
		String strA = new String("A"); 
		System.out.println(strA);
		System.out.println(System.identityHashCode(strA)); // --> true
		
		strA += "_1";
		System.out.println(strA);
		System.out.println(System.identityHashCode(strA));
		
		

//		String str2 = "abc";
//		String str3 = "abc";
//		
//		
//		// 클래스 타입 (주소값 비교 합니다.)
//		// str1 == str2
//		System.out.println(str1 == str2);  // -> false
//		System.out.println("================");
//		System.out.println(str2 == str3);
		
//		// str1의 주소값을 출력해보자.
//		System.out.println(System.identityHashCode(str1));
//		System.out.println(System.identityHashCode(str2));
//		System.out.println(System.identityHashCode(str3));
	}

}
