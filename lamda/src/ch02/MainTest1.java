package ch02;

public class MainTest1 {

	public static void main(String[] args) {

		ICalc iCalc = new ICalc() {
			
			@Override
			public int add(int x, int y) {
				return x + y;
			}

//			@Override
//			public int sub(int x, int y) {
//				// TODO Auto-generated method stub
//				return x - y;
//			}
		};
		
		// 하지만 람다 표현식을 사용하기 위해서는 반드시 추상메서드가 하나이어야 한다.
		ICalc iCalcLamda = (x, y) -> x + y;

		
		
		
	}

}
