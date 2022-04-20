package Stream_Ex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx3 {

	public static void main(String[] args) {

		InputStream in = System.in; // 키보드에 연결
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir); // String으로 받을 수 있다.
		// 통신에는 항상 인코딩 디코딩이 들어간다 (버퍼가 달려있다)
		
		
		try {
			//"HEL" + "LO";                            
			String data = br.readLine();
			System.out.println(data);

		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}

	}
	
	// 1. 양 끝단에 버퍼의 크기를 맞춘다.
	// 2. 버퍼가 가득차면 자동 전송된다.(flush) 보내면 비워짐
	// HEL을 보내면 HEL로 맞추고 남은 LO로 크기 맞춤 

}
