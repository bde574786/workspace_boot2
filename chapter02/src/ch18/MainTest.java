package ch18;

import java.util.Random;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		//System.out.println(ranValue());
		
		ToyMachine toymachine = new ToyMachine();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호를 맞춰 보세요");
		int userinput = scanner.nextInt();
		int targetValue = ranValue();

		if(userinput == targetValue) {
			System.out.println(">>> 정답입니다.");
		}else {
			System.out.println("아쉽지만 꽝 !!!");
		}

		toymachine.ranValue();
		
		
	}
	
	 //랜덤 값을 뽑아 내는 함수 만들어보기
	public static int ranValue() {
		// JDK 도구
		Random random = new Random();
		// 0 부터 ~ 44까지 랜덤적인 정수값 뽑아준다.
		int value = random.nextInt(1) + 1;
		return  value;

	
		
		
	}
	
	
	
}
