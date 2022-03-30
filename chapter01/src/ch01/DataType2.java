package ch01;

public class DataType2 {

	public static void main(String[] args) {
		
		char name; // 2바이트 공간에 문자를 담을 수 있다.
		char a;
		char initial;

		// 값을 초기화 하는 방법
		name = 'A';
		name = 'B';
		// name = 'AB'; // 하나의 문자만 담을 수 있기 때문이다.
		
		System.out.println(name);
		System.out.println('a');
		System.out.println('b');
		System.out.println('c');

	}

}
