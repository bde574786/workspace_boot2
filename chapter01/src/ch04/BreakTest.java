package ch04;

public class BreakTest {

	public static void main(String[] args) {
			
		// 예약어 break;
		// 중간에 멈추는 break
		
		for (int i = 1; i < 11; i++) {
			System.out.println("i : " +  i);
			// 소수 7 중간에 멈춰라 !!
			// 만약 i 값이 소수 7이면 멈추어라
			if(i % 7 == 0) {
				break;
			} // end of if
			
		} // end of for
		
	}

}
