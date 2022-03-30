package ch02;

public class TypeConversion {

	public static void main(String[] args) {
			
		// 데이터 형 변환 (정수값을 실수값을 변경한다.)
		// 자동 형변환, 강제 형변환
		
		int iNum1 = 100;
		System.out.println(iNum1);
		
		// 자동 형변환
		double dNum1 = iNum1;
		System.out.println(dNum1);
		
		System.out.println("========================");
		// 강제 형변환
		double dNum2 = 1.12345;
		int iNum2 = (int)dNum2; // 개발자가 컴파일러한테 괜찮으니깐 강제로 값을 넣어 !!
		System.out.println(dNum2);
		System.out.println(iNum2);
		// 강제 형 변환시 데이터의 손실이 발생할 수 있다.
		// 소수점을 그냥 버리고 정수값만 저장해 !!!
		
		// 연습
		double a;
		int b;
		
		// a의 값을 0.5 담아 보세요
		a = 0.5;
		// b의 값을 10.5를 담아 보세요
		b = (int)10.5;
		// 출력 결과값 10 (데이터 손실이 발생)
		System.out.println(b);
	} // end of main

} // end of class
