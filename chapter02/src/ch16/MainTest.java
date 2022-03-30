package ch16;

import ch15.Banana;

public class MainTest {

	public static void main(String[] args) {

		// 변수란? 어떠한 데이터를 저장하는 공간, 변하는 수
		
		Banana banana1 = new Banana();
		Banana banana2 = new Banana();
		Banana banana3 = new Banana();
		Banana banana4 = new Banana();
		Banana banana15= new Banana();
		
		int number1= 1;
		int number2= 2;
		int number3= 3;
		int number4= 4;
		int number5= 5;
		
		// 배열이란?
		// 변수란 : 연관된 데이터를 통으로 저장(관리)하기 위해 사용한다.
		// 동일한 자료형의 순차적 자료 구조
		// 인덱스 연사자 []를 이용하여 빠른 참조가 가능하다.
		// 물리적 위치와 논리적 위치가 거의 동일
		// 배열의 순서는 0부터 시작합니다. (사실 모든 프로그래밍 언어
		// 인덱스의 처음 순서는 0부터 시작한다.
		
		int[] arr1 = new int[10];
		
		int arr2[] = new int[10];
		
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		arr1[3] = 3;
		arr1[4] = 4;
		arr1[5] = 5;
		arr1[6] = 6;
		arr1[7] = 7;
		arr1[8] = 8;
		arr1[9] = 9;
		System.out.println(arr1[9]);
		
		// 인덱스 크기를 조심히 다뤄야 한다.
		//System.out.println(arr1[10]); <-- 인덱스 크기 항상 조심
		
		// 인덱스의 순서와 크키에 대한 헷갈림을 해결
		
		// n - 1;
		int[] arr3 = new int[8];
		// 인덱스의 크기 456 ( n - 1 )
		// 배열의 크기 457
		
		
		Banana[] bananas = new Banana[5];
		bananas[0] =  new Banana();
		bananas[1]  = new Banana();
		bananas[2]  = new Banana();
		bananas[3]  = new Banana();
		bananas[4]  = new Banana();
	
		for (int i = 0; i < bananas.length; i++) {
			System.out.println(bananas[i]);
		}
		
		// 배열에는 기본 데이터 타입을 담거나
		// 또는 참조변수(주소값)을 통으로 담을 수 있다.
		
	}

}
