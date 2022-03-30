package ch09;

import java.util.Scanner;

public class MakeReport {

	
	private StringBuilder str =  new StringBuilder("");
	private StringBuilder line = new StringBuilder("==========================\n");
	private StringBuilder title = new StringBuilder("이름\t        주소 \t\t   전화번호\n");
	

	
	public MakeReport() {
		// 필요값이 있으면 초기화 한다.
		// 이스케이프 문자(제어문자)
		// 인쇄할 수 없거나 키보드로 표현할 수 없는 특별한 문자를 가리킨다.
		// 역슬래시와(\) 한 개의 문자와 결합하여 사용한다
		Scanner sc = new Scanner(System.in); 
	}
	
	public void showInfo() {
		str.append(line);
		str.append(title);
		str.append(line);
	}
	
	private StringBuilder name = new StringBuilder("James \t");
	private StringBuilder address = new StringBuilder("Seoul Korea \t");
	private StringBuilder number = new StringBuilder("010-2222-3333 \n");
	
	private void generateBody() {
		str.append(name);
		str.append(address);
		str.append(number);
	}
	
	private void makeFooter() {
		str.append(line);
	}
	
	
	public StringBuilder getReport() {
		showInfo();
		generateBody();
		makeFooter();
		return this.str;
	}
	

	
}
