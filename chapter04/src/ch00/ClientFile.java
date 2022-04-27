package ch00;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFile extends JFrame implements ActionListener {

	ServerFile server;

	JOptionPane optionPane;
	JPanel panel;
	JPanel userPanel;
	JTabbedPane tab;

	JLabel label;
	JLabel hostIpLabel;
	JLabel userIdLabel;
	JLabel userLabel;
	JLabel roomLabel;

	JTextField hostIpTextField;
	JTextField userIdTextField;
	JTextField sendMessageTextField;
	JTextArea roomTextArea;
	JTextArea chattingArea;
	JTextArea allUserArea;

	JButton loginButton;

	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader keyboardBufferedReader;
	BufferedReader bufferedReader;

	JButton connectBtn;
	JButton cancelBtn;
	JButton createRoomBtn;
	JButton sendBtn;
	JButton joinBtn;

	boolean mainFlag;
	boolean threadFlag;

	private final String IP = "localhost";
	private int portNum;

	public ClientFile() {
		initData();
		inputPortNum();
		addListener();
	}


	private void initData() {
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		tab = new JTabbedPane(JTabbedPane.BOTTOM);
		setLayout(null);
		tab.setBounds(10, 10, 360, 240);
		add(tab);

		panel = new JPanel();
		panel.setSize(100, 100);
		tab.addTab("서버 연결", panel);
		panel.setLayout(null);

		hostIpLabel = new JLabel("HostIP");
		hostIpLabel.setBounds(80, -20, 200, 100);
		panel.add(hostIpLabel);

		hostIpTextField = new JTextField("127.0.0.1");
		hostIpTextField.setBounds(80, 50, 199, 25);
		panel.add(hostIpTextField);

		userIdLabel = new JLabel("UserId");
		userIdLabel.setBounds(80, 50, 200, 100);
		panel.add(userIdLabel);

		userIdTextField = new JTextField();
		userIdTextField.setBounds(80, 120, 199, 25);
		panel.add(userIdTextField);

		connectBtn = new JButton("서버 연결");
		connectBtn.setBounds(135, 165, 90, 20);
		panel.add(connectBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(135, 165, 90, 20);
		panel.add(cancelBtn);

		panel = new JPanel();
		panel.setLayout(null);
		createRoomBtn = new JButton("방 만들기");
		createRoomBtn.setBounds(260, 185, 85, 20);
		panel.add(createRoomBtn);

		sendBtn = new JButton("전송");
		sendBtn.setBounds(190, 185, 60, 20);
		panel.add(sendBtn);

		sendMessageTextField = new JTextField();
		sendMessageTextField.setBounds(10, 185, 169, 20);
		panel.add(sendMessageTextField);

		chattingArea = new JTextArea();
		chattingArea.setBounds(10, 10, 240, 170);
		panel.add(chattingArea);

		joinBtn = new JButton("참여");
		joinBtn.setBounds(260, 160, 85, 20);
		panel.add(joinBtn);
		tab.add("채팅", panel);

		roomTextArea = new JTextArea();
		roomTextArea.setBounds(260, 100, 85, 50);
		panel.add(roomTextArea);

		roomLabel = new JLabel("채팅방");
		roomLabel.setBounds(260, 80, 39, 15);
		panel.add(roomLabel);

		allUserArea = new JTextArea();
		allUserArea.setBounds(260, 25, 85, 50);
		panel.add(allUserArea);

		userLabel = new JLabel("전체 사용자");
		userLabel.setBounds(260, 8, 70, 15);
		panel.add(userLabel);

		cancelBtn = new JButton("종료");
		cancelBtn.setBounds(260, 210, 50, 20);

		panel = new JPanel();
		panel.add(new JButton("버튼3"));
		tab.add("기타", panel);

	}

	private void addListener() {
		connectBtn.addActionListener(this);
		createRoomBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		joinBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectBtn) {
			start();
		} else if (e.getSource() == createRoomBtn) {
			
		} else if (e.getSource() == sendBtn) {
			
		} else if (e.getSource() == joinBtn) {

		}
	}

	public void start() {
		try {
			socket = new Socket(IP, portNum);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("키보드 연결");
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			// 초기화 처리
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 쓰레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			mainFlag = true;

			while (mainFlag) {
				String msg = keyboardBufferedReader.readLine();
				System.out.println("main : " + msg);
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mainFlag = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	private class ReadThread implements Runnable {
		@Override
		public void run() {
			threadFlag = true;
			while (threadFlag) {
				try {
					String msg = bufferedReader.readLine();
					System.out.println("서버로부터 메세지가 도착했습니다\n" + msg);
				} catch (IOException e) {
					e.printStackTrace();
					threadFlag = false;
				}
			}
		}

	}

	private void inputPortNum() {
		while (true) {
			try {
				String msg = JOptionPane.showInputDialog(null, "포트 번호를 입력하세요", "Server_Port",
						JOptionPane.OK_CANCEL_OPTION);
				String removeBlankMsg = msg.replace(" ", "");
				portNum = Integer.parseInt(removeBlankMsg);
				System.out.println(portNum);
				return;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			} catch (Exception e2) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new ClientFile();
	}

}