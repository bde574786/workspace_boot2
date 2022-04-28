package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import lombok.Data;


public class UserSocket extends Thread {

	private String userName;
	private Server mContext;
	private Socket socket;
	String myCurrentRoomName;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public UserSocket(Server mContext, Socket socket) {
		this.mContext = mContext;
		this.socket = socket;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + '\n');
			bufferedWriter.flush();
//			inMessage(msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void inMessage(String msg) {
		// 토크나이저
		StringTokenizer st = new StringTokenizer(msg, "/");

		String protocol = st.nextToken();
		String message = st.nextToken();

		System.out.println(protocol);
		System.out.println(message);
		
		if ("귓말".equals(protocol)) {
			System.out.println("귓말 들어왔음");
			for (int i = 0; i < mContext.getUserInfo().size(); i++) {
				UserSocket socket = mContext.getUserInfo().elementAt(i);
				if(socket.userName.equals(message)) {
					String str = st.nextToken();
					System.out.println(socket.getName());
					
					mContext.sendMessage("귓말/" + userName + "/" + str);
					System.out.println("샌ㅇ드 메세지까지는 됬음 ");
				}
			}
		} else if ("createRoom".equals(protocol)) {
			// new RoomInfo(방이름);
			// 전체 사용자한테 새로운 방이 생겼어 방송 ~~~
		}

	}

	@Override
	public void run() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						String msg = bufferedReader.readLine();
						System.out.println("클라이언트로 부터 온 메시지 : " + msg);
						inMessage(msg);
							
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

}
