package ch01;

public class DataType1 {

	public static void main(String[] args) {
		
		// 데이터 타입의 종료
		// 1. 기본 자료형(primitive data type) --> 기본 값
		// 2. 참조 타입(Reference Type) --> 주소 값
		
		// 정수형(1, 10, 500)
		// 크기가 다르다 (담을 수 있는 숫자의 크기가 제한되어 있다)
		byte b; // 1바이트 크기 (8bit)
		short s; // 2바이트 크기 (16bit)
		int i; // 4바이트 크기 (32bit)
		long l; // 8바이트 크기 (64bit)
		
		b = 127;
		//b = 128;
		b = -128; // +127 ~ - 128;
		
		// 문제 short 크기는 얼마부터 얼마까지 숫자가 들어가는가?
		s = 128;

		i = 2100000000; // int는 약 +-21억까지의 정수를 담을 수 있다.
		// i = 2200000000;
		
		l = 2200000000L; // 대문자 L은 접미사 (대소문자 가능)
		// 변수에 접근해서 값을 변경해서 화면에 출력하기
		
		
		
		// short 데이터 타입의 범위를 10진수로 값의 범위 표현
	}

}
