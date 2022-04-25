package ch00;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
import javax.swing.JTextField;

public class ClientFile extends JFrame {
	

	JOptionPane optionPane;
	JPanel panel;
	JPanel userPanel;
	JTabbedPane tab;
	JLabel label;
	JLabel hostIpLabel;
	JLabel userIdLabel;
	
	JTextField hostIpTextField;
	JTextField userIdTextField;
	
	JButton loginButton;
	
	
	
	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader keyboardBufferedReader;
	BufferedReader bufferedReader;

	JButton connectBtn;
	JButton cancelBtn;

	boolean mainFlag;
	boolean threadFlag;

	private final String IP = "localhost";
	private int PORT = 10001;
	private int portNum;

	public ClientFile() {
		initData();
		dialog();
		start();

	}

//	private void userInput() {
//		
//		setVisible(true);
//		setLocationRelativeTo(null);
//		setLayout(null);
//		setSize(400, 300);
//		
//		userPanel = new JPanel();
//		
//		hostIpLabel = new JLabel("HostIp");
//		hostIpLabel.setBounds(65, 50, 80, 30);
//		add(hostIpLabel);
//		
//		hostIpTextField = new JTextField();
//		hostIpTextField.setBounds(140, 50, 140, 30);
//		add(hostIpTextField);
//		
//		userIdLabel = new JLabel("UserId");
//		userIdLabel.setBounds(60, 120, 80, 30);
//		add(userIdLabel);
//		
//		userIdTextField = new JTextField();
//		userIdTextField.setBounds(140, 120, 140, 30);
//		add(userIdTextField);
//		
//		loginButton = new JButton("로그인");
//		loginButton.setBounds(170, 200, 80, 40);
//		add(loginButton);
//		
//	}
	
	
	
	private void initData() {
		setVisible(true);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		connectBtn = new JButton("서버 연결");
		cancelBtn = new JButton("취소");

		tab = new JTabbedPane(JTabbedPane.BOTTOM);
		setLayout(null);
		tab.setBounds(10, 10, 460, 320);
		add(tab);

		panel = new JPanel();
		panel.setSize(100, 100);
//		panel.add(new JButton("버튼1"));
		tab.addTab("서버 연결", panel);
		panel.setLayout(null);

		label = new JLabel("Host_IP");
		label.setBounds(25, 10, 200, 100);
		panel.add(label);

		hostIpTextField = new JTextField("127.0.0.1");
		hostIpTextField.setBounds(100, 50, 199, 25);
		panel.add(hostIpTextField);

		
		panel = new JPanel();
		panel.add(new JButton("버튼2"));
		tab.add("채팅", panel);

		panel = new JPanel();
		panel.add(new JButton("버튼3"));
		tab.add("기타", panel);
	}

	public void start() {

		try {
			socket = new Socket(IP, PORT);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("키보드 연결");
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			// 초기화 처리
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 쓰레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
			mainFlag = true;

			while (mainFlag) {
				System.out.println("4. 키보드 입력 대기");
				String msg = keyboardBufferedReader.readLine();

				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();

				bw.write(msg);
				bw.flush();

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

	private void dialog() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String msg = JOptionPane.showInputDialog(null, "포트 번호를 입력하세요", "Server_Port", JOptionPane.OK_CANCEL_OPTION);
						String removeBlankMsg = msg.replace(" ", "");
						portNum = Integer.parseInt(removeBlankMsg);
						break;
					} catch (NumberFormatException e) {
						System.out.println("숫자만 입력하세요");
					} catch (Exception e2) {
						System.exit(0);
					}
				}
			}
		}).start();
	}

	
	public static void main(String[] args) {
		new ClientFile();
	}

}