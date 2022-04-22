package ch00;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane;
	private JTextField PortTextField;
	private JTextArea textArea;
	private JLabel portNumLabel;
	private JButton serverStartBtn;
	private JButton serverStopBtn;

	// Network 자원
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;

	// 그외 자원들
	private Vector<UserInfomation> userInfo = new Vector<UserInfomation>();
	private Vector<RoomInfomation> roomInfo = new Vector<RoomInfomation>();

	public Server() {
		init();
		addListener();
//		PortTextField.requestFocus();
	}

	// GUI 초기화
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 309, 229);
		textArea = new JTextArea();
		textArea.setBounds(12, 11, 310, 230);
		scrollPane.add(textArea);
		contentPane.add(scrollPane);
		textArea.setEditable(false);

		portNumLabel = new JLabel("포트번호 :");
		portNumLabel.setBounds(12, 273, 82, 15);
		contentPane.add(portNumLabel);

		PortTextField = new JTextField();
		PortTextField.setBounds(98, 270, 224, 21);
		contentPane.add(PortTextField);
		PortTextField.setColumns(10);

		serverStartBtn = new JButton("서버실행");
		serverStartBtn.setBounds(12, 315, 154, 23);
		contentPane.add(serverStartBtn);

		serverStopBtn = new JButton("서버중지");
		serverStopBtn.setBounds(168, 315, 154, 23);
		contentPane.add(serverStopBtn);
		serverStopBtn.setEnabled(false);

		setVisible(true);
	}

	// 이벤트 리스너
	private void addListener() {
//		PortTextField.addActionListener(this);
		serverStartBtn.addActionListener(this);
		serverStopBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//
		if (e.getSource() == serverStartBtn) {
			if (PortTextField.getText().length() == 0) {
				System.out.println("  값을 입력 하세요 ");
			} else if (PortTextField.getText().length() != 0) {

				// 값을 가져와서 port변수에 저장시키기
				port = Integer.parseInt(PortTextField.getText());
				startNetwork();

				PortTextField.setEditable(false); // 포트 필드 비활성화
				serverStartBtn.setEnabled(false); // 서버 실행 버튼 비활성화
				serverStopBtn.setEnabled(true); // 서버 중지 버튼 활성화
			}

		} else if (e.getSource() == serverStopBtn) {
			try {
				serverSocket.close();
				userInfo.removeAllElements(); // 모든 요소 삭제하고 크기를 0으로 만듦
				roomInfo.removeAllElements();
				PortTextField.setEditable(true); // 포트 필드 활성화
				serverStartBtn.setEnabled(true); // 서버 실행 버튼 활성화
				serverStopBtn.setEnabled(false); // 서버 중지 버튼 비활성화
			} catch (IOException e1) {

			}
		}
	}

	private void startNetwork() {
		try {
			serverSocket = new ServerSocket(port);
			textArea.append("서버를 시작 하겠습니다.\n");
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림", JOptionPane.ERROR_MESSAGE);
			serverStartBtn.setEnabled(true);
			serverStopBtn.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하였습니다.", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	// 쓰레드를 안쓰면 다른 사용자를 받아줄 작업자가 없음
	private void connect() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) { 
					try {
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = serverSocket.accept();

						UserInfomation useInfo = new UserInfomation(socket);
						// 각각의 스레드를 등록시켜준다.
						useInfo.start();
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		}).start();
	}

	// 전체 사용자에게 메세지를 보내는 부분
	public void broadCast(String str) {
		for (int i = 0; i < userInfo.size(); i++) {
			UserInfomation uinf = userInfo.elementAt(i); // 지정된 인덱스의 요소 반환
			// 여기서 프로토콜의 개념을 사용
			uinf.sendmessage(str);
		}
	}

	// 내부클래스
	class UserInfomation extends Thread {
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String nickName;
		String myCurrentRoomName;
		private Socket userSocket;

		private boolean roomCheck = true;

		public UserInfomation(Socket soc) {
			this.userSocket = soc;
			network();
		}

		private void network() {
			try {
				dis = new DataInputStream(userSocket.getInputStream());
				dos = new DataOutputStream(userSocket.getOutputStream());

				// 처음 접속시 유저의 id를 입력받는다.
				nickName = dis.readUTF(); // 문자열을 읽음
				textArea.append("[[" + nickName + "]] 입장\n");

				// 기존사용자들에게 신규 유저의 접속을 알린다.
//				broadCast("NewUser/" + nickName);

				// 자신에게 기존 사용자들을 알린다.
				for (int i = 0; i < userInfo.size(); i++) {
					UserInfomation userInfomation = userInfo.elementAt(i);
					sendmessage("OldUser/" + userInfomation.nickName);
				}
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation roomInfomation = roomInfo.elementAt(i);
					sendmessage("OldRoom/" + roomInfomation.roomName);
				}

				// 사용자에게 자신을 알린후 벡터에 자신을 추가한다.
				userInfo.add(this);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF();
					textArea.append("[[" + nickName + "]]" + msg + "\n");
					inmessage(msg);
				} catch (IOException e) {
					try {
						textArea.append(nickName + " : 사용자접속끊어짐\n");
						dos.close();
						dis.close();
						userSocket.close();
						userInfo.remove(this);
						roomInfo.remove(this);
						broadCast("UserOut/" + nickName);
						broadCast("ErrorOutRoom/" + myCurrentRoomName);
						broadCast("UserData_Updata/ok");
						break;
					} catch (IOException e1) {
						break;
					}
				}
			}
		}

		private void inmessage(String str) {
			StringTokenizer st = new StringTokenizer(str, "/");

			String protocol = st.nextToken();
			String message = st.nextToken();

			System.out.println("protocol : " + protocol);
			System.out.println("message : " + message);

			if (protocol.equals("Note")) {
				System.out.println(message);
				st = new StringTokenizer(message, "@");
				String user = st.nextToken();
				String note = st.nextToken();
				// 백터에서 해당 사용자를 찾아서 쪽지를 전송한다.
				for (int i = 0; i < userInfo.size(); i++) {
					UserInfomation u = userInfo.elementAt(i);
					// 쪽지는 반드시 찾은 사용자에게 메세지를 보내줘어야 한다.
					if (u.nickName.equals(user)) {
						u.sendmessage("Note/" + nickName + "@" + note);
					}
				}
			} else if (protocol.equals("CreateRoom")) {
				// 1.현재 같은 방이 존재하는지 확인한다.
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation room = roomInfo.elementAt(i);
					if (room.roomName.equals(message)) { // 만들고자하는 방이름을 확인한다
						sendmessage("CreateRoomFail/ok");
						roomCheck = false;
						break;
					} else {
						roomCheck = true;
					}
				} // end for
				if (roomCheck == true) {
					// 1.방을 생성한다.
					RoomInfomation new_room = new RoomInfomation(message, this);
					// 2. 전체 방 벡터에 생성된 방을 저장한다.
					roomInfo.add(new_room);
					// 3.사용자들에게 방과 방이름을 생성되었다고 알려준다.
					sendmessage("CreateRoom/" + message); // 자신에게 방 성공 메세지를 보낸다.
					broadCast("new_Room/" + message);
				}
			} else if (protocol.equals("Chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation r = roomInfo.elementAt(i);
					if (r.roomName.equals(message)) {
						r.roomBroadcast("Chatting/" + nickName + "/" + msg);
					}
				}
			} else if (protocol.equals("JoinRoom")) {
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation r = roomInfo.elementAt(i);
					if (r.roomName.equals(message)) {
						// 신규접속자를 알린다.
						r.roomBroadcast("Chatting/[[알림]]/(((" + nickName + " 입장))) ");
						r.addUser(this); // 해당 룸 객체에 자신을 추가시킨다.
						sendmessage("JoinRoom/" + message);
					}
				}
			} else if (protocol.equals("OutRoom")) {
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation r = roomInfo.elementAt(i);
					if (r.roomName.equals(message)) {
						r.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
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

	// 내부클래스
	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> roomUserInfo = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.roomUserInfo.add(u);
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < roomUserInfo.size(); i++) {
				UserInfomation u = roomUserInfo.elementAt(i);
				u.sendmessage(str);
			}
		}

		// 유저 추가
		private void addUser(UserInfomation u) {
			roomUserInfo.add(u);
		}

		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserInfomation u) {
			roomUserInfo.remove(u); // 지정된 인덱스 삭제
			boolean empty = roomUserInfo.isEmpty(); // 벡터가 비어있으면 true 반환
			if (empty) {
				for (int i = 0; i < roomInfo.size(); i++) {
					RoomInfomation r = roomInfo.elementAt(i);
					if (r.roomName.equals(roomName)) {
						roomInfo.remove(this);
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
