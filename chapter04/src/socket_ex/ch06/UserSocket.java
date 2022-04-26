package socket_ex.ch06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class UserSocket extends Thread {

	ServerFile mContext;
	Socket socket;
	// 버퍼 리더 달기 -> 읽음
	BufferedReader bufferReader;
	BufferedWriter bufferedWriter;

	// 의존성 컴포지션 관계
	public UserSocket(ServerFile mContext, Socket socket) {
		// 생성자 객체가 메모리에 올라 갈 때 필요한 데이터 초기화
		this.mContext = mContext;
		this.socket = socket;
		try {
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메시지를 보내고 싶을 때를 일 못하니까 writer을 메서드화 시킴
	@Override
	public void run() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						String msg = bufferReader.readLine();
						System.out.println("서버 --> UserSocket : msg : " + msg);
						mContext.broadcast(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
	}
	
	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}
