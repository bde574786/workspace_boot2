package ch04;

import java.util.Scanner;

public class IfMainTest {

	public static void main(String[] args) {
		// 제어문 if
		// 주어진 조건에 따라서 실행이 이루어지도록 구현
		// 만약... 이라면
		
		boolean flag = false;
		// if 문 단독
		if(flag) {
			System.out.println("조건식이 true이면 여기 구문이 실행됩니다.");
		} // end of if 
		
		//if else 문
		if(flag) {
			System.out.println("true 가 실행됩니다."); // 1
		}else {
			System.out.println("false 가 실행됩니다."); // 2
		}
		
		
		
		System.out.println("성적을 입력하세요");
		Scanner sc = new Scanner(System.in) ;
		int point =  sc.nextInt();
		
		// if else if else 문법
		// int point  = 50;  // <-- Scanner sc (여러분이 입력한 값을 받아서 코드를 흐르게 합시다.)
				
		if(point >= 90) {
			System.out.println("A 학점 입니다.");
		} else if(point >= 80) {
			System.out.println("B 학점 입니다.");
		} else if(point >= 70) {
			System.out.println("C 학점 입니다.");
		} else if(point >= 60) {
			System.out.println("D 학점 입니다.");
		} else {
			System.out.println("F 학점 입니다.");
		}
		
		
	} 

}
