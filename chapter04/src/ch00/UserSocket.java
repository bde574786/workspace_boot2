package ch00;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import lombok.Data;

@Data
public class UserSocket extends Thread {

	private ServerFile mContext;
	private Socket socket;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	public UserSocket(ServerFile mContext, Socket socket) {
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

	@Override
		public void run() {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						try {
							String msg = bufferedReader.readLine();
							System.out.println("서버 메시지 " + msg);
							mContext.broadcast(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

		}

	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + '\n');
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
