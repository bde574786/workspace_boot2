package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class UserSocket extends Thread {

	private String name;
	private Server mContext;
	private Socket socket;
	String myCurrentRoomName;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

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
		String str = "";
		StringTokenizer st = new StringTokenizer(str, "/");

		String protocol = st.nextToken();
		String message = st.nextToken();

		if ("username".equals(protocol)) {
			this.name = message;
		} else if ("귓말".equals(protocol)) {
//			mContext.
			
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
//						sendMessage("[[[[[[" + msg + "]]]]]]");
						mContext.broadcast(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

}
