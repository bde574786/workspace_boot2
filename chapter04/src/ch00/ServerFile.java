package ch00;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lombok.Getter;

@Getter
public class ServerFile extends JFrame implements ActionListener {

	ServerFile mContext = this;

	JFrame frame;
	JLabel label;
	JScrollPane scrollbar;
	JTextArea textArea;
	JTextField portTextField;
	JButton startBtn;
	JPanel panel;

	private ServerSocket serverSocket;
	private Socket socket;
	 int port;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private BufferedReader keyboardBufferedReader;

	private Vector<UserSocket> userInfo = new Vector();
//	private Vector<RoomInfomation> roomInfo = new Vector();

	boolean mainFlag;
	boolean threadFlag;

	public ServerFile() {
		initData();
		addEventListener();
	}

	private void initData() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		frame = new JFrame();
		setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setSize(400, 300);

		panel = new JPanel();
		panel.setLayout(null);

		label = new JLabel("포트 번호");
		label.setBounds(100, 100, 50, 50);
		add(label);

		scrollbar = new JScrollPane(label);
		scrollbar.setBounds(0, 0, 160, 160);
		frame.add(scrollbar);

		setBounds(0, 100, 290, 360);
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);

		textArea = new JTextArea();
		scrollbar.setBounds(10, 10, 250, 250);
		panel.add(scrollbar);
		scrollbar.setViewportView(textArea);

		portTextField = new JTextField();
		portTextField.setBounds(10, 269, 159, 37);
		portTextField.setText("포트 번호를 입력하세요");
		panel.add(portTextField);

		startBtn = new JButton("실행");
		startBtn.setBounds(180, 270, 79, 35);
		panel.add(startBtn);

	}

	private void addEventListener() {
		startBtn.addActionListener(this);
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
						socket = serverSocket.accept();
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
			saveLog();
		}
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

	public void saveLog() {
//		for (int i = 0; i < userInfo.size(); i++) {
//			System.out.println("123");
//			try {
//				bufferedReader = new BufferedReader(new InputStreamReader(userInfo.get(i).getSocket().getInputStream()));
//				String data = bufferedReader.readLine();
//				
//				BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
//				bw.write(data);
//				bw.flush();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		StringBuffer st = new StringBuffer();

		for (int i = 0; i < userInfo.size(); i++) {
			try {
				bufferedReader = new BufferedReader(
						new InputStreamReader(userInfo.get(i).getSocket().getInputStream()));
				st.append(bufferedReader.readLine());
				BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
				bw.write(st.toString());
				bw.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

//	class RoomInfomation {
//
//		String roomName;
//
//		Vector<UserInfomation> roomUserInfo = new Vector();
//
//		public RoomInfomation(String roomName, UserInfomation user) {
//			this.roomName = roomName;
//			roomUserInfo.add(user);
//		}
//
//		public void addUser(UserInfomation user) {
//			roomUserInfo.add(user);
//		}

//	}

	public static void main(String[] args) {
		new ServerFile();
	}

}
