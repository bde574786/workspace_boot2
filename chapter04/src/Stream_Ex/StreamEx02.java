package Stream_Ex;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

	public static void main(String[] args) {
		
		
		InputStream in = System.in; // 키보드에 연결
		
		// 데코레이터 패턴
		InputStreamReader ir = new InputStreamReader(in); // 바이트 통신을 하는게 아니라 기능의 확장
		// 65 --> A 부호화, 추가적 기능 ...
		// 단점 !!! 
		
		try {
			// int data = in.read(); // 1byte(8bit)
			char[] data = new char[3];
			ir.read(data);
			
			// new char[1000]
			// A -> 999 개 공간 낭비
			// 미리 크기가 정해져 있어야 하기 때문에 활용도가 높지 않음
			// 잘 사용하지 않음 (특히 통신) --> 해결방안 buffer
			
			// BufferedReader
			// 1 숫자 -> 부호화
			// 2 문자를 가변적으로 받는다 -> 배열 공간의 낭비가 없다.					
			
			System.out.println(data);
		}catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
		
	}
	
	
}
