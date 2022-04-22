package socket_ex.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

	Socket socket;
	BufferedWriter bufferedWriter; // 소켓에다가 연결한 ouputStream
	final String IP = "localhost"; // 자기 자신을 나타내는 주소 (127.0.0.1) 문자열로 자기자신을 나타냄 localhost
	final int PORT = 10000;

	BufferedReader keyboardBufferedReader; // 키보드에 연결할 스트림

	// 서버에서 보낸 메세지를 읽기 위해 buffer 장착
	// 새로운 스레드가 필요해 !!!
	BufferedReader bufferReader;

	public ClientFile() {
		try {
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 키보드에 연결
			System.out.println("3. 키보드 버퍼 연결");
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			// 초기화 처리
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 쓰레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			
			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
			
			while (true) {
				System.out.println("4. 키보드 입력 대기");
				String msg = keyboardBufferedReader.readLine(); // 입력 대기 중 ...

				// 사용자 문자열을 받았으면 보내야 한다 -->
				// 중요 : 메세지 끝을 알려줘야 한다.
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();

				bw.write(msg);
				bw.flush();

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				keyboardBufferedReader.close();
				bufferReader.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 내부 클래스 생성
	private class ReadThread implements Runnable {
		@Override
		public void run() {

			while (true) {
				try {
					String msg = bufferReader.readLine();
					System.out.println("서버로부터 받은 메세지 : " + msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new ClientFile();

	}

}
