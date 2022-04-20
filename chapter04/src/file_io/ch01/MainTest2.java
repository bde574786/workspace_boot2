package file_io.ch01;

import java.io.IOException;

public class MainTest2 {

	public static void main(String[] args) {
		
		System.out.println("알파벳 여러 개 쓰고 엔터");
		
		int i;
		
		try {
			// 알파벳 여러개를 쓰고 화면에 출력할 수 있도록 코드를 변경 ???
			i = System.in.read();
			System.out.println(i);
			
			// A를 입력하던 B를 입력하던 엔터가 아니면 반복함
			// \n(엔터) --> false : 반복문 종료
			while( ( i = System.in.read() ) != '\n' ){
				System.out.print("i : + " + i + " ");
				System.out.print((char)i);
				System.out.println("\t");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
