package socket_ex.ch06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ServerFile {

	JPanel panel;
	JButton button;

	ServerFile mContext = this;
	ServerSocket serverSocket; // 다른 클라이언트 연결대기 (원하는 포트 번호 설정)
	Vector<UserSocket> sockets = new Vector();
	
	public ServerFile() {
		System.out.println("1. >>>> 서버 소켓 시작 <<<<");
		try {
			serverSocket = new ServerSocket(10000);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				// 새로운 소켓 생성(실제 통신할 녀석)
				while (true) {
					try {
						Socket socket = serverSocket.accept();
						UserSocket userSocket = new UserSocket(mContext, socket);
						userSocket.start();
						sockets.add(userSocket);
						System.out.println("계속 도나요??");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		

	}
	
	// 생성된 UserSocket에 접근해서 하나씩 메세지 보내기
	// 방송하다(전체방송)
	public void broadcast(String msg) {
		for(int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new ServerFile();
	}

}
