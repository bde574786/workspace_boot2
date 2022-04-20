package ch03;

import java.util.Scanner;

public class Callee {

	ICaller iCaller;
	String message = "안녕하세요";
	
	
	public Callee(ICaller iCaller) {
		this.iCaller = iCaller;
		iCaller.Message(message);
	}
	
	
	
	
	
	
	
}
