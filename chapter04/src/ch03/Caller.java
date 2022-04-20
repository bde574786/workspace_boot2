package ch03;

import java.util.Scanner;

// 메인
public class Caller implements ICaller {

	public Caller() {
		new Callee(this);
	}
	
	
	@Override
	public void Message(String message) {
		System.out.println("콜백");
		System.out.println(message);
	}

	
	
	
}
