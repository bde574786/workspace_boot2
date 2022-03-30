package ch03;

public class MainTest6 {

	public static void main(String[] args) {
		// 논리 연산자 ( &&, || ) 엠퍼센트, 버티컬 바
		// 관계 연산자와 혼합하여 많이 사용한다.
		// 연산에 결과값 true, false

		int num1 = 10;
		int num2 = 20;
		
		// true && true
		boolean flag1 = (num1 > 0) && (num2 > 0);
		System.out.println(flag1);
		
		// true && false
		flag1 = (num1 > 0) && (num2 < 0);
		System.out.println(flag1);
		
		// true || true
		boolean flag2 = (num1 > 0) || (num2 > 0);
		System.out.println(flag2);
		
		// true || true
		flag2 = (num1 > 0) || (num2 < 0);
		System.out.println(flag2);

		// 결론 : 논리곱에서 하나라도 거짓이 있으면 연산의 결과는 false이다.
		// 		논리합에서 하나라도 참이 있으면 연산의 결과는 true이다.
		System.out.println("===================");
		System.out.println(!flag2);
 		System.out.println("===================");		
		boolean flag3 = !(5 > 3);
		System.out.println(flag3);
		
	}

}
