package Stream_Ex;

import java.io.InputStream;

public class StreamEx01 {

	public static void main(String[] args) {
		
		// 스트림을 연 상태
		InputStream in = System.in; // 키보드에 연결
		// 1. 키보드에 A를 인코딩해서 0100 0001로 컴퓨터에게 전송
		// 2. Byte Stream으로 흘러 들어간다 (Input (Stream))
		// 3. read() 메서드로 0100 0001 --> 65로 디코딩한다.
		// 4. 부호화 65를 문자 A로 변환
		// 단점 : 1byte만 받음
		// ABC A만 받음
		
		// 한글은 한 byte로 표현 못해서 한글은 깨져서 나옴????
		try {
			int data = in.read(); // 1byte(8bit)
			System.out.println(data);
			System.out.println((char)data); // 부호화
		}catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
		
	}
	
	
}
