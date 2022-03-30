package ch04;

public class WhileMainTest {

	// 코드 시작점 ( 메인 작업자)
	public static void main(String[] args) {

		// 1 ~ 10 까지 덧셈 연산
		int num = 1;
		int sum = 0;
		
		while(num <= 10) {
			System.out.println("현재 값 : " + num );
			sum = num;
			num++; // 변수에 접근해서 1씩 값을 증가시킴

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("연산에 대한 결과값은" + sum + "입니다.");
		
	}

}
