package ch18;

import java.util.Random;
import java.util.Scanner;

public class ToyMachine {

	String name;
	Scanner scanner = new Scanner(System.in);

	public void ranValue() {
		Random random = new Random();
		int value = random.nextInt(3) + 1;
		
		System.out.println("1~3까지 번호를 맞춰 보세요");
		int userinput = scanner.nextInt();
		
		ToyMachine toymachine;
		if (userinput == value) {
			if(userinput == 1) {
			toymachine = new Toy1("장난감1");
			} else if (userinput == 2) {
				toymachine = new Toy2("장난감2");
			} else if (userinput == 3) {
			toymachine = new Toy3("장난감3");
			}
		} else {
			System.out.println("꽝 !!");
		}

	}

}

// 장난감은 3 개 만들어줍니다.
// 사용자 랜덤 함수 사용해서 답을 맞추면
// 장난감을 반환합니다.
// 아니면 꽝 !!