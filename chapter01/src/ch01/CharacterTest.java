package ch01;

public class CharacterTest {

	public static void main(String[] args) {
		
		char ch1 = 'A';
		System.out.println(ch1);
		System.out.println((int)ch1);
		
		char ch2 = 66;
		System.out.println(ch2);
		System.out.println((int)ch2);
		
		// 주의점 char 타입은 음수값으로 대입 불가
		// char ch3 = -67;

		// 문제 안녕하세요를 정수값 하나 하나씩 표시해주세요
		// 안 --> 
		// 녕 -->
		// 하 -->
		// 세 -->
		// 요 -->

		// 인코딩
		System.out.println((int)'안');
		System.out.println((int)'녕');
		System.out.println((int)'하');
		System.out.println((int)'세');
		System.out.println((int)'요');
		
		System.out.println("================");

		// 디코딩
		 System.out.print((char)50504);
	     System.out.print((char)45397);
	     System.out.print((char)54616);
	     System.out.print((char)49464);
	     System.out.print((char)50836);
	     
	     
	     
	}

}
