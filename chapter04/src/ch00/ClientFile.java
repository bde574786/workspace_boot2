package ch00;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ClientFile extends BaseFile {

	JOptionPane optionPane;
	JPanel panel;
	JTabbedPane tab;
	JLabel label;
	JTextField hostIPTextField;

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

	public ClientFile() {
		initData();
//		addEventListener();
//		connectServer();
//		start();  
//		msgToServer();
//		receiveMsgFromServer();

	}

	@Override
	protected void initData() {
		super.initData();
		connectBtn = new JButton("서버 연결");
		cancelBtn = new JButton("취소");

		String msg = JOptionPane.showInputDialog(null, "포트 번호를 입력하세요", "Server_Port", JOptionPane.OK_CANCEL_OPTION);
		while (true) {
			if (msg == null) {
				JOptionPane.showMessageDialog(null, "다시 시도하세요");
				break;
			} else {

			}

		}

		
	}
	private void inputPortNumber() {
		connectBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connectBtn) {
			
		}else {
			System.exit(0);
		}
	}
	
	
	
		//		tab = new JTabbedPane(JTabbedPane.BOTTOM);
//		setLayout(null);
//		tab.setBounds(10, 10, 460, 320);
//		add(tab);
//
//		panel = new JPanel();
////		panel.setSize(100, 100);
////		panel.add(new JButton("버튼1"));
//		tab.addTab("서버 연결", panel);
//		panel.setLayout(null);
//
//		label = new JLabel("HostIP");
//		label.setBounds(20, 20, 200, 100);
//		panel.add(label);
//		hostIPTextField = new JTextField();
//
//		hostIPTextField = new JTextField();
//		hostIPTextField.setBounds(75, 62, 199, 25);
//		panel.add(hostIPTextField);
//
//		panel = new JPanel();
////		panel.add(new JButton("버튼2"));
//		tab.add("채팅", panel);
//		
//		
//		
//		
//		
//		panel = new JPanel();
////		panel.add(new JButton("버튼3"));
//		tab.add("기타", panel);

	
///////////////
//	private void addEventListener() {
//		connectBtn.addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == connectBtn) {
////			connectServer();
//		}
//
//	}
//
//	public void start() {
//		try {
//
//			socket = new Socket(IP, PORT);
//			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
//			System.out.println("키보드 연결");
//			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//			// 초기화 처리
//			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//			// 새로운 쓰레드 시작
//			ReadThread readThread = new ReadThread();
//			Thread thread = new Thread(readThread);
//			thread.start();
//
//			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
//			mainFlag = true;
//
//			while (mainFlag) {
//				System.out.println("4. 키보드 입력 대기");
//				String msg = keyboardBufferedReader.readLine(); // 입력 대기 중 ...
//
//				// 사용자 문자열을 받았으면 보내야 한다 -->
//				// 중요 : 메세지 끝을 알려줘야 한다.
//				bufferedWriter.write(msg + "\n");
//				bufferedWriter.flush();
//
//				bw.write(msg);
//				bw.flush();
//
//			}
//
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			mainFlag = false;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
////////////////
//	private void receiveMsgFromServer() {
//		try {
//			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			Thread thread = new Thread(new ReadThread());
//			thread.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	private void msgToServer() {
//		try {
//			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//			
//			while (true) {
//				System.out.println("4. 키보드 입력 대기");
//				String msg = keyboardBufferedReader.readLine(); // 입력 대기 중 ...
//
//				// 사용자 문자열을 받았으면 보내야 한다 -->
//				// 중요 : 메세지 끝을 알려줘야 한다.
//				bufferedWriter.write(msg + "\n");
//				bufferedWriter.flush();
//
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	private void connectServer() {
//		try {
//			socket = new Socket(IP, PORT);
//			network();
//		} catch (UnknownHostException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private void network() {
//
//	}

//		try {
//			System.out.println("클라이언트 소켓 시작");
//			socket = new Socket(IP, PORT);
//			
//			System.out.println("버퍼 연결");
//			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			
//			System.out.println("키보드 버퍼 연결");
//			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
//		
//			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			
//			Thread thread = new Thread(new ReadThread());
//			thread.start();
//			
//			BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
//			
//			while(true) {
//				System.out.println("키보드 입력 대기");
//				String msg = keyboardBufferedReader.readLine();
//				
//				bufferedWriter.write(msg + "\n");
//				bufferedWriter.flush();
//				
//				bw.write(msg);
//				bw.flush();
//			}
//			
//			
//			
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				bufferedWriter.close();
//				keyboardBufferedReader.close();
//				bufferedReader.close();
//				socket.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}

	//////////
//	private class ReadThread implements Runnable {
//		@Override
//		public void run() {
//			threadFlag = true;
//			while (threadFlag) {
//				try {
//					String msg = bufferedReader.readLine();
//					System.out.println("서버로부터 메세지가 도착했습니다\n" + msg);
//				} catch (IOException e) {
//					e.printStackTrace();
//					threadFlag = false;
//				}
//			}
//		}
//
//	}
///////////
	public static void main(String[] args) {
		new ClientFile();
	}

}
