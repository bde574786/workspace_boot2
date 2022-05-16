package ch01;

public class MainTest3 {

	public static void main(String[] args) {

		
		ICalc iCalcAdd = (a, b, c) -> {
			return a + b + c;
		};
		
		ICalc iCalcMinus = (a, b, c) -> {
			return a - b - c;
		};
		
		// 실행문이 한 문장인 경우 중괄호와 return 키워드를 생략할 수 있다.
		ICalc iCalcMulti = (a, b, c) -> {
			return a * b * c;
		};
		
		System.out.println(iCalcAdd.calc(1, 1, 1));
		System.out.println(iCalcMinus.calc(1, 1, 1));
		System.out.println(iCalcMulti.calc(1, 1, 1));
		
		
	}

}
