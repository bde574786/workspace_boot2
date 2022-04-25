package ch00;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFile extends JFrame {

	JFrame frame;
	JLabel label;
	JScrollPane scrollbar;
	JTextArea textArea;
	JTextField textField;
	JButton startBtn;
	JPanel panel;

	private ServerSocket serverSocket;
	private Socket socket;

	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private BufferedReader keyboardBufferedReader;

	boolean mainFlag;
	boolean threadFlag;

	private final int PORT = 10001;

	public ServerFile() {
		initData();
		startServer();
	}

	private void initData() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		frame = new JFrame();
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

		textField = new JTextField();
		textField.setBounds(10, 269, 159, 37);
		textField.setText("포트 번호를 입력하세요");
		panel.add(textField);

		JButton startBtn = new JButton("실행");
		startBtn.setBounds(180, 270, 79, 35);
		panel.add(startBtn);

		
		
	}

	private void startServer() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("클라이언트 대기 중");
			socket = serverSocket.accept();
			System.out.println("연결완료");
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			mainFlag = true;
			threadFlag = true;

			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();

			while (mainFlag) {
				String msg = bufferedReader.readLine();
				System.out.println("클라이언트로부터 메세지가 도착했습니다" + msg);
			}

			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
			mainFlag = false;
		}

	}

	private class WriteThread implements Runnable {
		@Override
		public void run() {
			while (threadFlag) {
				try {
					String msg = keyboardBufferedReader.readLine();
					bufferedWriter.write(msg + '\n');
					bufferedWriter.flush();
				} catch (IOException e) {
					e.printStackTrace();
					threadFlag = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		new ServerFile();
	}

}
