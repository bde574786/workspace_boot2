package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTextArea;


public class Server extends ServerPanel implements ActionListener {

	Server mContext = this;

	
	private ServerSocket serverSocket;
	private UserSocket u;
	int port;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	private Vector<UserSocket> userInfo = new Vector();
	private Vector<RoomInfomation> roomInfo = new Vector();

	boolean mainFlag;
	boolean threadFlag;

	public Server() {
		addEventListener();
	}

	private void addEventListener() {
		startBtn.addActionListener(this);
		saveBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int state = 0;
		if (e.getSource() == startBtn) {
			try {
				if (portTextField.getText().length() == 0) {
					textArea.append("값을 입력하세요\n");
				} else {
					port = Integer.parseInt(portTextField.getText());
					startServer();

					portTextField.setEditable(false);
					startBtn.setEnabled(false);
					state = 1;
				}
			} catch (NumberFormatException e2) {
				textArea.append("숫자만 입력하세요\n");
			}

			if (state == 1) {
				textArea.append("서버를 실행합니다\n");
				textArea.append("클라이언트 기다리는 중 ...\n");
				System.out.println(port);

			}
		} else if (e.getSource() == saveBtn) {
			saveLog();
		}

	}

	private void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			connect();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
		}

	}

	private void connect() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("클라이언트 대기");
						Socket socket = serverSocket.accept();

						textArea.append("연결되었습니다.\n");
						UserSocket userSocket = new UserSocket(mContext, socket);
						userSocket.start();
						userInfo.add(userSocket);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

	}

	public void broadcast(String msg) {
		for (int i = 0; i < userInfo.size(); i++) {
			userInfo.get(i).sendMessage(msg);
			
		}
	}

	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + '\n');
			bufferedWriter.flush();
//			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveLog() {
		File file = new File("log.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(textArea.getText());
			bw.flush();
//			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	class RoomInfomation {

		String roomName;
		Vector<UserSocket> roomUserInfo = new Vector<UserSocket>();

		public RoomInfomation(String roomName, UserSocket u) {
			this.roomName = roomName;
			this.roomUserInfo.add(u);
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < roomUserInfo.size(); i++) {
				UserSocket u = roomUserInfo.elementAt(i);
				u.sendMessage(str);
			}
		}

		// 유저 추가
		private void addUser(UserSocket u) {
			roomUserInfo.add(u);
		}

		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserSocket u) {
			roomUserInfo.remove(u); // 지정된 인덱스 삭제
			boolean empty = roomUserInfo.isEmpty(); // 벡터가 비어있으면 true 반환
			if (empty) {
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation r = roomInfo.elementAt(i);
					if (r.roomName.equals(roomName)) {
						roomInfo.remove(this);
						broadcast("EmptyRoom/" + roomName);
						broadcast("UserData_Updata/ok");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
