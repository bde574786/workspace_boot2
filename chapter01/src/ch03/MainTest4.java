package ch03;

public class MainTest4 {

	public static void main(String[] args) {
		// 증감 연산자, 감소 연산자
		// ++, --
		
		int num1 = 1;
		 num1++;
		 //System.out.println(num1);
		 
		 int num2 = 1;
		 num2--;
		 //System.out.println(num2);
		 
		 // 1. 증감 연산자가 뒤에 올 경우
		 int num3 = 10;
		 int num4;
		 
		 num4 = num3++;
		 //System.out.println(num4);
		 // num3(10) num4에 값을 대입하고 난 뒤 num3 값을 1증가 시킴
		 //System.out.println(num3);
	
		 // 2. 증감 연산자가 앞에 올 경우
		 int num5 = 10;
		 int num6;
		 num6 = ++num5;
		 System.out.println(num6);

		 // 3, 4, 5, 6
		 // 3 증감연산자가 뒤에 올 경우 결과를 화면에 출력		 
		 int num7 = 100;
		 int num8;
		 num8 = num7++;
		 System.out.println(num8);
		 
		 // 4 증감연산자가 앞에 올 경우 결과를 화면에 출력		 
		 int num9 = 100;
		 int num10;
		 num10 = ++num9;
		 System.out.println(num10);
		 
		 // 5 증감연산자가 뒤에 올 경우 결과를 화면에 출력
		 int num11 = 1_000;
		 int num12;
		 num12 = num11++;
		 System.out.println(num12);
		 
		 // 6. 증감 연산자가 앞에 올 경우 결과를 화면에 출력
		 int num13 = 2_000;
		 int num14;
		 num14 = ++num13;
		 System.out.println(num14);
	
	}

}
