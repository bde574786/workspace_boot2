package clone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class Server {

	private int port;
	private ServerSocket serverSocket;
	private Socket socket;
	private JTextArea textArea;

	private Vector<UserInfomation> userInfo = new Vector<UserInfomation>();
	private Vector<RoomInfomation> serverRoomInfo = new Vector<RoomInfomation>();

	private void startNetwork() {
		try {
			serverSocket = new ServerSocket(port);
			textArea.append("서버를 시작하겠습니다.\n");
			connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void connect() {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = serverSocket.accept();
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		});

	}

	public void broadCast(String str) {
		for (int i = 0; i < userInfo.size(); i++) {
			UserInfomation uinf = userInfo.elementAt(i);
			uinf.sendmessage(str);
		}
	}

	class UserInfomation extends Thread {
		private Socket userSocket;
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String nickName;
		String myCurrentRoomName;

		public UserInfomation(Socket soc) {
			this.userSocket = soc;
			network();
		}

		private void network() {
			try {
				is = userSocket.getInputStream();
				dis = new DataInputStream(is);
				os = userSocket.getOutputStream();
				dos = new DataOutputStream(os);

				nickName = dis.readUTF();
				textArea.append("[[" + nickName + "]] 입장\n");

				broadCast("NewUser/" + nickName);

				for (int i = 0; i < userInfo.size(); i++) {
					UserInfomation uinf = userInfo.elementAt(i);
					sendmessage("OldUser/" + uinf.nickName);
				}

				for (int i = 0; i < serverRoomInfo.size(); i++) {
					RoomInfomation room = serverRoomInfo.elementAt(i);
					sendmessage("OldRoom/" + room.roomName);
				}

				userInfo.add(this);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void sendmessage(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> roomUserInfo = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.roomUserInfo.add(u);
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadCast(String str) {
			for (int i = 0; i < roomUserInfo.size(); i++) {
				UserInfomation u = roomUserInfo.elementAt(i);
				u.sendmessage(str);
			}
		}

		private void addUser(UserInfomation u) {
			roomUserInfo.add(u);
		}

		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserInfomation u) {
			roomUserInfo.remove(u);
			boolean empty = roomUserInfo.isEmpty();
			if (empty) {
				for (int i = 0; i < serverRoomInfo.size(); i++) {
					RoomInfomation r = serverRoomInfo.elementAt(i);
					if (r.roomName.equals(roomName)) {
						serverRoomInfo.remove(this);
						broadCast("EmptyRoom/" + roomName);
						broadCast("UserData_Updata/ok");
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
