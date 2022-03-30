package ch07;

import java.util.Scanner;

public class MakeReport {

	private String str = "";
	private String line = "=============================\n";
	private String title = "이름\t\t\t 주소 \t\t  전화번호     \n";
	
	String name;
	String address;
	String phoneNumber;
	
	public MakeReport() {
		// 필요값이 있으면 초기화 한다.
		// 이스케이프 문자(제어문자)
		// 인쇄할 수 없거나 키보드로 표현할 수 없는 특별한 문자를 가리킨다.
		// 역슬래시와(\) 한 개의 문자와 결합하여 사용한다
		Scanner sc = new Scanner(System.in); 
	}
	
	private void makeHeader() {
		str += line;
		str += title;
		str += line;
	}
	
	private void generateBody() {
		str += "James \t";
		str += "Seoul Korea \t";
		str += "010-2222-3333\n";	
		str += line;
		str += "Tomas \t";
		str += "NewYork US \t";
		str += "010-7777-0987\n";
	}
	
	private void makeFooter() {
		str += line;
	}
	
	
	public String getReport() {
		makeHeader();
		generateBody();
		makeFooter();
		
		return this.str;
	}
	

	
}
