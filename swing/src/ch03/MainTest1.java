package ch03;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		MyComponents components = new MyComponents();

		Scanner scanner = new Scanner(System.in);
		System.out.println("글자를 입력하세요");
		String userInput = scanner.nextLine();
		
		
		components.textField.setText("userInput");
		
	}

}
